/*
 *    Copyright 2016 Luke Quinane
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package tmyroadctfig.icloud4j;

import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.Map;

/**
 * A wrapper for the 'idmsa' service.
 *
 * @author Luke Quinane
 */
public class IdmsaService
{
    /**
     * The idmsa end point.
     */
    public static final String idmsaEndPoint = "https://idmsa.apple.com";

    /**
     * The idmsa end point.
     */
    public static final String idmsaAuthEndPoint = "https://idmsa.apple.com/appleauth/auth";

    /**
     * The iCloud service.
     */
    private final ICloudService iCloudService;

    /**
     * The HTTP client.
     */
    private final CloseableHttpClient httpClient;

    /**
     * The value for the idmsa 'X-Apple-ID-Session-Token' header.
     */
    private String appleIdSessionToken;

    /**
     * The value for the idmsa 'X-Apple-ID-Session-Id' header.
     */
    private String appleIdSessionId;

    /**
     * The value for the idmsa 'scnt' header.
     */
    private String scnt;

    /**
     * Creates a new idmsa service.
     *
     * @param iCloudService the iCloud service.
     */
    public IdmsaService(ICloudService iCloudService)
    {
        this.iCloudService = iCloudService;
        httpClient = iCloudService.getHttpClient();
    }

    /**
     * Attempts to log in to the idmsa endpoint.
     *
     * @param username the username.
     * @param password the password.
     * @return the status line.
     */
    public StatusLine authenticateViaIdmsa(@Nonnull String username, @Nonnull char[] password)
    {
        try
        {
            Map<String, Object> params = ImmutableMap.of(
                "accountName", username,
                "password", new String(password),
                "rememberMe", false,
                "trustTokens", new String[0]);

            HttpPost post = new HttpPost(idmsaAuthEndPoint + "/signin");
            post.setEntity(new StringEntity(new Gson().toJson(params), "application/json", Consts.UTF_8.name()));
            populateIdmsaRequestHeadersParameters(post);
            post.setHeader("Accept", "application/json");

            try (CloseableHttpResponse response = httpClient.execute(post))
            {
                Header sessionTokenHeader = response.getFirstHeader("X-Apple-Session-Token");
                if (sessionTokenHeader != null)
                {
                    appleIdSessionToken = sessionTokenHeader.getValue();
                }
                Header sessionHeader = response.getFirstHeader("X-Apple-ID-Session-Id");
                if (sessionHeader != null)
                {
                    appleIdSessionId = sessionHeader.getValue();
                }
                Header scntHeader = response.getFirstHeader("scnt");
                if (scntHeader != null)
                {
                    scnt = scntHeader.getValue();
                }

                return response.getStatusLine();
            }
        }
        catch (Exception e)
        {
            throw Throwables.propagate(e);
        }
    }

    /**
     * Validates the automatically generated verification code. When a login is attempted for newer devices, a
     * verification code will automatically be displayed. Supply that code here to complete the authentication process.
     *
     * @param code the code.
     */
    public void validateAutomaticVerificationCode(String code)
    {
        try
        {
            String authToken = sendIdmsaCode(code);
            String trustToken = getTrustToken();

            // Re-authenticate, which will both update the two-factor authentication data, and ensure that we save the
            // X-APPLE-WEBAUTH-HSA-TRUST cookie
            Map<String, Object> params = ImmutableMap.of(
                "dsWebAuthToken", authToken,
                "trustToken", trustToken,
                "extended_login", false);
            iCloudService.authenticate(params);
        }
        catch (Exception e)
        {
            throw Throwables.propagate(e);
        }
    }

    /**
     * Sends the 'idmsa' security code.
     *
     * @param code the two-factor code.
     * @return the auth token.
     * @throws IOException if an error occur.s
     */
    private String sendIdmsaCode(String code) throws IOException
    {
        String json = String.format("{\"securityCode\":{\"code\":\"%s\"}}", code);

        HttpPost post = new HttpPost(idmsaAuthEndPoint + "/verify/trusteddevice/securitycode");
        post.setEntity(new StringEntity(json, "application/json", Consts.UTF_8.name()));
        populateIdmsaRequestHeadersParameters(post);
        post.setHeader("Accept", "application/json");

        String authToken;
        try (CloseableHttpResponse response = httpClient.execute(post))
        {
            if (response.getStatusLine().getStatusCode() >= 300)
            {
                throw new IllegalStateException("Failed to verify code: " + response.getStatusLine());
            }

            authToken = response.getFirstHeader("X-Apple-Session-Token").getValue();
        }
        return authToken;
    }

    /**
     * Gets the trust token.
     *
     * @return the trust token.
     * @throws IOException if an error occur.s
     */
    private String getTrustToken() throws IOException
    {
        HttpGet httpGet = new HttpGet(idmsaAuthEndPoint + "/2sv/trust");
        populateIdmsaRequestHeadersParameters(httpGet);

        String trustToken;
        try (CloseableHttpResponse response = httpClient.execute(httpGet))
        {
            if (response.getStatusLine().getStatusCode() >= 300)
            {
                throw new IllegalStateException("Failed to get trust token: " + response.getStatusLine());
            }

            trustToken = response.getFirstHeader("X-Apple-TwoSV-Trust-Token").getValue();
        }
        return trustToken;
    }

    /**
     * Populates the HTTP request headers for idmsa requests.
     *
     * @param request the request to populate.
     */
    public void populateIdmsaRequestHeadersParameters(HttpRequestBase request)
    {
        request.setHeader("Origin", idmsaEndPoint);
        request.setHeader("Referer", idmsaEndPoint + "/");
        request.setHeader("User-Agent", "Mozilla/5.0 (iPad; CPU OS 9_3_4 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13G35 Safari/601.1");

        // Seems to be required to get a session token
        request.setHeader("X-Apple-Widget-Key", "83545bf919730e51dbfba24e7e8a78d2");

        if (!Strings.isNullOrEmpty(appleIdSessionId))
        {
            request.setHeader("X-Apple-ID-Session-Id", appleIdSessionId);
        }

        if (!Strings.isNullOrEmpty(scnt))
        {
            request.setHeader("scnt", scnt);
        }
    }
}

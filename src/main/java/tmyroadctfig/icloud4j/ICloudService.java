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

import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import org.apache.http.Consts;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import tmyroadctfig.icloud4j.util.JsonToMapResponseHandler;

import javax.annotation.Nonnull;
import java.net.URI;
import java.util.Map;

/**
 * The iCloud service.
 *
 * @author Luke Quinane
 */
public class ICloudService
{
    /**
     * The end point.
     */
    public static final String endPoint = "https://www.icloud.com";

    /**
     * The setup end point.
     */
    public static final String setupEndPoint = "https://setup.icloud.com/setup/ws/1";

    /**
     * The login info.
     */
    private final Map<String, Object> loginInfo;

    /**
     * Creates a new iCloud service instance, and attempts to log in to iCloud.
     *
     * @param clientId the client ID.
     * @param username the username.
     * @param password the password.
     */
    public ICloudService(@Nonnull String clientId, @Nonnull String username, @Nonnull char[] password)
    {
        try (CloseableHttpClient httpClient = HttpClients.createDefault())
        {
            URI uri = new URIBuilder(setupEndPoint + "/login")
                .addParameter("clientId", clientId)
                .addParameter("clientBuildNumber", "14E45")
                .build();

            Map<String, Object> params = ImmutableMap.of(
                "apple_id", username,
                "password", new String(password),
                "extended_login", false);

            HttpPost post = new HttpPost(uri);
            post.setEntity(new StringEntity(new Gson().toJson(params), Consts.UTF_8));
            post.setHeader("Origin", endPoint);
            post.setHeader("Referer", endPoint + "/");
            post.setHeader("User-Agent", "Opera/9.52 (X11; Linux i686; U; en)");

            Map<String, Object> result = httpClient.execute(post, new JsonToMapResponseHandler());
            if (Boolean.FALSE.equals(result.get("success")))
            {
                throw new RuntimeException("Failed to log into iCloud: " + result.get("error"));
            }

            loginInfo = result;
        }
        catch (Exception e)
        {
            throw Throwables.propagate(e);
        }
    }

    /**
     * Gets the login info.
     *
     * @return the login info.
     */
    public Map<String, Object> getLoginInfo()
    {
        return loginInfo;
    }
}

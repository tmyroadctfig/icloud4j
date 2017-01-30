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

package com.github.tmyroadctfig.icloud4j;

import com.github.tmyroadctfig.icloud4j.json.DriveNodeDetails;
import com.github.tmyroadctfig.icloud4j.util.JsonToMapResponseHandler;
import com.google.common.base.Splitter;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * A node in the iCloud Drive service.
 *
 * @author Luke Quinane
 */
public class DriveNode
{
    /**
     * The iCloud service.
     */
    private final ICloudService iCloudService;

    /**
     * The drive service.
     */
    private final DriveService driveService;

    /**
     * The node ID.
     */
    private final String id;

    /**
     * The node details.
     */
    private final DriveNodeDetails nodeDetails;

    /**
     * The download token.
     */
    private final String downloadUrlToken;

    /**
     * Creates a new node.
     *
     * @param iCloudService the iCloud service.
     * @param driveService the service reference.
     * @param id the ID.
     * @param nodeDetails the node details.
     */
    public DriveNode(ICloudService iCloudService, DriveService driveService, String id, DriveNodeDetails nodeDetails)
    {
        this.iCloudService = iCloudService;
        this.driveService = driveService;
        this.id = id;
        this.nodeDetails = nodeDetails;

        String rawDownloadUrlToken = iCloudService
            .getCookieStore()
            .getCookies()
            .stream()
            .filter(cookie -> "X-APPLE-WEBAUTH-VALIDATE".equals(cookie.getName()))
            .map(Cookie::getValue)
            .findFirst()
            .orElse("");

        // E.g. "v=2:t=AQAAAABXzO24CYflBW2JwysxyUEL9KxRNoEX1Qk~"
        Map<String, String> authMap = Splitter.on(":").omitEmptyStrings().trimResults().withKeyValueSeparator("=").split(rawDownloadUrlToken);
        downloadUrlToken = authMap.get("t");
    }

    /**
     * Gets the children for this node.
     *
     * @return the children.
     */
    public List<DriveNode> getChildren()
    {
        return driveService.getChildren(id);
    }

    /**
     * Downloads the file data for the item into the given output stream.
     *
     * @param outputStream the output stream to write to.
     */
    public void downloadFileData(OutputStream outputStream)
    {
        try
        {
            URIBuilder uriBuilder = new URIBuilder(String.format("%s/ws/%s/download/by_id", driveService.getDocsServiceUrl(), nodeDetails.zone));
            iCloudService.populateUriParameters(uriBuilder);
            uriBuilder.addParameter("clientMasteringNumber", "14E45");
            uriBuilder.addParameter("document_id", Iterables.getLast(Splitter.on(":").splitToList(id)));
            uriBuilder.addParameter("token", downloadUrlToken);
            URI contentUrlLookupUrl = uriBuilder.build();

            // Get the download URL for the item
            HttpGet contentUrlGetRequest = new HttpGet(contentUrlLookupUrl);
            iCloudService.populateRequestHeadersParameters(contentUrlGetRequest);

            Map<String, Object> result = iCloudService.getHttpClient().execute(contentUrlGetRequest, new JsonToMapResponseHandler());
            Map<String, Object> dataTokenMap = (Map<String, Object>) result.get("data_token");

            String contentUrl = (String) dataTokenMap.get("url");
            HttpGet contentRequest = new HttpGet(contentUrl);

            try (InputStream inputStream = iCloudService.getHttpClient().execute(contentRequest).getEntity().getContent())
            {
                IOUtils.copyLarge(inputStream, outputStream, new byte[0x10000]);
            }
        }
        catch (Exception e)
        {
            throw Throwables.propagate(e);
        }
    }

    /**
     * Gets the type.
     *
     * @return the type.
     */
    public String getType()
    {
        return nodeDetails.type;
    }

    /**
     * Gets the node details.
     *
     * @return th details.
     */
    public DriveNodeDetails getNodeDetails()
    {
        return nodeDetails;
    }

    @Override
    public String toString()
    {
        return String.format("drv-node:[%s %s '%s']", id, nodeDetails.type, nodeDetails.name);
    }
}

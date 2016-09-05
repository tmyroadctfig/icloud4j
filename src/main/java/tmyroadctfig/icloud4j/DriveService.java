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
import com.google.gson.Gson;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import tmyroadctfig.icloud4j.json.DriveNodeDetails;
import tmyroadctfig.icloud4j.util.StringResponseHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Access to the iCloud Drive service.
 *
 * @author Luke Quinanne
 */
public class DriveService
{
    /**
     * The iCloud service.
     */
    private final ICloudService iCloudService;

    /**
     * The service root URL.
     */
    private final String serviceRoot;

    /**
     * Creates a new drive service.
     *
     * @param iCloudService the iCloud service.
     */
    public DriveService(ICloudService iCloudService)
    {
        this.iCloudService = iCloudService;
        Map<String, Object> driveSettings = (Map<String, Object>) iCloudService.getWebServicesMap().get("drivews");
        serviceRoot = (String) driveSettings.get("url");
    }

    /**
     * Gets the root node.
     *
     * @return the root node.
     */
    public DriveNode getRoot()
    {
        String rootId = "FOLDER::com.apple.CloudDocs::root";
        return new DriveNode(iCloudService, this, rootId, getNodeDetails(rootId));
    }

    /**
     * Gets the node details.
     *
     * @param nodeId the node ID.
     * @return the node details.
     */
    public DriveNodeDetails getNodeDetails(String nodeId)
    {
        try
        {
            HttpPost post = new HttpPost(serviceRoot + "/retrieveItemDetailsInFolders");
            iCloudService.populateRequestHeadersParameters(post);
            post.addHeader("clientMasteringNumber", "14E45");
            post.setEntity(new StringEntity(String.format("[{\"drivewsid\":\"%s\",\"partialData\":false}]", nodeId), "UTF-8"));

            String rawResponse = iCloudService.getHttpClient().execute(post, new StringResponseHandler());
            return new Gson().fromJson(rawResponse, DriveNodeDetails[].class)[0];
        }
        catch (Exception e)
        {
            throw Throwables.propagate(e);
        }
    }

    /**
     * Gets the list of children for a given parent ID.
     *
     * @param parentId the ID to look up the children for.
     * @return the list of children.
     */
    public List<DriveNode> getChildren(String parentId)
    {
        DriveNodeDetails nodeDetails = getNodeDetails(parentId);
        if (nodeDetails.items == null)
        {
            return Collections.emptyList();
        }

        return Stream
            .of(nodeDetails.items)
            .map(childDetails -> new DriveNode(iCloudService, this, childDetails.drivewsid, childDetails))
            .collect(Collectors.toList());
    }

    /**
     * Gets the service URL.
     *
     * @return the service URL.
     */
    public String getServiceUrl()
    {
        return serviceRoot;
    }
}

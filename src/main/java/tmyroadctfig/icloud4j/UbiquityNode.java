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
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.HttpGet;
import tmyroadctfig.icloud4j.json.UbiquityGetChildrenResponse;
import tmyroadctfig.icloud4j.json.UbiquityNodeDetails;
import tmyroadctfig.icloud4j.util.StringResponseHandler;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A node in the ubiquity service.
 *
 * @author Luke Quinane
 */
public class UbiquityNode
{
    /**
     * The iCloud service.
     */
    private final ICloudService iCloudService;

    /**
     * The ubiquity service.
     */
    private final UbiquityService ubiquityService;

    /**
     * The node ID.
     */
    private final String id;

    /**
     * The node details.
     */
    private final UbiquityNodeDetails nodeDetails;

    /**
     * Creates a new node.
     *
     * @param iCloudService the iCloud service.
     * @param ubiquityService the service reference.
     * @param id the ID.
     */
    public UbiquityNode(ICloudService iCloudService, UbiquityService ubiquityService, String id, UbiquityNodeDetails nodeDetails)
    {
        this.iCloudService = iCloudService;
        this.ubiquityService = ubiquityService;
        this.id = id;
        this.nodeDetails = nodeDetails;
    }

    /**
     * Gets the children for this node.
     *
     * @return the children.
     */
    public List<UbiquityNode> getChildren()
    {
        try
        {
            String url = String.format("%s/ws/%s/%s/%s", ubiquityService.getServiceUrl(), iCloudService.getSessionId(), "parent", id);
            HttpGet httpGet = new HttpGet(url);
            iCloudService.populateRequestHeadersParameters(httpGet);

            String rawResponse = iCloudService.getHttpClient().execute(httpGet, new StringResponseHandler());
            UbiquityGetChildrenResponse getChildrenResponse = new Gson().fromJson(rawResponse, UbiquityGetChildrenResponse.class);

            return Stream.of(getChildrenResponse.item_list)
                .map(item -> new UbiquityNode(iCloudService, ubiquityService, item.item_id, item))
                .collect(Collectors.toList());
        }
        catch (Exception e)
        {
            throw Throwables.propagate(e);
        }
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
            String url = String.format("%s/ws/%s/%s/%s", ubiquityService.getServiceUrl(), iCloudService.getSessionId(), "file", id);
            HttpGet httpGet = new HttpGet(url);
            iCloudService.populateRequestHeadersParameters(httpGet);

            try (InputStream inputStream = iCloudService.getHttpClient().execute(httpGet).getEntity().getContent())
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
     * @return th type.
     */
    public String getType()
    {
        return nodeDetails.type;
    }

    @Override
    public String toString()
    {
        return String.format("node:[%s %s '%s']", id, nodeDetails.type, nodeDetails.name);
    }
}

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

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.HttpGet;

import com.github.tmyroadctfig.icloud4j.models.ubiquityService.UbiquityGetChildrenResponse;
import com.github.tmyroadctfig.icloud4j.models.ubiquityService.UbiquityNodeDetails;
import com.github.tmyroadctfig.icloud4j.util.ICloudUtils;
import com.google.common.base.Throwables;

/**
 * A node in the ubiquity service.
 *
 * @author Luke Quinane
 */
public class UbiquityNode {
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
     * @param nodeDetails the details for the node.
     */
    public UbiquityNode(ICloudService iCloudService, UbiquityService ubiquityService, String id,
            UbiquityNodeDetails nodeDetails) {
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
    public List<UbiquityNode> getChildren() {
        try {
            String url = String.format("%s/ws/%s/%s/%s", ubiquityService.getServiceUrl(), iCloudService.getSessionId(),
                    "parent", id);
            HttpGet httpGet = new HttpGet(url);
            iCloudService.populateRequestHeadersParameters(httpGet);

            UbiquityGetChildrenResponse getChildrenResponse = ICloudUtils
                    .parseJsonResponse(iCloudService.getHttpClient(), httpGet, UbiquityGetChildrenResponse.class);

            return getChildrenResponse.getItemList().stream()
                    .map(item -> new UbiquityNode(iCloudService, ubiquityService, item.getItemId(), item))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    /**
     * Downloads the file data for the item into the given output stream.
     *
     * @param outputStream the output stream to write to.
     */
    public void downloadFileData(OutputStream outputStream) {
        try {
            String url = String.format("%s/ws/%s/%s/%s", ubiquityService.getServiceUrl(), iCloudService.getSessionId(),
                    "file", id);
            HttpGet httpGet = new HttpGet(url);
            iCloudService.populateRequestHeadersParameters(httpGet);

            try (InputStream inputStream = iCloudService.getHttpClient().execute(httpGet).getEntity().getContent()) {
                IOUtils.copyLarge(inputStream, outputStream, new byte[0x10000]);
            }
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    /**
     * Gets the type.
     *
     * @return the type.
     */
    public String getType() {
        return nodeDetails.getType();
    }

    /**
     * Gets the node details.
     *
     * @return th details.
     */
    public UbiquityNodeDetails getNodeDetails() {
        return nodeDetails;
    }

    @Override
    public String toString() {
        return String.format("u-node:[%s %s '%s']", id, nodeDetails.getType(), nodeDetails.getName());
    }
}

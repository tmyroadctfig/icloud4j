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

import com.github.tmyroadctfig.icloud4j.json.UbiquityNodeDetails;
import com.github.tmyroadctfig.icloud4j.util.ICloudUtils;
import com.google.common.base.Throwables;
import org.apache.http.client.methods.HttpGet;

import java.util.Map;

/**
 * Access to the 'ubiquity' service.
 *
 * @author Luke Quinane
 */
public class UbiquityService
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
     * Creates a new 'ubiquity' service.
     *
     * @param iCloudService the iCloud service.
     */
    public UbiquityService(ICloudService iCloudService)
    {
        this.iCloudService = iCloudService;
        Map<String, Object> ubiquitySettings = (Map<String, Object>) iCloudService.getWebServicesMap().get("ubiquity");
        serviceRoot = (String) ubiquitySettings.get("url");
    }

    /**
     * Gets the root node.
     *
     * @return the root node.
     */
    public UbiquityNode getRoot()
    {
        String rootId = "0";

        try
        {
            String url = String.format("%s/ws/%s/%s/%s", serviceRoot, iCloudService.getSessionId(), "item", rootId);
            HttpGet httpGet = new HttpGet(url);
            iCloudService.populateRequestHeadersParameters(httpGet);

            UbiquityNodeDetails nodeDetails =
                ICloudUtils.parseJsonResponse(iCloudService.getHttpClient(), httpGet, UbiquityNodeDetails.class);

            return new UbiquityNode(iCloudService, this, rootId, nodeDetails);
        }
        catch (Exception e)
        {
            throw Throwables.propagate(e);
        }
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
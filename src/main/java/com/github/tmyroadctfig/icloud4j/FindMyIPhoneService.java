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

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;

import com.github.tmyroadctfig.icloud4j.models.findMyIPhoneService.AppleDevice;
import com.github.tmyroadctfig.icloud4j.models.findMyIPhoneService.Content;
import com.github.tmyroadctfig.icloud4j.util.ICloudUtils;
import com.google.common.base.Throwables;

/**
 * Access to the 'find my iPhone' service (although it returns details for Mac computers too).
 *
 * @author Luke Quinane
 */
public class FindMyIPhoneService {
    /**
     * The iCloud service.
     */
    private final ICloudService iCloudService;

    /**
     * The service root URL.
     */
    private final String serviceRoot;

    /**
     * The service end point.
     */
    private final String endPoint;

    /**
     * The refresh URL.
     */
    private final String refreshUrl;

    /**
     * Creates a new 'find my iPhone' service.
     *
     * @param iCloudService the iCloud service.
     */
    public FindMyIPhoneService(ICloudService iCloudService) {
        this.iCloudService = iCloudService;
        Map<String, Object> findMeSettings = (Map<String, Object>) iCloudService.getWebServicesMap().get("findme");
        serviceRoot = (String) findMeSettings.get("url");

        endPoint = serviceRoot + "/fmipservice/client/web";
        refreshUrl = endPoint + "/refreshClient";
    }

    /**
     * Gets a list of devices.
     *
     * @return the list of devices.
     */
    public List<Content> getDevices() {
        try {
            URIBuilder uriBuilder = new URIBuilder(refreshUrl);
            iCloudService.populateUriParameters(uriBuilder);
            URI uri = uriBuilder.build();

            String requestJson = "{\"clientContext\": {\"fmly\": true, \"shouldLocate\": true, \"selectedDevice\": \"all\"}}";

            HttpPost post = new HttpPost(uri);
            post.setEntity(new StringEntity(requestJson, null, "UTF-8"));
            iCloudService.populateRequestHeadersParameters(post);

            AppleDevice findMyIPhoneResponse = ICloudUtils.parseJsonResponse(iCloudService.getHttpClient(), post,
                    AppleDevice.class);

            return findMyIPhoneResponse.getContent();
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }
}

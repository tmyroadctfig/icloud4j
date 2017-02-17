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

package com.github.tmyroadctfig.icloud4j.models.findMyIPhoneService;

import java.util.List;

/**
 * A response from the refresh call to the 'find my iPhone' service.
 *
 * @author Luke Quinane
 */
public class FindMyIPhoneResponse {
    /**
     * The list of Apple devices returned in the response.
     */
    private List<AppleDevice> content;

    public List<AppleDevice> getContent() {
        return content;
    }

    public void setContent(List<AppleDevice> content) {
        this.content = content;
    }
}

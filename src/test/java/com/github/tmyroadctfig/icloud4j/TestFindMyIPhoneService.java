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

import static com.github.tmyroadctfig.icloud4j.ICloudTestUtils.getServiceFromSystemProperties;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.github.tmyroadctfig.icloud4j.models.findMyIPhoneService.Content;

/**
 * Tests for {@link FindMyIPhoneService}.
 */
public class TestFindMyIPhoneService {
	
    @Test
    public void testDevices() {
        // Arrange
        ICloudService iCloudService = getServiceFromSystemProperties();
        FindMyIPhoneService findMyIPhoneService = new FindMyIPhoneService(iCloudService);

        // Act
        List<Content> devices = findMyIPhoneService.getDevices();

        // Assert
        assertThat(devices.isEmpty(), is(false));

        for (Content device : devices) 
        {
            assertNotNull(device);
        }
    }
    
}
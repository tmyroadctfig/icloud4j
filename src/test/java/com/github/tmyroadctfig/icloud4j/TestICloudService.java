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

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.github.tmyroadctfig.icloud4j.ICloudTestUtils.getServiceFromSystemProperties;

/**
 * Tests for {@link ICloudService}.
 */
public class TestICloudService
{
    @Test
    public void testLogin()
    {
        // Arrange / Act
        ICloudService iCloudService = getServiceFromSystemProperties();

        // Assert
        assertThat(iCloudService.getLoginInfo().get("dsInfo"), is(not(nullValue())));
    }

    @Test
    public void testStorageUsageInfo()
    {
        // Arrange
        ICloudService iCloudService = getServiceFromSystemProperties();

        // Act
        Map<String, Object> storageUsage = iCloudService.getStorageUsage();

        // Assert
        assertThat(storageUsage.get("quotaStatus"), is(not(nullValue())));
        assertThat(storageUsage.get("storageUsageInfo"), is(not(nullValue())));
        assertThat(storageUsage.get("storageUsageByMedia"), is(not(nullValue())));
    }
}
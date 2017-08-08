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

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@link DriveService}.
 */
public class TestDriveService
{
	
    @Test
    public void testListItems()
    {
        // Arrange
        ICloudService iCloudService = ICloudTestUtils.getServiceFromSystemProperties();
        DriveService driveService = new DriveService(iCloudService);

        // Act
        DriveNode root = driveService.getRoot();
        List<DriveNode> children = root.getChildren();

        // Assert
        assertThat(children.isEmpty(), is(false));
    }
    
}
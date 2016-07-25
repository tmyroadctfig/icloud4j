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

import org.apache.log4j.BasicConfigurator;

/**
 * Testing utilities
 */
public class ICloudTestUtils
{
    static
    {
        BasicConfigurator.configure();
    }

    /**
     * Gets a new iCloud4j service instance from system properties.
     *
     * @return the service instance.
     */
    public static ICloudService getServiceFromSystemProperties()
    {
        ICloudService iCloudService = new ICloudService(System.getProperty("icloud4j.test.clientId"));

        iCloudService.authenticate(
            System.getProperty("icloud4j.test.username"),
            System.getProperty("icloud4j.test.password").toCharArray());

        return iCloudService;
    }
}

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

package tmyroadctfig.icloud4j.json;

/**
 * The list of trusted two-factor authentication devices.
 *
 * @author Luke Quinane
 */
public class TrustedDevice
{
    /**
     * The device type, e.g. "SMS".
     */
    public String deviceType;

    /**
     * The area code.
     */
    public String areaCode;

    /**
     * The obfuscated phone number. E.g. "*******00".
     */
    public String phoneNumber;

    /**
     * The device ID, e.g. "1".
     */
    public String deviceId;

    @Override
    public String toString()
    {
        return String.format("[%s] %s: (%s) %s", deviceId, deviceType, areaCode, phoneNumber);
    }
}

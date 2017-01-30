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

package com.github.tmyroadctfig.icloud4j.json;

/**
 * Details for a drive node.
 *
 * @author Luke Quinane
 */
public class DriveNodeDetails
{
    /**
     * The drive webservice ID. E.g. "FOLDER::com.apple.CloudDocs::8DA00FC2-2FA3-4CC4-8039-12C6D2E6ACDC"
     */
    public String drivewsid;

    /**
     * The docs webservice ID.
     */
    public String docwsid;

    /**
     * The drive webservice parent ID.
     */
    public String parentId;

    /**
     * The zone, e.g "com.apple.CloudDocs"
     */
    public String zone;

    /**
     * The item name.
     */
    public String name;

    public String etag;

    /**
     * The item type, e.g. "FOLDER".
     */
    public String type;

    /**
     * The child items.
     */
    public DriveNodeDetails[] items;

    /**
     * The number of child items.
     */
    public int numberOfItems;

    public String dateModified;
    public String dateChanged;
    public long size;
    public String extension;
}

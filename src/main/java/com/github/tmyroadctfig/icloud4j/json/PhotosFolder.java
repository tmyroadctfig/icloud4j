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
 * A folder in the photos service.
 */
public class PhotosFolder
{
    public String keyAssetClientId;

    /**
     * The contents type, e.g. "folder", "asset".
     */
    public String contentsType;

    public String dateRange;

    public String childAssetsBinaryFeed;

    /**
     * The child folder IDs.
     */
    public String[] childFolderIds;

    /**
     * The type, e.g. "folder", "album".
     */
    public String type;

    /**
     * The server ID, e.g. "all-photos", "deleted-photos".
     */
    public String serverId;

    public boolean isServerGenerated;
}

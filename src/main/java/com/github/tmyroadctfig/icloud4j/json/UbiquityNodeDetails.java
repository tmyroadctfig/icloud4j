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
 * Details for a ubiquity node.
 *
 * @author Luke Quinane
 */
public class UbiquityNodeDetails
{
    public long peer_id;
    public boolean in_cloud;
    public String item_id;
    public String name;
    public String parent_item_id;
    public String type;
    public String modified;
    public long size;
    public String change_id;
}
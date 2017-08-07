/*
 *    Copyright 2017 Jan Bastgen
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
package com.github.tmyroadctfig.icloud4j.models.photosService;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotosFolder {

    @SerializedName("contentsType")
    @Expose
    private String contentsType;
    @SerializedName("childFolderIds")
    @Expose
    private List<String> childFolderIds = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("serverId")
    @Expose
    private String serverId;
    @SerializedName("isServerGenerated")
    @Expose
    private Boolean isServerGenerated;
    @SerializedName("keyAssetClientId")
    @Expose
    private Object keyAssetClientId;
    @SerializedName("dateRange")
    @Expose
    private Object dateRange;
    @SerializedName("childAssetsBinaryFeed")
    @Expose
    private String childAssetsBinaryFeed;
    @SerializedName("parentServerId")
    @Expose
    private String parentServerId;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("title")
    @Expose
    private String title;

    public String getContentsType() {
        return contentsType;
    }

    public void setContentsType(String contentsType) {
        this.contentsType = contentsType;
    }

    public List<String> getChildFolderIds() {
        return childFolderIds;
    }

    public void setChildFolderIds(List<String> childFolderIds) {
        this.childFolderIds = childFolderIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public Boolean getIsServerGenerated() {
        return isServerGenerated;
    }

    public void setIsServerGenerated(Boolean isServerGenerated) {
        this.isServerGenerated = isServerGenerated;
    }

    public Object getKeyAssetClientId() {
        return keyAssetClientId;
    }

    public void setKeyAssetClientId(Object keyAssetClientId) {
        this.keyAssetClientId = keyAssetClientId;
    }

    public Object getDateRange() {
        return dateRange;
    }

    public void setDateRange(Object dateRange) {
        this.dateRange = dateRange;
    }

    public String getChildAssetsBinaryFeed() {
        return childAssetsBinaryFeed;
    }

    public void setChildAssetsBinaryFeed(String childAssetsBinaryFeed) {
        this.childAssetsBinaryFeed = childAssetsBinaryFeed;
    }

    public String getParentServerId() {
        return parentServerId;
    }

    public void setParentServerId(String parentServerId) {
        this.parentServerId = parentServerId;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contentsType).append(childFolderIds).append(type).append(serverId)
                .append(isServerGenerated).append(keyAssetClientId).append(dateRange).append(childAssetsBinaryFeed)
                .append(parentServerId).append(etag).append(title).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PhotosFolder) == false) {
            return false;
        }
        PhotosFolder rhs = ((PhotosFolder) other);
        return new EqualsBuilder().append(contentsType, rhs.contentsType).append(childFolderIds, rhs.childFolderIds)
                .append(type, rhs.type).append(serverId, rhs.serverId).append(isServerGenerated, rhs.isServerGenerated)
                .append(keyAssetClientId, rhs.keyAssetClientId).append(dateRange, rhs.dateRange)
                .append(childAssetsBinaryFeed, rhs.childAssetsBinaryFeed).append(parentServerId, rhs.parentServerId)
                .append(etag, rhs.etag).append(title, rhs.title).isEquals();
    }

}

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
package com.github.tmyroadctfig.icloud4j.models.ubiquityService;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model for {@link UbiquityNodeDetails} used for JSON parsing.
 *
 * @author Jan Bastgen
 *
 */
public class UbiquityNodeDetails {

    @SerializedName("in_cloud")
    @Expose
    private Boolean inCloud;
    
    @SerializedName("size")
    @Expose
    private Integer size;
    
    @SerializedName("item_id")
    @Expose
    private String itemId;
    
    @SerializedName("parent_item_id")
    @Expose
    private String parentItemId;
    
    @SerializedName("change_id")
    @Expose
    private String changeId;
    
    @SerializedName("name")
    @Expose
    private String name;
    
    @SerializedName("modified")
    @Expose
    private String modified;
    
    @SerializedName("peer_name")
    @Expose
    private String peerName;
    
    @SerializedName("type")
    @Expose
    private String type;
    
    @SerializedName("peer_id")
    @Expose
    private Integer peerId;
    
    @SerializedName("signature")
    @Expose
    private String signature;
    
    @SerializedName("conflicted")
    @Expose
    private Boolean conflicted;

    public Boolean getConflicted() {
        return conflicted;
    }

    public void setConflicted(Boolean conflicted) {
        this.conflicted = conflicted;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Boolean getInCloud() {
        return inCloud;
    }

    public void setInCloud(Boolean inCloud) {
        this.inCloud = inCloud;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getPeerName() {
        return peerName;
    }

    public void setPeerName(String peerName) {
        this.peerName = peerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public void setPeerId(Integer peerId) {
        this.peerId = peerId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(inCloud).append(size).append(itemId).append(parentItemId).append(changeId)
                .append(name).append(modified).append(peerName).append(type).append(peerId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UbiquityNodeDetails) == false) {
            return false;
        }
        UbiquityNodeDetails rhs = ((UbiquityNodeDetails) other);
        return new EqualsBuilder().append(inCloud, rhs.inCloud).append(size, rhs.size).append(itemId, rhs.itemId)
                .append(parentItemId, rhs.parentItemId).append(changeId, rhs.changeId).append(name, rhs.name)
                .append(modified, rhs.modified).append(peerName, rhs.peerName).append(type, rhs.type)
                .append(peerId, rhs.peerId).isEquals();
    }

}

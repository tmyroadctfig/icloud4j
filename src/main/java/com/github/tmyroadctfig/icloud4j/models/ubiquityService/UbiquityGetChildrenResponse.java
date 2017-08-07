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

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model for {@link UbiquityGetChildrenResponse} used for JSON parsing.
 *
 * @author Jan Bastgen
 *
 */
public class UbiquityGetChildrenResponse {

    @SerializedName("item_list")
    @Expose
    private List<UbiquityNodeDetails> itemList = null;

    public List<UbiquityNodeDetails> getItemList() {
        return itemList;
    }

    public void setItemList(List<UbiquityNodeDetails> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(itemList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UbiquityGetChildrenResponse) == false) {
            return false;
        }
        UbiquityGetChildrenResponse rhs = ((UbiquityGetChildrenResponse) other);
        return new EqualsBuilder().append(itemList, rhs.itemList).isEquals();
    }

}

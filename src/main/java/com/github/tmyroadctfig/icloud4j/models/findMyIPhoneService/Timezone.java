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
package com.github.tmyroadctfig.icloud4j.models.findMyIPhoneService;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timezone {

    @SerializedName("currentOffset")
    @Expose
    private Integer currentOffset;
    @SerializedName("previousTransition")
    @Expose
    private Integer previousTransition;
    @SerializedName("previousOffset")
    @Expose
    private Integer previousOffset;
    @SerializedName("tzCurrentName")
    @Expose
    private String tzCurrentName;
    @SerializedName("tzName")
    @Expose
    private String tzName;

    public Integer getCurrentOffset() {
        return currentOffset;
    }

    public void setCurrentOffset(Integer currentOffset) {
        this.currentOffset = currentOffset;
    }

    public Integer getPreviousTransition() {
        return previousTransition;
    }

    public void setPreviousTransition(Integer previousTransition) {
        this.previousTransition = previousTransition;
    }

    public Integer getPreviousOffset() {
        return previousOffset;
    }

    public void setPreviousOffset(Integer previousOffset) {
        this.previousOffset = previousOffset;
    }

    public String getTzCurrentName() {
        return tzCurrentName;
    }

    public void setTzCurrentName(String tzCurrentName) {
        this.tzCurrentName = tzCurrentName;
    }

    public String getTzName() {
        return tzName;
    }

    public void setTzName(String tzName) {
        this.tzName = tzName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(currentOffset).append(previousTransition).append(previousOffset)
                .append(tzCurrentName).append(tzName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Timezone) == false) {
            return false;
        }
        Timezone rhs = ((Timezone) other);
        return new EqualsBuilder().append(currentOffset, rhs.currentOffset)
                .append(previousTransition, rhs.previousTransition).append(previousOffset, rhs.previousOffset)
                .append(tzCurrentName, rhs.tzCurrentName).append(tzName, rhs.tzName).isEquals();
    }

}

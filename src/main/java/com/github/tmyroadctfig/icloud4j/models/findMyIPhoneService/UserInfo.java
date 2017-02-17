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

public class UserInfo {

    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("membersInfo")
    @Expose
    private Object membersInfo;
    @SerializedName("hasMembers")
    @Expose
    private Boolean hasMembers;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getMembersInfo() {
        return membersInfo;
    }

    public void setMembersInfo(Object membersInfo) {
        this.membersInfo = membersInfo;
    }

    public Boolean getHasMembers() {
        return hasMembers;
    }

    public void setHasMembers(Boolean hasMembers) {
        this.hasMembers = hasMembers;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(lastName).append(membersInfo).append(hasMembers)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserInfo) == false) {
            return false;
        }
        UserInfo rhs = ((UserInfo) other);
        return new EqualsBuilder().append(firstName, rhs.firstName).append(lastName, rhs.lastName)
                .append(membersInfo, rhs.membersInfo).append(hasMembers, rhs.hasMembers).isEquals();
    }

}

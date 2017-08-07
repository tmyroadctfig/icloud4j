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

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppleDevice {

    @SerializedName("userInfo")
    @Expose
    private UserInfo userInfo;
    @SerializedName("serverContext")
    @Expose
    private ServerContext serverContext;
    @SerializedName("alert")
    @Expose
    private Object alert;
    @SerializedName("userPreferences")
    @Expose
    private UserPreferences userPreferences;
    @SerializedName("content")
    @Expose
    private List<Content> content = null;
    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public ServerContext getServerContext() {
        return serverContext;
    }

    public void setServerContext(ServerContext serverContext) {
        this.serverContext = serverContext;
    }

    public Object getAlert() {
        return alert;
    }

    public void setAlert(Object alert) {
        this.alert = alert;
    }

    public UserPreferences getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(UserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(userInfo).append(serverContext).append(alert).append(userPreferences)
                .append(content).append(statusCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AppleDevice) == false) {
            return false;
        }
        AppleDevice rhs = ((AppleDevice) other);
        return new EqualsBuilder().append(userInfo, rhs.userInfo).append(serverContext, rhs.serverContext)
                .append(alert, rhs.alert).append(userPreferences, rhs.userPreferences).append(content, rhs.content)
                .append(statusCode, rhs.statusCode).isEquals();
    }

}

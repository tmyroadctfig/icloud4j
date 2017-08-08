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

/**
 * Model for {@link ServerContext} used for JSON parsing.
 *
 * @author Jan Bastgen
 *
 */
public class ServerContext {

    @SerializedName("minCallbackIntervalInMS")
    @Expose
    private Integer minCallbackIntervalInMS;
    
    @SerializedName("enable2FAFamilyActions")
    @Expose
    private Boolean enable2FAFamilyActions;
    
    @SerializedName("preferredLanguage")
    @Expose
    private String preferredLanguage;
    
    @SerializedName("lastSessionExtensionTime")
    @Expose
    private Object lastSessionExtensionTime;
    
    @SerializedName("validRegion")
    @Expose
    private Boolean validRegion;
    
    @SerializedName("enableMapStats")
    @Expose
    private Boolean enableMapStats;
    
    @SerializedName("callbackIntervalInMS")
    @Expose
    private Integer callbackIntervalInMS;
    
    @SerializedName("timezone")
    @Expose
    private Timezone timezone;
    
    @SerializedName("authToken")
    @Expose
    private Object authToken;
    
    @SerializedName("maxCallbackIntervalInMS")
    @Expose
    private Integer maxCallbackIntervalInMS;
    
    @SerializedName("classicUser")
    @Expose
    private Boolean classicUser;
    
    @SerializedName("isHSA")
    @Expose
    private Boolean isHSA;
    
    @SerializedName("trackInfoCacheDurationInSecs")
    @Expose
    private Integer trackInfoCacheDurationInSecs;
    
    @SerializedName("imageBaseUrl")
    @Expose
    private String imageBaseUrl;
    
    @SerializedName("minTrackLocThresholdInMts")
    @Expose
    private Integer minTrackLocThresholdInMts;
    
    @SerializedName("maxLocatingTime")
    @Expose
    private Integer maxLocatingTime;
    
    @SerializedName("sessionLifespan")
    @Expose
    private Integer sessionLifespan;
    
    @SerializedName("info")
    @Expose
    private String info;
    
    @SerializedName("prefsUpdateTime")
    @Expose
    private Long prefsUpdateTime;
    
    @SerializedName("useAuthWidget")
    @Expose
    private Boolean useAuthWidget;
    
    @SerializedName("clientId")
    @Expose
    private String clientId;
    
    @SerializedName("enable2FAFamilyRemove")
    @Expose
    private Boolean enable2FAFamilyRemove;
    
    @SerializedName("serverTimestamp")
    @Expose
    private Long serverTimestamp;
    
    @SerializedName("macCount")
    @Expose
    private Integer macCount;
    
    @SerializedName("deviceLoadStatus")
    @Expose
    private String deviceLoadStatus;
    
    @SerializedName("maxDeviceLoadTime")
    @Expose
    private Integer maxDeviceLoadTime;
    
    @SerializedName("prsId")
    @Expose
    private Integer prsId;
    
    @SerializedName("showSllNow")
    @Expose
    private Boolean showSllNow;
    
    @SerializedName("cloudUser")
    @Expose
    private Boolean cloudUser;
    
    @SerializedName("enable2FAErase")
    @Expose
    private Boolean enable2FAErase;

    public Integer getMinCallbackIntervalInMS() 
    {
        return minCallbackIntervalInMS;
    }

    public void setMinCallbackIntervalInMS(Integer minCallbackIntervalInMS) 
    {
        this.minCallbackIntervalInMS = minCallbackIntervalInMS;
    }

    public Boolean getEnable2FAFamilyActions() 
    {
        return enable2FAFamilyActions;
    }

    public void setEnable2FAFamilyActions(Boolean enable2FAFamilyActions) 
    {
        this.enable2FAFamilyActions = enable2FAFamilyActions;
    }

    public String getPreferredLanguage() 
    {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) 
    {
        this.preferredLanguage = preferredLanguage;
    }

    public Object getLastSessionExtensionTime() 
    {
        return lastSessionExtensionTime;
    }

    public void setLastSessionExtensionTime(Object lastSessionExtensionTime) 
    {
        this.lastSessionExtensionTime = lastSessionExtensionTime;
    }

    public Boolean getValidRegion() 
    {
        return validRegion;
    }

    public void setValidRegion(Boolean validRegion) 
    {
        this.validRegion = validRegion;
    }

    public Boolean getEnableMapStats() 
    {
        return enableMapStats;
    }

    public void setEnableMapStats(Boolean enableMapStats) 
    {
        this.enableMapStats = enableMapStats;
    }

    public Integer getCallbackIntervalInMS() 
    {
        return callbackIntervalInMS;
    }

    public void setCallbackIntervalInMS(Integer callbackIntervalInMS) 
    {
        this.callbackIntervalInMS = callbackIntervalInMS;
    }

    public Timezone getTimezone() 
    {
        return timezone;
    }

    public void setTimezone(Timezone timezone) 
    {
        this.timezone = timezone;
    }

    public Object getAuthToken() 
    {
        return authToken;
    }

    public void setAuthToken(Object authToken) 
    {
        this.authToken = authToken;
    }

    public Integer getMaxCallbackIntervalInMS() 
    {
        return maxCallbackIntervalInMS;
    }

    public void setMaxCallbackIntervalInMS(Integer maxCallbackIntervalInMS) 
    {
        this.maxCallbackIntervalInMS = maxCallbackIntervalInMS;
    }

    public Boolean getClassicUser() 
    {
        return classicUser;
    }

    public void setClassicUser(Boolean classicUser) 
    {
        this.classicUser = classicUser;
    }

    public Boolean getIsHSA() 
    {
        return isHSA;
    }

    public void setIsHSA(Boolean isHSA) 
    {
        this.isHSA = isHSA;
    }

    public Integer getTrackInfoCacheDurationInSecs() 
    {
        return trackInfoCacheDurationInSecs;
    }

    public void setTrackInfoCacheDurationInSecs(Integer trackInfoCacheDurationInSecs) 
    {
        this.trackInfoCacheDurationInSecs = trackInfoCacheDurationInSecs;
    }

    public String getImageBaseUrl() 
    {
        return imageBaseUrl;
    }

    public void setImageBaseUrl(String imageBaseUrl) 
    {
        this.imageBaseUrl = imageBaseUrl;
    }

    public Integer getMinTrackLocThresholdInMts() 
    {
        return minTrackLocThresholdInMts;
    }

    public void setMinTrackLocThresholdInMts(Integer minTrackLocThresholdInMts) 
    {
        this.minTrackLocThresholdInMts = minTrackLocThresholdInMts;
    }

    public Integer getMaxLocatingTime() 
    {
        return maxLocatingTime;
    }

    public void setMaxLocatingTime(Integer maxLocatingTime) 
    {
        this.maxLocatingTime = maxLocatingTime;
    }

    public Integer getSessionLifespan() 
    {
        return sessionLifespan;
    }

    public void setSessionLifespan(Integer sessionLifespan) 
    {
        this.sessionLifespan = sessionLifespan;
    }

    public String getInfo() 
    {
        return info;
    }

    public void setInfo(String info) 
    {
        this.info = info;
    }

    public Long getPrefsUpdateTime() 
    {
        return prefsUpdateTime;
    }

    public void setPrefsUpdateTime(Long prefsUpdateTime) 
    {
        this.prefsUpdateTime = prefsUpdateTime;
    }

    public Boolean getUseAuthWidget() 
    {
        return useAuthWidget;
    }

    public void setUseAuthWidget(Boolean useAuthWidget) 
    {
        this.useAuthWidget = useAuthWidget;
    }

    public String getClientId() 
    {
        return clientId;
    }

    public void setClientId(String clientId) 
    {
        this.clientId = clientId;
    }

    public Boolean getEnable2FAFamilyRemove() 
    {
        return enable2FAFamilyRemove;
    }

    public void setEnable2FAFamilyRemove(Boolean enable2FAFamilyRemove) 
    {
        this.enable2FAFamilyRemove = enable2FAFamilyRemove;
    }

    public Long getServerTimestamp() 
    {
        return serverTimestamp;
    }

    public void setServerTimestamp(Long serverTimestamp) 
    {
        this.serverTimestamp = serverTimestamp;
    }

    public Integer getMacCount() 
    {
        return macCount;
    }

    public void setMacCount(Integer macCount) 
    {
        this.macCount = macCount;
    }

    public String getDeviceLoadStatus() 
    {
        return deviceLoadStatus;
    }

    public void setDeviceLoadStatus(String deviceLoadStatus) 
    {
        this.deviceLoadStatus = deviceLoadStatus;
    }

    public Integer getMaxDeviceLoadTime() 
    {
        return maxDeviceLoadTime;
    }

    public void setMaxDeviceLoadTime(Integer maxDeviceLoadTime) 
    {
        this.maxDeviceLoadTime = maxDeviceLoadTime;
    }

    public Integer getPrsId() 
    {
        return prsId;
    }

    public void setPrsId(Integer prsId) 
    {
        this.prsId = prsId;
    }

    public Boolean getShowSllNow() 
    {
        return showSllNow;
    }

    public void setShowSllNow(Boolean showSllNow) 
    {
        this.showSllNow = showSllNow;
    }

    public Boolean getCloudUser() 
    {
        return cloudUser;
    }

    public void setCloudUser(Boolean cloudUser) 
    {
        this.cloudUser = cloudUser;
    }

    public Boolean getEnable2FAErase() 
    {
        return enable2FAErase;
    }

    public void setEnable2FAErase(Boolean enable2FAErase) 
    {
        this.enable2FAErase = enable2FAErase;
    }

    @Override
    public String toString() 
    {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() 
    {
        return new HashCodeBuilder().append(minCallbackIntervalInMS).append(enable2FAFamilyActions)
                .append(preferredLanguage).append(lastSessionExtensionTime).append(validRegion).append(enableMapStats)
                .append(callbackIntervalInMS).append(timezone).append(authToken).append(maxCallbackIntervalInMS)
                .append(classicUser).append(isHSA).append(trackInfoCacheDurationInSecs).append(imageBaseUrl)
                .append(minTrackLocThresholdInMts).append(maxLocatingTime).append(sessionLifespan).append(info)
                .append(prefsUpdateTime).append(useAuthWidget).append(clientId).append(enable2FAFamilyRemove)
                .append(serverTimestamp).append(macCount).append(deviceLoadStatus).append(maxDeviceLoadTime)
                .append(prsId).append(showSllNow).append(cloudUser).append(enable2FAErase).toHashCode();
    }

    @Override
    public boolean equals(Object other) 
    {
        if (other == this) 
        {
            return true;
        }
        if ((other instanceof ServerContext) == false) 
        {
            return false;
        }
        ServerContext rhs = ((ServerContext) other);
        return new EqualsBuilder().append(minCallbackIntervalInMS, rhs.minCallbackIntervalInMS)
                .append(enable2FAFamilyActions, rhs.enable2FAFamilyActions)
                .append(preferredLanguage, rhs.preferredLanguage)
                .append(lastSessionExtensionTime, rhs.lastSessionExtensionTime).append(validRegion, rhs.validRegion)
                .append(enableMapStats, rhs.enableMapStats).append(callbackIntervalInMS, rhs.callbackIntervalInMS)
                .append(timezone, rhs.timezone).append(authToken, rhs.authToken)
                .append(maxCallbackIntervalInMS, rhs.maxCallbackIntervalInMS).append(classicUser, rhs.classicUser)
                .append(isHSA, rhs.isHSA).append(trackInfoCacheDurationInSecs, rhs.trackInfoCacheDurationInSecs)
                .append(imageBaseUrl, rhs.imageBaseUrl).append(minTrackLocThresholdInMts, rhs.minTrackLocThresholdInMts)
                .append(maxLocatingTime, rhs.maxLocatingTime).append(sessionLifespan, rhs.sessionLifespan)
                .append(info, rhs.info).append(prefsUpdateTime, rhs.prefsUpdateTime)
                .append(useAuthWidget, rhs.useAuthWidget).append(clientId, rhs.clientId)
                .append(enable2FAFamilyRemove, rhs.enable2FAFamilyRemove).append(serverTimestamp, rhs.serverTimestamp)
                .append(macCount, rhs.macCount).append(deviceLoadStatus, rhs.deviceLoadStatus)
                .append(maxDeviceLoadTime, rhs.maxDeviceLoadTime).append(prsId, rhs.prsId)
                .append(showSllNow, rhs.showSllNow).append(cloudUser, rhs.cloudUser)
                .append(enable2FAErase, rhs.enable2FAErase).isEquals();
    }

}

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
/**
 * Model for {@link Content} used for JSON parsing.
 *
 * @author Jan Bastgen
 *
 */
public class Content 
{

    @SerializedName("msg")
    @Expose
    private Object msg;
    
    @SerializedName("canWipeAfterLock")
    @Expose
    private Boolean canWipeAfterLock;
    
    @SerializedName("wipeInProgress")
    @Expose
    private Boolean wipeInProgress;
    
    @SerializedName("lostModeEnabled")
    @Expose
    private Boolean lostModeEnabled;
    
    @SerializedName("activationLocked")
    @Expose
    private Boolean activationLocked;
    
    @SerializedName("passcodeLength")
    @Expose
    private Integer passcodeLength;
    
    @SerializedName("deviceStatus")
    @Expose
    private String deviceStatus;
    
    @SerializedName("deviceColor")
    @Expose
    private String deviceColor;
    
    @SerializedName("features")
    @Expose
    private Features features;
    
    @SerializedName("lowPowerMode")
    @Expose
    private Boolean lowPowerMode;
    
    @SerializedName("rawDeviceModel")
    @Expose
    private String rawDeviceModel;
    
    @SerializedName("id")
    @Expose
    private String id;
    
    @SerializedName("remoteLock")
    @Expose
    private Object remoteLock;
    
    @SerializedName("isLocating")
    @Expose
    private Boolean isLocating;
    
    @SerializedName("modelDisplayName")
    @Expose
    private String modelDisplayName;
    
    @SerializedName("lostTimestamp")
    @Expose
    private String lostTimestamp;
    
    @SerializedName("batteryLevel")
    @Expose
    private Double batteryLevel;
    
    @SerializedName("mesg")
    @Expose
    private Object mesg;
    
    @SerializedName("locationEnabled")
    @Expose
    private Boolean locationEnabled;
    
    @SerializedName("lockedTimestamp")
    @Expose
    private Object lockedTimestamp;
    
    @SerializedName("locFoundEnabled")
    @Expose
    private Boolean locFoundEnabled;
    
    @SerializedName("snd")
    @Expose
    private Object snd;
    
    @SerializedName("fmlyShare")
    @Expose
    private Boolean fmlyShare;
    
    @SerializedName("lostDevice")
    @Expose
    private Object lostDevice;
    
    @SerializedName("lostModeCapable")
    @Expose
    private Boolean lostModeCapable;
    
    @SerializedName("wipedTimestamp")
    @Expose
    private Object wipedTimestamp;
    
    @SerializedName("deviceDisplayName")
    @Expose
    private String deviceDisplayName;
    
    @SerializedName("prsId")
    @Expose
    private Object prsId;
    
    @SerializedName("audioChannels")
    @Expose
    private List<Object> audioChannels = null;
    
    @SerializedName("locationCapable")
    @Expose
    private Boolean locationCapable;
    
    @SerializedName("batteryStatus")
    @Expose
    private String batteryStatus;
    
    @SerializedName("trackingInfo")
    @Expose
    private Object trackingInfo;
    
    @SerializedName("name")
    @Expose
    private String name;
    
    @SerializedName("isMac")
    @Expose
    private Boolean isMac;
    
    @SerializedName("thisDevice")
    @Expose
    private Boolean thisDevice;
    
    @SerializedName("deviceClass")
    @Expose
    private String deviceClass;
    
    @SerializedName("location")
    @Expose
    private Object location;
    
    @SerializedName("deviceModel")
    @Expose
    private String deviceModel;
    
    @SerializedName("maxMsgChar")
    @Expose
    private Integer maxMsgChar;
    
    @SerializedName("darkWake")
    @Expose
    private Boolean darkWake;
    
    @SerializedName("remoteWipe")
    @Expose
    private Object remoteWipe;

    public Object getMsg() 
    {
        return msg;
    }

    public void setMsg(Object msg) 
    {
        this.msg = msg;
    }

    public Boolean getCanWipeAfterLock() 
    {
        return canWipeAfterLock;
    }

    public void setCanWipeAfterLock(Boolean canWipeAfterLock) 
    {
        this.canWipeAfterLock = canWipeAfterLock;
    }

    public Boolean getWipeInProgress() 
    {
        return wipeInProgress;
    }

    public void setWipeInProgress(Boolean wipeInProgress) 
    {
        this.wipeInProgress = wipeInProgress;
    }

    public Boolean getLostModeEnabled() 
    {
        return lostModeEnabled;
    }

    public void setLostModeEnabled(Boolean lostModeEnabled) 
    {
        this.lostModeEnabled = lostModeEnabled;
    }

    public Boolean getActivationLocked() 
    {
        return activationLocked;
    }

    public void setActivationLocked(Boolean activationLocked) 
    {
        this.activationLocked = activationLocked;
    }

    public Integer getPasscodeLength() 
    {
        return passcodeLength;
    }

    public void setPasscodeLength(Integer passcodeLength) 
    {
        this.passcodeLength = passcodeLength;
    }

    public String getDeviceStatus() 
    {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) 
    {
        this.deviceStatus = deviceStatus;
    }

    public String getDeviceColor() 
    {
        return deviceColor;
    }

    public void setDeviceColor(String deviceColor) 
    {
        this.deviceColor = deviceColor;
    }

    public Features getFeatures() 
    {
        return features;
    }

    public void setFeatures(Features features) 
    {
        this.features = features;
    }

    public Boolean getLowPowerMode() 
    {
        return lowPowerMode;
    }

    public void setLowPowerMode(Boolean lowPowerMode) 
    {
        this.lowPowerMode = lowPowerMode;
    }

    public String getRawDeviceModel() 
    {
        return rawDeviceModel;
    }

    public void setRawDeviceModel(String rawDeviceModel) 
    {
        this.rawDeviceModel = rawDeviceModel;
    }

    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public Object getRemoteLock() 
    {
        return remoteLock;
    }

    public void setRemoteLock(Object remoteLock) 
    {
        this.remoteLock = remoteLock;
    }

    public Boolean getIsLocating() 
    {
        return isLocating;
    }

    public void setIsLocating(Boolean isLocating) 
    {
        this.isLocating = isLocating;
    }

    public String getModelDisplayName() 
    {
        return modelDisplayName;
    }

    public void setModelDisplayName(String modelDisplayName) 
    {
        this.modelDisplayName = modelDisplayName;
    }

    public String getLostTimestamp() 
    {
        return lostTimestamp;
    }

    public void setLostTimestamp(String lostTimestamp) 
    {
        this.lostTimestamp = lostTimestamp;
    }

    public Double getBatteryLevel() 
    {
        return batteryLevel;
    }

    public void setBatteryLevel(Double batteryLevel) 
    {
        this.batteryLevel = batteryLevel;
    }

    public Object getMesg() 
    {
        return mesg;
    }

    public void setMesg(Object mesg) 
    {
        this.mesg = mesg;
    }

    public Boolean getLocationEnabled() 
    {
        return locationEnabled;
    }

    public void setLocationEnabled(Boolean locationEnabled) 
    {
        this.locationEnabled = locationEnabled;
    }

    public Object getLockedTimestamp() 
    {
        return lockedTimestamp;
    }

    public void setLockedTimestamp(Object lockedTimestamp) 
    {
        this.lockedTimestamp = lockedTimestamp;
    }

    public Boolean getLocFoundEnabled() 
    {
        return locFoundEnabled;
    }

    public void setLocFoundEnabled(Boolean locFoundEnabled) 
    {
        this.locFoundEnabled = locFoundEnabled;
    }

    public Object getSnd() 
    {
        return snd;
    }

    public void setSnd(Object snd) 
    {
        this.snd = snd;
    }

    public Boolean getFmlyShare() 
    {
        return fmlyShare;
    }

    public void setFmlyShare(Boolean fmlyShare) 
    {
        this.fmlyShare = fmlyShare;
    }

    public Object getLostDevice() 
    {
        return lostDevice;
    }

    public void setLostDevice(Object lostDevice) 
    {
        this.lostDevice = lostDevice;
    }

    public Boolean getLostModeCapable() 
    {
        return lostModeCapable;
    }

    public void setLostModeCapable(Boolean lostModeCapable) 
    {
        this.lostModeCapable = lostModeCapable;
    }

    public Object getWipedTimestamp() 
    {
        return wipedTimestamp;
    }

    public void setWipedTimestamp(Object wipedTimestamp) 
    {
        this.wipedTimestamp = wipedTimestamp;
    }

    public String getDeviceDisplayName() 
    {
        return deviceDisplayName;
    }

    public void setDeviceDisplayName(String deviceDisplayName) 
    {
        this.deviceDisplayName = deviceDisplayName;
    }

    public Object getPrsId() 
    {
        return prsId;
    }

    public void setPrsId(Object prsId) 
    {
        this.prsId = prsId;
    }

    public List<Object> getAudioChannels() 
    {
        return audioChannels;
    }

    public void setAudioChannels(List<Object> audioChannels) 
    {
        this.audioChannels = audioChannels;
    }

    public Boolean getLocationCapable() 
    {
        return locationCapable;
    }

    public void setLocationCapable(Boolean locationCapable) 
    {
        this.locationCapable = locationCapable;
    }

    public String getBatteryStatus() 
    {
        return batteryStatus;
    }

    public void setBatteryStatus(String batteryStatus) 
    {
        this.batteryStatus = batteryStatus;
    }

    public Object getTrackingInfo() 
    {
        return trackingInfo;
    }

    public void setTrackingInfo(Object trackingInfo) 
    {
        this.trackingInfo = trackingInfo;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public Boolean getIsMac() 
    {
        return isMac;
    }

    public void setIsMac(Boolean isMac) 
    {
        this.isMac = isMac;
    }

    public Boolean getThisDevice() 
    {
        return thisDevice;
    }

    public void setThisDevice(Boolean thisDevice) 
    {
        this.thisDevice = thisDevice;
    }

    public String getDeviceClass() 
    {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) 
    {
        this.deviceClass = deviceClass;
    }

    public Object getLocation() 
    {
        return location;
    }

    public void setLocation(Object location) 
    {
        this.location = location;
    }

    public String getDeviceModel() 
    {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) 
    {
        this.deviceModel = deviceModel;
    }

    public Integer getMaxMsgChar() 
    {
        return maxMsgChar;
    }

    public void setMaxMsgChar(Integer maxMsgChar) 
    {
        this.maxMsgChar = maxMsgChar;
    }

    public Boolean getDarkWake() 
    {
        return darkWake;
    }

    public void setDarkWake(Boolean darkWake) 
    {
        this.darkWake = darkWake;
    }

    public Object getRemoteWipe() 
    {
        return remoteWipe;
    }

    public void setRemoteWipe(Object remoteWipe) 
    {
        this.remoteWipe = remoteWipe;
    }

    @Override
    public String toString() 
    {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() 
    {
        return new HashCodeBuilder().append(msg).append(canWipeAfterLock).append(wipeInProgress).append(lostModeEnabled)
                .append(activationLocked).append(passcodeLength).append(deviceStatus).append(deviceColor)
                .append(features).append(lowPowerMode).append(rawDeviceModel).append(id).append(remoteLock)
                .append(isLocating).append(modelDisplayName).append(lostTimestamp).append(batteryLevel).append(mesg)
                .append(locationEnabled).append(lockedTimestamp).append(locFoundEnabled).append(snd).append(fmlyShare)
                .append(lostDevice).append(lostModeCapable).append(wipedTimestamp).append(deviceDisplayName)
                .append(prsId).append(audioChannels).append(locationCapable).append(batteryStatus).append(trackingInfo)
                .append(name).append(isMac).append(thisDevice).append(deviceClass).append(location).append(deviceModel)
                .append(maxMsgChar).append(darkWake).append(remoteWipe).toHashCode();
    }

    @Override
    public boolean equals(Object other) 
    {
        if (other == this) 
        {
            return true;
        }
        if ((other instanceof Content) == false) 
        {
            return false;
        }
        Content rhs = ((Content) other);
        return new EqualsBuilder().append(msg, rhs.msg).append(canWipeAfterLock, rhs.canWipeAfterLock)
                .append(wipeInProgress, rhs.wipeInProgress).append(lostModeEnabled, rhs.lostModeEnabled)
                .append(activationLocked, rhs.activationLocked).append(passcodeLength, rhs.passcodeLength)
                .append(deviceStatus, rhs.deviceStatus).append(deviceColor, rhs.deviceColor)
                .append(features, rhs.features).append(lowPowerMode, rhs.lowPowerMode)
                .append(rawDeviceModel, rhs.rawDeviceModel).append(id, rhs.id).append(remoteLock, rhs.remoteLock)
                .append(isLocating, rhs.isLocating).append(modelDisplayName, rhs.modelDisplayName)
                .append(lostTimestamp, rhs.lostTimestamp).append(batteryLevel, rhs.batteryLevel).append(mesg, rhs.mesg)
                .append(locationEnabled, rhs.locationEnabled).append(lockedTimestamp, rhs.lockedTimestamp)
                .append(locFoundEnabled, rhs.locFoundEnabled).append(snd, rhs.snd).append(fmlyShare, rhs.fmlyShare)
                .append(lostDevice, rhs.lostDevice).append(lostModeCapable, rhs.lostModeCapable)
                .append(wipedTimestamp, rhs.wipedTimestamp).append(deviceDisplayName, rhs.deviceDisplayName)
                .append(prsId, rhs.prsId).append(audioChannels, rhs.audioChannels)
                .append(locationCapable, rhs.locationCapable).append(batteryStatus, rhs.batteryStatus)
                .append(trackingInfo, rhs.trackingInfo).append(name, rhs.name).append(isMac, rhs.isMac)
                .append(thisDevice, rhs.thisDevice).append(deviceClass, rhs.deviceClass).append(location, rhs.location)
                .append(deviceModel, rhs.deviceModel).append(maxMsgChar, rhs.maxMsgChar).append(darkWake, rhs.darkWake)
                .append(remoteWipe, rhs.remoteWipe).isEquals();
    }

}

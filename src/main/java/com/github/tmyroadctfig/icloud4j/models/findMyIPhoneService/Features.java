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
 * Model for {@link Features} used for JSON parsing.
 *
 * @author Jan Bastgen
 *
 */
public class Features 
{

    @SerializedName("MSG")
    @Expose
    private Boolean mSG;
    
    @SerializedName("LOC")
    @Expose
    private Boolean lOC;
    
    @SerializedName("LLC")
    @Expose
    private Boolean lLC;
    
    @SerializedName("CLK")
    @Expose
    private Boolean cLK;
    
    @SerializedName("TEU")
    @Expose
    private Boolean tEU;
    
    @SerializedName("LMG")
    @Expose
    private Boolean lMG;
    
    @SerializedName("SND")
    @Expose
    private Boolean sND;
    
    @SerializedName("CLT")
    @Expose
    private Boolean cLT;
    
    @SerializedName("LKL")
    @Expose
    private Boolean lKL;
    
    @SerializedName("SVP")
    @Expose
    private Boolean sVP;
    
    @SerializedName("LST")
    @Expose
    private Boolean lST;
    
    @SerializedName("LKM")
    @Expose
    private Boolean lKM;
    
    @SerializedName("WMG")
    @Expose
    private Boolean wMG;
    
    @SerializedName("XRM")
    @Expose
    private Boolean xRM;
    
    @SerializedName("PIN")
    @Expose
    private Boolean pIN;
    
    @SerializedName("LCK")
    @Expose
    private Boolean lCK;
    
    @SerializedName("REM")
    @Expose
    private Boolean rEM;
    
    @SerializedName("MCS")
    @Expose
    private Boolean mCS;
    
    @SerializedName("CWP")
    @Expose
    private Boolean cWP;
    
    @SerializedName("KEY")
    @Expose
    private Boolean kEY;
    
    @SerializedName("KPD")
    @Expose
    private Boolean kPD;
    
    @SerializedName("WIP")
    @Expose
    private Boolean wIP;

    public Boolean getMSG() 
    {
        return mSG;
    }

    public void setMSG(Boolean mSG) 
    {
        this.mSG = mSG;
    }

    public Boolean getLOC() 
    {
        return lOC;
    }

    public void setLOC(Boolean lOC) 
    {
        this.lOC = lOC;
    }

    public Boolean getLLC() 
    {
        return lLC;
    }

    public void setLLC(Boolean lLC) 
    {
        this.lLC = lLC;
    }

    public Boolean getCLK() 
    {
        return cLK;
    }

    public void setCLK(Boolean cLK) 
    {
        this.cLK = cLK;
    }

    public Boolean getTEU() 
    {
        return tEU;
    }

    public void setTEU(Boolean tEU) 
    {
        this.tEU = tEU;
    }

    public Boolean getLMG() 
    {
        return lMG;
    }

    public void setLMG(Boolean lMG) 
    {
        this.lMG = lMG;
    }

    public Boolean getSND() 
    {
        return sND;
    }

    public void setSND(Boolean sND) 
    {
        this.sND = sND;
    }

    public Boolean getCLT() 
    {
        return cLT;
    }

    public void setCLT(Boolean cLT) 
    {
        this.cLT = cLT;
    }

    public Boolean getLKL() 
    {
        return lKL;
    }

    public void setLKL(Boolean lKL) 
    {
        this.lKL = lKL;
    }

    public Boolean getSVP() 
    {
        return sVP;
    }

    public void setSVP(Boolean sVP) 
    {
        this.sVP = sVP;
    }

    public Boolean getLST() 
    {
        return lST;
    }

    public void setLST(Boolean lST) 
    {
        this.lST = lST;
    }

    public Boolean getLKM() 
    {
        return lKM;
    }

    public void setLKM(Boolean lKM) 
    {
        this.lKM = lKM;
    }

    public Boolean getWMG() 
    {
        return wMG;
    }

    public void setWMG(Boolean wMG) 
    {
        this.wMG = wMG;
    }

    public Boolean getXRM() 
    {
        return xRM;
    }

    public void setXRM(Boolean xRM) 
    {
        this.xRM = xRM;
    }

    public Boolean getPIN() 
    {
        return pIN;
    }

    public void setPIN(Boolean pIN) 
    {
        this.pIN = pIN;
    }

    public Boolean getLCK() 
    {
        return lCK;
    }

    public void setLCK(Boolean lCK) 
    {
        this.lCK = lCK;
    }

    public Boolean getREM() 
    {
        return rEM;
    }

    public void setREM(Boolean rEM) 
    {
        this.rEM = rEM;
    }

    public Boolean getMCS() 
    {
        return mCS;
    }

    public void setMCS(Boolean mCS) 
    {
        this.mCS = mCS;
    }

    public Boolean getCWP() 
    {
        return cWP;
    }

    public void setCWP(Boolean cWP) 
    {
        this.cWP = cWP;
    }

    public Boolean getKEY() 
    {
        return kEY;
    }

    public void setKEY(Boolean kEY) 
    {
        this.kEY = kEY;
    }

    public Boolean getKPD() 
    {
        return kPD;
    }

    public void setKPD(Boolean kPD) 
    {
        this.kPD = kPD;
    }

    public Boolean getWIP() 
    {
        return wIP;
    }

    public void setWIP(Boolean wIP) 
    {
        this.wIP = wIP;
    }

    @Override
    public String toString() 
    {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() 
    {
        return new HashCodeBuilder().append(mSG).append(lOC).append(lLC).append(cLK).append(tEU).append(lMG).append(sND)
                .append(cLT).append(lKL).append(sVP).append(lST).append(lKM).append(wMG).append(xRM).append(pIN)
                .append(lCK).append(rEM).append(mCS).append(cWP).append(kEY).append(kPD).append(wIP).toHashCode();
    }

    @Override
    public boolean equals(Object other) 
    {
        if (other == this) 
        {
            return true;
        }
        if ((other instanceof Features) == false) 
        {
            return false;
        }
        Features rhs = ((Features) other);
        return new EqualsBuilder().append(mSG, rhs.mSG).append(lOC, rhs.lOC).append(lLC, rhs.lLC).append(cLK, rhs.cLK)
                .append(tEU, rhs.tEU).append(lMG, rhs.lMG).append(sND, rhs.sND).append(cLT, rhs.cLT)
                .append(lKL, rhs.lKL).append(sVP, rhs.sVP).append(lST, rhs.lST).append(lKM, rhs.lKM)
                .append(wMG, rhs.wMG).append(xRM, rhs.xRM).append(pIN, rhs.pIN).append(lCK, rhs.lCK)
                .append(rEM, rhs.rEM).append(mCS, rhs.mCS).append(cWP, rhs.cWP).append(kEY, rhs.kEY)
                .append(kPD, rhs.kPD).append(wIP, rhs.wIP).isEquals();
    }

}

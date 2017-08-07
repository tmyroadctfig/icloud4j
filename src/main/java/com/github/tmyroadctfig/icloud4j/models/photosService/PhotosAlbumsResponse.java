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

public class PhotosAlbumsResponse {

    @SerializedName("folders")
    @Expose
    private List<PhotosFolder> folders = null;

    public List<PhotosFolder> getFolders() {
        return folders;
    }

    public void setFolders(List<PhotosFolder> folders) {
        this.folders = folders;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(folders).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PhotosAlbumsResponse) == false) {
            return false;
        }
        PhotosAlbumsResponse rhs = ((PhotosAlbumsResponse) other);
        return new EqualsBuilder().append(folders, rhs.folders).isEquals();
    }

}

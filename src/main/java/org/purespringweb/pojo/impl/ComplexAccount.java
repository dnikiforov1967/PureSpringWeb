/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.pojo.impl;

import java.util.Objects;

/**
 *
 * @author dima
 */
public class ComplexAccount {
    
    String subId;
    String postId;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.subId);
        hash = 71 * hash + Objects.hashCode(this.postId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexAccount other = (ComplexAccount) obj;
        if (!Objects.equals(this.subId, other.subId)) {
            return false;
        }
        if (!Objects.equals(this.postId, other.postId)) {
            return false;
        }
        return true;
    }
    
}

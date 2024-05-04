package com.lovebirds;

public abstract class Handler {

    protected static Profile profile;

    public static Profile getProfile() {
        return profile;
    }

    public boolean setProfile(Profile profile) {
        this.profile = profile;
        return true;
    }   
    
}

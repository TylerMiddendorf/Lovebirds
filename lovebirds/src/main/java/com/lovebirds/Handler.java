package com.lovebirds;

public abstract class Handler {

    protected Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public boolean setProfile(Profile profile) {
        this.profile = profile;
        return true;
    }   
    
}

package com.lovebirds;

public abstract class ProfileOperation {
    
    private Database db;
    public abstract boolean createProfile(Profile profile);
    public abstract Profile readProfile(int userID);
    public abstract boolean updateProfile(Profile profile);
    public abstract boolean deleteProfile(int userID);
    public abstract Preferences createPreferences(int userID, Preferences newPref);
    public abstract Preferences readPreferences(int userID);
    public abstract boolean updatePreferences(int userID, Preferences newPref);
    public abstract boolean deletePreferences(int userID);

}

package com.lovebirds;

public class ProfileOperationMySQL extends ProfileOperation{  

    /*
     * Need to add params to these functions as well as chain the functions in profilehandler to these
     */

    public Profile createProfile(Profile profile){
        return null;
    }

    public Profile readProfile(int userID){
        return null;
    }

    public boolean updateProfile(Profile profile){
        return true;
    }

    public boolean deleteProfile(int userID){
        return true;
    }

    public Preferences createPreferences(int userID, Preferences newPref){
        return null;
    }

    public Preferences readPreferences(int userID){
        return null;
    }

    public boolean updatePreferences(int userID, Preferences newPref){
        return true;
    }

    public boolean deletePreferences(int userID){
        return true;
    }
}

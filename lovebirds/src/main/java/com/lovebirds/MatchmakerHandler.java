package com.lovebirds;

import java.util.ArrayList;

public class MatchmakerHandler extends Handler {
    
    // displays the suggested users, generates the suggested users on call. 
    public ArrayList<Profile> retrieveSugUsers(int userID) {
        return new ArrayList<Profile>();
    }

    // after displaying / retrieve suggested users, the user will pick one of the profiles. Retrieve it
    public ArrayList<Profile> retrieveSugProfile(int id) {
        return new ArrayList<Profile>();
    }

    //filter based on average rating (set minimum average rating)
    public ArrayList<Profile> filterUsers(String filter) {
        return new ArrayList<Profile>();
    }

    /**
     * retrieves users' average rating of others and number of messages sent
     * @param stats
     * @return
     */
    public ArrayList<String> retrieveStatistics(String stats)
    {
        return new ArrayList<String>();
    }

}

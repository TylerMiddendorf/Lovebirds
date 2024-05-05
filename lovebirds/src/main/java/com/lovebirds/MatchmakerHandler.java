package com.lovebirds;

import java.util.ArrayList;

public class MatchmakerHandler extends Handler {
    
    // displays the suggested users, generates the suggested users on call. 
    public ArrayList<Profile> retrieveSugUsers() {
        MatchmakerOperation matchOperation = FactoryProducer.getSQLFactory().getMatchmaker("MySQL");
        ArrayList<Profile> sugUsers = matchOperation.readProfilesThatMatchPreferences(profile, -1); // call -1 as we are not filtering rating here
        return sugUsers;
    }

    // after displaying / retrieve suggested users, the user will pick one of the profiles. Retrieve it
    public Profile retrieveSugProfile(int id) {
        //uses a profile operation?
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        Profile profile = profileOperation.readProfile(id);
        return profile;
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

package com.lovebirds;

import java.util.ArrayList;

public class MatchmakerHandler extends Handler {
    
    // displays the suggested users, generates the suggested users on call. 
    public ArrayList<Profile> retrieveSugUsers(int rating) {
        int otherUserID = -1;
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        int userID = profile.getProfileID();
        Preferences preferences = profileOperation.readPreferences(userID);
        
        MatchmakerOperation matchOperation = FactoryProducer.getSQLFactory().getMatchmaker("MySQL");
        ArrayList<Profile> sugUsers = matchOperation.readProfilesThatMatchPreferences(preferences, rating); // call -1 as we are not filtering rating here
        ArrayList<Profile> notAlreadySeen = new ArrayList<>();
        for(int i = 0; i < sugUsers.size(); i++)
        {
            otherUserID = sugUsers.get(i).getProfileID();
            if(!matchOperation.alreadyRatedUser(profile.getProfileID(), otherUserID))
                notAlreadySeen.add(sugUsers.get(i));
        }
        return notAlreadySeen;
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
     * retrieves user's own average rating
     * @param stats
     * @return
     */
    public boolean retrieveStatistics()
    {
        MatchmakerOperation matchmakerOperation = FactoryProducer.getSQLFactory().getMatchmaker("MySQL");
        boolean statistics = matchmakerOperation.retrieveStatistics(profile.getProfileID());
        return statistics;
    }

    public boolean updateRelationship(int recipientID, String relationship) //matched, unmatched, blocked
    {
        MatchmakerOperation matchmakerOperation = FactoryProducer.getSQLFactory().getMatchmaker("MySQL");
        boolean updated = matchmakerOperation.relationship(profile.getProfileID(), recipientID, relationship);
        return updated;
    }

    public boolean rateUser(int recipientID, int rating) {
        MatchmakerOperation matchmakerOperation = FactoryProducer.getSQLFactory().getMatchmaker("MySQL");
        boolean rated = matchmakerOperation.rateUser(profile.getProfileID(), recipientID, rating);
        return rated;
    }

}

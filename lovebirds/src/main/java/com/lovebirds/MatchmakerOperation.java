package com.lovebirds;

import java.util.ArrayList;

@SuppressWarnings("unused") public abstract class MatchmakerOperation {
    private Database db;
    public abstract ArrayList<Profile> readProfilesThatMatchPreferences(Preferences preferences, double rating);
    public abstract Profile readProfile(int userID);   
    public abstract boolean rateUser(int userID, int recipientID, int rating);
    public abstract boolean relationship(int userID, int recipientID, String relationship);
    public abstract boolean deleteAllRelationships(int userID);
    public abstract boolean retrieveStatistics(int userID);
    public abstract boolean retrieveRatedUsers();
}

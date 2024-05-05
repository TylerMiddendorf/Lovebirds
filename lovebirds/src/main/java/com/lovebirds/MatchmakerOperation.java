package com.lovebirds;

import java.util.ArrayList;

@SuppressWarnings("unused") public abstract class MatchmakerOperation {
    private Database db;
    public abstract ArrayList<Profile> readProfilesThatMatchPreferences(Profile profile, double rating);
    public abstract Profile readProfile(int userID);
}

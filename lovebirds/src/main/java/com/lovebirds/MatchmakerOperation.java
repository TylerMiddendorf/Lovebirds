package com.lovebirds;

import java.util.ArrayList;

public abstract class MatchmakerOperation {
    private Database db;
    public abstract ArrayList<Profile> readProfilesThatMatchPreferences(Profile profile);
    public abstract Profile readProfile(int userID); // the same in profile operation
}

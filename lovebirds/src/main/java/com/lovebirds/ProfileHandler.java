package com.lovebirds;

import java.util.Scanner;

public class ProfileHandler extends Handler {


    public ProfileHandler() {
        
    }

    /*
     * Need to chain these CRUD functions to call the Profile Operation ones???
     */
    public boolean createProfile(Profile newProfile)
    {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        boolean created = profileOperation.createProfile(newProfile);
        // input the username and other data?
        return created;
    }

    public Profile editProfile(Profile profile)
    {
        //edit the profile
        //able to change first name, last name, age, email, username

        return profile;
    }

    public boolean deleteProfile(Profile profile)
    {
        // delete the profile from the database
        profile = null;

        return true; // profile deleted 
    }

    public boolean blockUser(Profile user)
    {
        // take user out of the profiles matches forever

        return true; // user has been blocked
    }

    public boolean dismissUser(Profile user)
    {
        // take user out of the profiles matches

        return true; // user has been dismissed
    }

    public boolean rateUser(Profile user)
    {
        // rate user 1-5
	    return true;
    }

    public boolean likeUser(Profile user)
    {
        boolean liked = false;
        // user may or may not like the user, if they do then turn true
        return liked;
    }

    public boolean unmatchUser(Profile user)
    {
        return true; // user has been unmatched
    }

    public Preferences createPreferences()
    {
        return null;
    }

    public boolean editPreferences(Profile user)
    {
        user.getPreferences();

        Preferences usersPreferences = user.getPreferences();

        // update preferences in the database
        GeneralFactory factory = FactoryProducer.getSQLFactory();
        ProfileOperation profileOp = factory.getProfile("mySQL");
        profileOp.updatePreferences(user.getProfileID(), usersPreferences);
        
        return true;
    }

    public Profile initializeProfile(int userID) {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        Profile profile = profileOperation.readProfile(userID);
        return profile;
    }

    public boolean deletePreferences()
    {
        return true;
    }

    private int loopForInteger(Scanner scan) {
		while(!scan.hasNextInt()) {
			scan.nextLine();
			System.out.print("\nPlease enter a valid integer.");
		}
		int num = scan.nextInt();
		return num;
	}
    
}
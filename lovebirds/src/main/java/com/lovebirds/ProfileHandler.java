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

    /**
     * updates the profile object with setters based on user entries
     * and the updates it in the database
     * NOT CURRENTLY UPDATING IN DATABASE
     * @param elementToEdit
     * @param editedElement
     * @return
     */
    public boolean editProfile(String elementToEdit, String editedElement)
    {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        
        switch (elementToEdit)
        {
            case "username": 
                profile.createUsername(editedElement);
                profileOperation.updateProfile(profile);

                //for testing
                System.out.println(profile.toString());

                break;
            case "email":
                profile.enterEmail(editedElement);
                profileOperation.updateProfile(profile);

                //for testing
                System.out.println(profile.toString());

                break;
            case "firstName":
                profile.setFirstName(editedElement);
                profileOperation.updateProfile(profile);

                //for testing
                System.out.println(profile.toString());

                break;
            case "lastName":
                profile.setLastName(editedElement);
                profileOperation.updateProfile(profile);

                //for testing
                System.out.println(profile.toString());

                break;
            case "profilePicture":
                profile.setProfilePicture(editedElement);
                profileOperation.updateProfile(profile);

                //for testing
                System.out.println(profile.toString());

                break;
            case "age":
                profile.setAge(Integer.parseInt(editedElement));
                profileOperation.updateProfile(profile);

                //for testing
                System.out.println(profile.toString());

                break;
            case "height":
                profile.setHeight(Integer.parseInt(editedElement));
                profileOperation.updateProfile(profile);

                //for testing
                System.out.println(profile.toString());

                break;
            case "weight":
                profile.setWeight(Integer.parseInt(editedElement));
                profileOperation.updateProfile(profile);

                //for testing
                System.out.println(profile.toString());

                break;
            case "gender":
                profile.setGender(editedElement);
                profileOperation.updateProfile(profile);

                //for testing
                System.out.println(profile.toString());

                break;
            case "password":
                profile.createPassword(editedElement);
                profileOperation.updateProfile(profile);

                //for testing
                System.out.println(profile.toString());

                break;
            default:
                //this is never entered
                break;
        }

        return true;
    }

    public boolean deleteProfile()
    {
        // delete the profile from the database
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        boolean deleted = profileOperation.deleteProfile(this.profile.getProfileID());
        return deleted;
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

    /**
     * checks ratings table in database
     * if (USER_ID -> RECIPIENT_ID = like(relationship)) and (RECIPIENT_ID -> USER_ID = like(relationship))
     * then allow unmatch
     * @param user
     * @return
     */
    public boolean unmatchUser(Profile user)
    {
        return true; // user has been unmatched
    }

    public boolean createPreferences(int userID, int minHeight, int maxHeight, int minWeight, int maxWeight, int minAge, int maxAge, String preferredGender)
    {
        Preferences newPreferences = new Preferences(preferredGender, minHeight, maxHeight, minWeight, maxWeight, minAge, maxAge);
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        boolean created = profileOperation.createPreferences(userID, newPreferences);
        return created;
    }

    public boolean editPreferences(Profile user)
    {
        user.getPreferences();

        Preferences usersPreferences = user.getPreferences();

        // update preferences in the database
        GeneralFactory factory = FactoryProducer.getSQLFactory();
        ProfileOperation profileOp = factory.getProfile("MySQL");
        profileOp.updatePreferences(user.getProfileID(), usersPreferences);
        return true;
    }

    public Profile initializeProfile(int userID) {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        Profile returnProfile = profileOperation.readProfile(userID);
        this.profile = returnProfile;
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
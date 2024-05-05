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
        boolean deleted = profileOperation.deleteProfile(profile.getProfileID());
        return deleted;
    }

    public boolean blockUser(Profile user)
    {
        // take user out of the profiles matches forever

        return true; // user has been blocked
    }

    public boolean rateUser(Profile user)
    {
        // rate user 1-5
	    return true;
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

    public boolean editPreferences(String elementToEdit, int editedElement)
    {

        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        int userID = profile.getProfileID();

        switch (elementToEdit)
        {
            case "gender":
                switch(editedElement)
                {
                    //Female
                    case 1:
                        profile.setPreferences("Female", profile.getPreferences().getMinHeight(), profile.getPreferences().getMaxHeight(), profile.getPreferences().getMinWeight(), profile.getPreferences().getMaxWeight(), profile.getPreferences().getMinAge(), profile.getPreferences().getMaxAge());
                        profileOperation.updatePreferences(userID, profile.getPreferences());
                        break;

                    //Male
                    case 2:
                        profile.setPreferences("Male", profile.getPreferences().getMinHeight(), profile.getPreferences().getMaxHeight(), profile.getPreferences().getMinWeight(), profile.getPreferences().getMaxWeight(), profile.getPreferences().getMinAge(), profile.getPreferences().getMaxAge());
                        profileOperation.updatePreferences(userID, profile.getPreferences());
                        break;

                    //Both
                    case 3:
                        profile.setPreferences("Both", profile.getPreferences().getMinHeight(), profile.getPreferences().getMaxHeight(), profile.getPreferences().getMinWeight(), profile.getPreferences().getMaxWeight(), profile.getPreferences().getMinAge(), profile.getPreferences().getMaxAge());
                        profileOperation.updatePreferences(userID, profile.getPreferences());
                        break;

                    default: //should never reach
                        System.out.println("Did not set gender, edit preferences error.");
                }
                break;

            case "minHeight":
                profile.setPreferences(profile.getPreferences().getPreferredGender(), editedElement, profile.getPreferences().getMaxHeight(), profile.getPreferences().getMinWeight(), profile.getPreferences().getMaxWeight(), profile.getPreferences().getMinAge(), profile.getPreferences().getMaxAge());
                profileOperation.updatePreferences(userID, profile.getPreferences());
                break;

            case "maxHeight":
                profile.setPreferences(profile.getPreferences().getPreferredGender(), profile.getPreferences().getMinHeight(), editedElement, profile.getPreferences().getMinWeight(), profile.getPreferences().getMaxWeight(), profile.getPreferences().getMinAge(), profile.getPreferences().getMaxAge());
                profileOperation.updatePreferences(userID, profile.getPreferences());
                break;

            case "minWeight":
                profile.setPreferences(profile.getPreferences().getPreferredGender(), profile.getPreferences().getMinHeight(), profile.getPreferences().getMaxHeight(), editedElement, profile.getPreferences().getMaxWeight(), profile.getPreferences().getMinAge(), profile.getPreferences().getMaxAge());
                profileOperation.updatePreferences(userID, profile.getPreferences());
                break;
            
            case "maxWeight":
                profile.setPreferences(profile.getPreferences().getPreferredGender(), profile.getPreferences().getMinHeight(), profile.getPreferences().getMaxHeight(), profile.getPreferences().getMinWeight(), editedElement, profile.getPreferences().getMinAge(), profile.getPreferences().getMaxAge());
                profileOperation.updatePreferences(userID, profile.getPreferences());
                break;

            case "minAge":
                profile.setPreferences(profile.getPreferences().getPreferredGender(), profile.getPreferences().getMinHeight(), profile.getPreferences().getMaxHeight(), profile.getPreferences().getMinWeight(), profile.getPreferences().getMaxWeight(), editedElement, profile.getPreferences().getMaxAge());
                profileOperation.updatePreferences(userID, profile.getPreferences());
                break;

            case "maxAge":
                profile.setPreferences(profile.getPreferences().getPreferredGender(), profile.getPreferences().getMinHeight(), profile.getPreferences().getMaxHeight(), profile.getPreferences().getMinWeight(), profile.getPreferences().getMaxWeight(), profile.getPreferences().getMinAge(), editedElement);
                profileOperation.updatePreferences(userID, profile.getPreferences());
                break;

            default: //should never reach
                System.out.println("Did not set preference, edit preferences error.");
        }

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
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        boolean deleted = profileOperation.deletePreferences(this.profile.getProfileID());
        return deleted;
    }
    
}
package com.lovebirds;


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
        return FactoryProducer.getSQLFactory().getMatchmaker("MySQL").relationship(profile.getProfileID(),user.getProfileID(),"Blocked"); // user has been blocked
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
        Preferences preferences = profileOperation.readPreferences(userID);

        switch (elementToEdit)
        {
            case "gender":
                switch(editedElement)
                {
                    //Female
                    case 1:
                        preferences.setPreferredGender("Female");
                        profileOperation.updatePreferences(userID, preferences);
                        break;

                    //Male
                    case 2:
                        preferences.setPreferredGender("Male");
                        profileOperation.updatePreferences(userID, preferences);
                        break;

                    //Both
                    case 3:
                        preferences.setPreferredGender("Both");
                        profileOperation.updatePreferences(userID, preferences);
                        break;

                    default: //should never reach
                        System.out.println("Did not set gender, edit preferences error.");
                }
                break;

            case "minHeight":
                preferences.setMinHeight(editedElement);
                profileOperation.updatePreferences(userID, preferences);
                break;

            case "maxHeight":
                preferences.setMaxHeight(editedElement);
                profileOperation.updatePreferences(userID, preferences);
                break;

            case "minWeight":
                preferences.setMinWeight(editedElement);
                profileOperation.updatePreferences(userID, preferences);
                break;
            
            case "maxWeight":
                preferences.setMaxWeight(editedElement);
                profileOperation.updatePreferences(userID, preferences);
                break;

            case "minAge":
                preferences.setMinAge(editedElement);
                profileOperation.updatePreferences(userID, preferences);
                break;

            case "maxAge":
                preferences.setMaxAge(editedElement);
                profileOperation.updatePreferences(userID, preferences);
                break;

            default: //should never reach
                System.out.println("Did not set preference, edit preferences error.");
        }

        return true;
    }

    public Profile initializeProfile(int userID) {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        Profile returnProfile = profileOperation.readProfile(userID);
        profile = returnProfile;
        return profile;
    }

    public boolean deletePreferences()
    {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        boolean deleted = profileOperation.deletePreferences(profile.getProfileID());
        return deleted;
    }
    
}
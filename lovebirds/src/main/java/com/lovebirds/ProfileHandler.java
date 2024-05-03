package com.lovebirds;

import java.util.Scanner;

public class ProfileHandler extends Handler {


    /*
     * Need to chain these CRUD functions to call the Profile Operation ones???
     */
    public Profile createProfile()
    {
        Profile profile = null; // input the username and other data?

        return profile;
    }

    public Profile editProfile(Profile profile)
    {
        //edit the profile

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
		int rating = 0;
	    displayRateUserMenu();
	    while (rating == 0) {
	        int userInput;
	        if (sc.hasNextInt()) { 
	            userInput = sc.nextInt();
	            if (userInput >= 1 && userInput <= 5) { 
	                rating = userInput;
	            } else {
	                System.out.println("\nInvalid input. Please rate the user 1-5.");
	                displayRateUserMenu();
	            }
	        } else {
	            sc.next(); 
	            System.out.print("\nPlease enter a valid integer.\n"); 
	            displayRateUserMenu();
	        }
	    }
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

    /*
     * edits preferences from a users profile.
     * updates the database.
     */
    public boolean editPreferences(Profile user)
    {
        user.getPreferences();
        // get the preferences from the profile
        // take in input from the user for new preference settings
        // set each new preference to the new preference in profile
        // update the new preferences for the profile in the database

        boolean edited = false;
        boolean correctNum = false;
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;


        Preferences usersPreferences = user.getPreferences();

        while(!edited)
        {
            displayEditPreferencesMenu();

            userInput = loopForInteger(scanner);

            switch (userInput) {
                case 1:
                    //update gender
                    while(!correctNum)
                    {
                        System.out.println("Choose your updated preferred gender: ");
                        System.out.println("1. Female");
                        System.out.println("2. Male");
                        System.out.println("3. Both");
                        System.out.println("Enter a number: ");
                        userInput = loopForInteger(scanner);
                        switch (userInput)
                        {
                        case 1:
                            usersPreferences.setPreferredGender("Female");
                            correctNum = true;
                            break;
                        case 2:
                            usersPreferences.setPreferredGender("Male");
                            correctNum = true;
                            break;
                        case 3:
                            usersPreferences.setPreferredGender("Both");
                            correctNum = true;
                            break;
                        default:
                            System.out.println("Enter a number 1-3.");
                            break;
                        }
                    }
                    correctNum = false;
                    break;

                case 2:
                    //min height
                    System.out.print("Enter preferred minimum height in inches: ");
                    userInput = loopForInteger(scanner);
                    usersPreferences.setMinHeight(userInput);
                    break;

                case 3:
                    //max height
                    System.out.print("Enter preferred maximum height in inches: ");
                    userInput = loopForInteger(scanner);
                    usersPreferences.setMaxHeight(userInput);
                    break;

                case 4:
                    //min weight
                    System.out.print("Enter preferred minimum weight in pounds: ");
                    userInput = loopForInteger(scanner);
                    usersPreferences.setMinWeight(userInput);
                    break;

                case 5:
                    //max weight
                    System.out.print("Enter preferred maximum weight in pounds: ");
                    userInput = loopForInteger(scanner);
                    usersPreferences.setMaxWeight(userInput);
                    break;

                case 6:
                    //min age
                    while(!correctNum)
                    {
                        System.out.print("Enter preferred minimum age: ");
                        userInput = loopForInteger(scanner);
                        if(userInput >= 18)
                        {
                            usersPreferences.setMinAge(userInput);
                            correctNum = true;
                        }
                        else
                            System.out.println("Minimum age must be at least 18.");
                    }
                    correctNum = false;
                    break;

                case 7:
                    //max age
                    System.out.print("Enter preferred maximum age: ");
                    userInput = loopForInteger(scanner);
                    usersPreferences.setMaxAge(userInput);
                    break;

                case 8:
                    // update preferences in the database
                    GeneralFactory factory = FactoryProducer.getSQLFactory();
                    ProfileOperation profileOp = factory.getProfile("mySQL");
                    profileOp.updatePreferences(user.getProfileID(), usersPreferences);

                    System.out.println("Preferences updated.");
                    edited = true;
                    break;
                default:
                    System.out.println("Enter a number 1-8.");
                    break;
            }
            
        }
        scanner.close();
        return true;
    }

    public boolean deletePreferences()
    {
        return true;
    }

    private void displayEditPreferencesMenu()
    {
        System.out.println("Which preference would you like to edit?");
        System.out.println("1. Gender");
        System.out.println("2. Minimum Height");
        System.out.println("3. Maximum Height");
        System.out.println("4. Minimum Weight");
        System.out.println("5. Maximum Weight");
        System.out.println("6. Minimum Age");
        System.out.println("7. Maximum Age");
        System.out.println("8. Finish Editing");
        System.out.print("Enter a number: ");
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
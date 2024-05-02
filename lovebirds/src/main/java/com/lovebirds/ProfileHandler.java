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

    public int rateUser(Profile user)
    {
        int rating = 0;
        //prompt for rating, set rating

        return rating;
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
        // get the preferences from the profile
        // take in input from the user for new preference settings
        // set each new preference to the new preference in profile
        // update the new preferences for the profile in the database

        boolean edited = false;
        boolean enteredInt = false;
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        Preferences usersPreferences = user.getPreferences();

        while(!edited)
        {
            displayEditPreferencesMenu();

            while(!enteredInt)
            {
                if(scanner.hasNextInt())
                {
                    userInput = scanner.nextInt();
                    enteredInt = true;
                }
                else
                {
                    System.out.println("Invalid input. Please enter a number.");
                    // Consume the invalid input to prevent an infinite loop
                    scanner.next();
                }
            }
            enteredInt = false;

            switch (userInput) {
                case 1:
                    usersPreferences.setPreferredGender(null);
                    break;
                case 2:
                    //min height
                    break;
                case 3:
                    //max height
                    break;
                case 4:
                    //min weight
                    break;
                case 5:
                    //max weight
                    break;
                case 6:
                    //min age
                    break;
                case 7:
                    //max age
                    break;
                case 8:
                    // new preference object update 
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
			System.out.print("Please enter a valid integer: ");
		}
		int num = scan.nextInt();
		return num;
	}
    
}
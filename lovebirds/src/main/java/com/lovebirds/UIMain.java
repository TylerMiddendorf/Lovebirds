package com.lovebirds;

import java.util.Scanner;

public class UIMain {

	static Controller controller;
    public static void main(String[] args) {
		//scanner object
		Scanner sc = new Scanner(System.in);
		controller = new Controller();
		String username = "";
		String password = "";

		//variables that assist with looped program
		int userInput = 0;
		boolean run = true;
				
		//welcome message
		System.out.println("Welcome to Lovebirds dating app!");

		// display menu for login, create account, forgot password, or exit

		// 2 if logging in
			// enter username & password
			// call logIn()
		// 3 forgot password
		// 4 exit
		//create profile, login, or quit options right here
		boolean firstTime = true;
		while(userInput == 0){
			if(!firstTime)
				System.out.println("Invalid Input (follow instructions)");
			displayLoginMenu();
			userInput = loopForInteger(sc);

			//this needs fixed (looped) because it does not require login after forgot password case

			//buffer scanner to prevent skipping over the next scanner
			sc.nextLine();
			switch (userInput) {
				case 1: //login
					System.out.print("Enter Username: ");
					username = sc.nextLine();
					System.out.print("Enter Password: ");
					password = sc.nextLine();
					int value = controller.logIn(username, password);
					//error handling something like this
					//int error_code;
					//System.out.println((error_code==-1)? "Server is Down":(error_code==-2)? "profile doesn't exist": "success");
					break;
				case 2: //Create Account
					System.out.print("Enter username: ");
					username = sc.nextLine();
					System.out.print("Enter email: ");
					String email = sc.nextLine();
					System.out.print("Enter password: ");
					password = sc.nextLine();
					System.out.print("Enter first name: ");
					String firstName = sc.nextLine();
					System.out.print("Enter last name: ");
					String lastName = sc.nextLine();
					System.out.print("Enter age: ");
					int age = loopForInteger(sc);
					System.out.print("Enter height: ");
					int height = loopForInteger(sc);
					System.out.print("Enter weight: ");
					int weight = loopForInteger(sc);
					System.out.print("Enter gender: ");
					String gender = sc.nextLine();
					controller.createProfile(username, email, firstName, lastName, "profile_picture", age, height, weight, gender, password);
					// 	call createPreferences()
					// 	enter & set preferences
					break;
				case 3: //Forgot Password
					boolean passwordReset = forgotPassword();
					if (passwordReset){
						System.out.println("\nPassword has been successfully reset");
					}
					else{
						System.out.println("\nError finding user with the details provided");
					}
					//userInput = 0 so it will loop back into switch statement
					userInput = 0;
					break;
				case 4: //exit
					System.out.println("Exiting...");
					System.exit(0);
				default:
					userInput = 0;		
			}
		}

		// then
		
		// How do we incorporate retrieveSugProfile
		// add text in the functions for the console messages instead of hardcoding in main
		// iterate through ArrayList in functions
		
		// display options menu (view matches "retrieveSugUsers()",
		// edit profile "editProfile()", edit preferences 
		// edit preferences "editPreferences()", edit album "editAlbum()",
		// logout "logOut()"
		// 1. View matches 
		// 2. Edit profile 
		// 3. Edit preferences
		// 4. Edit album
		// 5. Logout
		do 
		{
			//prints menu
			displayMenu();
			//gets user input
			userInput = loopForInteger(sc);
			
			//if-else-if for processing user input
			if(userInput < 1 || userInput > 6)
			{
				System.out.println("Invalid entry. Try again.");
			}
			else if(userInput == 6)
			{
				System.out.println("Logging out...");
				run = false;
			}
			else if(userInput == 1)
			{
				System.out.println("Call to retrieve suggested users.");
				//retrieve suggested users
					//loop to select specific user
						//loop for specific operations on user (like, match, dismiss, block, rate)
			}
			else if(userInput == 2)
			{
				System.out.println("Call to retrieve messages.");
				//retrieve messages
				//this is where you can see messages and people you've "matched with" via messages
			}
			else if(userInput == 3)
			{
				System.out.println("Call to edit profile.");
				//calls edit profile in controller 
				//able to change first name, last name, age, email, username
				Profile testProfile = null;
				controller.editProfile(testProfile);
			}
			else if(userInput == 4)
			{
				System.out.println("Call to edit preferences.");
				// retrieve the profile of the user that is currently logged in. 
				// call editPreferences with the profile of user
				Profile testProfile = null;
				//editPreferences(user);
			}
			else if(userInput == 5)
			{
				System.out.println("Call to edit album.");
                //edit album
			}
		}
		while(run);
		
		// if view matches
		// 	display matches ( call function "retrieveSugUsers()"):
		// 	displays one name from the ArrayList of Profiles
		// 	1. View user
		// 	2. Dismiss user
			
		// 	if View user								
		// 		display options menu 2 (like user "likeUser()", rate user "rateUser()", 
		// 		dismiss user "dismissUser()", unmatch user "unmatchUser()", block user "blockUser()"
		// 		1. Like user
		// 		2. Rate user
		int rating = 0;
	    displayRateUserMenu();
	    while (rating == 0) {
	        int ratingInput;
	        if (sc.hasNextInt()) { 
	            ratingInput = sc.nextInt();
	            if (ratingInput >= 1 && ratingInput <= 5) { 
	                rating = ratingInput;
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

		// 		3. Unmatch user
		// 		4. Block user
			
		// 		if Like user	
		// 			if (isLiked == false)
		// 				set "isLiked" variable to true
		// 			else
		// 				print("You already liked this user.")
		// 			go back to options menu 2
		// 		else if Rate user
		// 			print ("Rate this user 1-5: )
		// 			Scan the integer entered by the user
		// 			Store in ratings array/table
				
		// 		else if Unmatch user
		// 			remove this user from the ArrayList
		
		// 		else if Block user
		// 			// need to figure out the logic for this
			
		// 	else if Dismiss user
		// 		increment, move on to next user in ArrayList
			
		// else if edit profile 
		// 	call edit/updateProfile
		// 	Have option to go back to options menu
		
		// else if edit preferences
		// 	call edit/updatePreferences
		// 	Have option to go back to options menu	
		
		// else if edit album
		// 	call edit/updatePreferences
		// 	Have option to go back to options menu


		
		//goodbye message
		System.out.println("Thank you, Goodbye!");
		//close scanner
		sc.close();


    }//end main

	//displays menu for login
	private static void displayLoginMenu(){
		System.out.println("");
		System.out.println("1: Login");
		System.out.println("2: Create Account");
		System.out.println("3: Forgot Password");
		System.out.println("4: Exit");
		System.out.print("Select one of the following: ");
	}

    //displays menu for user data entries
    private static void displayMenu(){
        System.out.println("");
		System.out.println("1: Retrieve Suggested Users");
		System.out.println("2: Retrieve messages");
		System.out.println("3: Edit Profile");
		System.out.println("4: Edit Preferences");
		System.out.println("5: Edit Album");
		System.out.println("6: Logout");
		System.out.print("Select one of the following: ");
    }

	// displays menu for rate 
	private static void displayRateUserMenu() {
        System.out.println("Rate the user 1-5.");
        System.out.println("\n1: Not interested at all.");
        System.out.println("2: Not interested.");
        System.out.println("3: Kind of interested.");
        System.out.println("4: Interested.");
        System.out.println("5: Very interested.");
        System.out.print("Select one of the following: ");
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

	private void editPreferences(Profile user)
    {
		//controller = new Controller();
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
                    controller.editPreferences(user);

                    System.out.println("Preferences updated.");
                    edited = true;
                    break;
                default:
                    System.out.println("Enter a number 1-8.");
                    break;
            }
            
        }
        scanner.close();
    }

	private static int loopForInteger(Scanner scan) {
		while(!scan.hasNextInt()) {
			scan.nextLine();
			System.out.print("Please enter a valid integer.");
		}
		int num = scan.nextInt();
		return num;
	}


	/**
	 * get username, email, and new password from user to authenticate
	 * update users password in the database
	 * invoke forgotPassword in Controller
	 * @return
	 */
	private static boolean forgotPassword() {
		Scanner scan = new Scanner(System.in);
		String usernameInput;
		String emailInput;
		String newPasswordInput;
		boolean success = false;

		//if statement for matching inputs within database
		//if theres a match, ask user for new password, update password in database for that user,
		//set success to true
		//no match set success to false
		//return success

		System.out.print("Please enter your username: ");
		usernameInput = scan.nextLine();
		System.out.print("Please enter your email: ");
		emailInput = scan.nextLine();
		System.out.print("Please enter your new password: ");
		newPasswordInput = scan.nextLine();

		//this returns false if no profile is found in database
		boolean confirmedProfile = controller.forgotPassword(emailInput, usernameInput, newPasswordInput);

		if(confirmedProfile){
			success = true;
			return success;
		}

		return success;
	}

} //end UIMain

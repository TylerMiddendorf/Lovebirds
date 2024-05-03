package com.lovebirds;

import java.util.Scanner;

public class UIMain {

	static Controller controller;
    public static void main(String[] args){

		// welcome message
		// display menu for creating an account or logging in
		// if creating an account
		// call createProfile()
		// enter & set profile info
		// call createPreferences()
		// enter & set preferences
		// else if logging in
		// enter username & password
		// call logIn()
		
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
					System.out.print("Enter email: ");
					String email = sc.nextLine();
					System.out.print("Enter username: ");
					username = sc.nextLine();
					System.out.print("Enter password: ");
					password = sc.nextLine();
					System.out.print("Enter first name: ");
					String firstName = sc.nextLine();
					System.out.print("Enter last name: ");
					String lastName = sc.nextLine();
					controller.createProfile(email, username, password, firstName, lastName);
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
					System.exit(0);
				default:
					userInput = 0;		
			}
		}


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
				//edit profile
			}
			else if(userInput == 4)
			{
				System.out.println("Call to edit preferences.");
				//edit preferences
			}
			else if(userInput == 5)
			{
				System.out.println("Call to edit album.");
                //edit album
			}
		}
		while(run);
		
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

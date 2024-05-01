package com.lovebirds;

import java.util.Scanner;

public class UIMain {
	static Profile profile;
	static Controller controller;
    public static void main(String[] args){

		// welcome message
		// display menu for creating an account or logging in
		// if creating an account
		// 	call createProfile()
		// 	enter & set profile info
		// 	call createPreferences()
		// 	enter & set preferences
		// else if logging in
		// 	enter username & password
		// 	call logIn()
		
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
			System.out.println("");
			System.out.println("1: Login");
			System.out.println("2: Create Account");
			System.out.println("3: Forgot Password");
			System.out.println("4: Exit");
			System.out.print("Select one of the following: ");
			userInput = loopForInteger(sc);
			switch (userInput) {
				case 1://login
					System.out.println("Enter Username:");
					String username = sc.nextLine();
					System.out.println("Enter Password:");
					String password = sc.nextLine();
					int value = controller.logIn(username, password);
					break;
				case 2://Create Account
					// 	call createProfile()
					// 	enter & set profile info
					// 	call createPreferences()
					// 	enter & set preferences
					break;
				case 3://Forgot Password
					
					break;
				case 4://exit
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
			if(userInput < 1 || userInput > 5)
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
			}
			else if(userInput == 2)
			{
				//retrieve messages
				//this is where you can see messages and people you've "matched with" via messages
			}
			else if(userInput == 3)
			{
				//edit profile
			}
			else if(userInput == 4)
			{
				//edit preferences
			}
			else if(userInput == 5)
			{
                //edit album
			}
		}
		while(run);
		
		//goodbye message
		System.out.println("Thank you, Goodbye!");
		//close scanner
		sc.close();


    }//end main

    //displays menu for user data entries
    public static void displayMenu(){
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
			String clearInput = scan.nextLine();
			System.out.print("Please enter a valid integer: ");
		}
		int num = scan.nextInt();
		return num;
	}

} //end UIMain

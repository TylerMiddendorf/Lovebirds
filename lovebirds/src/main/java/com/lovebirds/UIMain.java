package com.lovebirds;

import java.util.ArrayList; // for printing matches
import java.util.Scanner;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.*;


public class UIMain {

	static Controller controller;
    public static void main(String[] args) {
		//scanner object
		Scanner sc = new Scanner(System.in);
		controller = new Controller();
		
		//variables that assist with looped program
		int userInput = 0;
		boolean run = true;
				
		//welcome message
		System.out.println("\nWelcome to Lovebirds dating app!");

		String[] lovebirdsLogo = {"\n\n____(0>       <0)____"," \\\\\\\\_//)   (\\\\_//// ","   ^  ^       ^  ^   "};
		String[] heartSymbol = {"\n      ***   ***  ","     ***** ***** ","    *************","     *********** ","      *********  ","       *******   ","        *****    ","         ***     ","          *      "};
		for(int i = 0; i < lovebirdsLogo.length; i++) {
			System.out.println(lovebirdsLogo[i]);
		}
		for(int i = 0; i < heartSymbol.length; i++) {
			System.out.println(heartSymbol[i]);
		}
		System.out.println();
		displayStartMenu(sc);

		// then
		// How do we incorporate retrieveSugProfile
		// add text in the functions for the console messages instead of hardcoding in main
		// iterate through ArrayList in functions
		
		// display options menu (view matches "retrieveSugUsers()",
		// edit profile "editProfile()", edit preferences 
		// edit preferences "editPreferences()", edit album "editAlbum()",
		// logout "logOut()"
		// 1. View matches
		// 2. View messages
		// 3. Edit profile 
		// 4. Edit preferences
		// 5. Edit album
		// 6. Logout
		// 7. Delete account
		do 
		{
			//prints menu
			displayHomeMenu();
			//gets user input
			userInput = loopForInteger(sc);
			
			//if-else-if for processing user input
			if(userInput < 1 || userInput > 20)
			{
				System.out.println("Invalid entry. Try again.");
			}
			else if(userInput == 1)
			{		
				displayRetrieveSuggestedUsersMenu(sc);
			}
			else if(userInput == 2)
			{
				System.out.println("Call to retrieve messages.");
				//retrieve messages
				if(controller.getMatched().length == 0){
					System.out.println("you have not matched with anyone");
				}else{
				int conversationChoice = 0;
				boolean firstTimeChat = true;
				do{
					if(!firstTimeChat)
						System.out.println("Please enter a valid number");
					System.out.print("\n1: View Conversation\n2: Clear Conversation\n3: Back\nSelect your choice: ");
					conversationChoice = loopForInteger(sc);
					firstTimeChat = false;
				}while(!(conversationChoice == 1 || conversationChoice == 2 || conversationChoice == 3));
				if(conversationChoice != 3){
				System.out.println("Matched users:");
				String[] chatUserNames = controller.getMatched();
				for(int i=0;i<chatUserNames.length;i++)
					System.out.println(i+": " + chatUserNames[i]);
				System.out.print("Select your choice: ");
				firstTimeChat = true;
				int chatUserChoice = 0;
				do{
					if(!firstTimeChat)
						System.out.println("Please enter a valid number");
					chatUserChoice = loopForInteger(sc);
					firstTimeChat = false;
				}while(chatUserChoice<0 && chatUserChoice < chatUserNames.length);
				if(conversationChoice == 1){//view conversation
					String[] convo = controller.getMessages(controller.getChatUser(chatUserChoice));
					for(String s:convo)
						System.out.println(s);
					System.out.print("\n1: Send Message\n2: back\n Select your choice: ");
					firstTimeChat = true;
					chatUserChoice = 0;
					do{
						if(!firstTimeChat)
							System.out.println("Please enter a valid number");
						chatUserChoice = loopForInteger(sc);
						firstTimeChat = false;
					}while(chatUserChoice!=1 && chatUserChoice != 2);
					if(chatUserChoice == 1){//send message
						String message = "";
						firstTimeChat = true;
						do{
							if(!firstTimeChat)
								System.out.print("Message too long, ");
							System.out.print("enter message of length 250 or less: ");
							message = sc.nextLine();
							firstTimeChat = false;
						}while(message.length()<250);
						controller.sendMessage(message, controller.getChatUser(chatUserChoice));
					}
				}else if(conversationChoice == 2){//clear conversation
					controller.clearConversation(controller.getChatUser(chatUserChoice));
				}
				//this is where you can see messages and people you've "matched with" via messages
				}}
			}
			else if(userInput == 3) {
				System.out.println("Call to edit profile.");
				//calls edit profile in controller 
				//able to change username, email, firstName, lastName, "profile_picture", age, height, weight, gender, password 
				editProfile();
			}
			else if(userInput == 4) {
				System.out.println("Call to edit preferences.");
				// retrieve the profile of the user that is currently logged in. 
				// call editPreferences with the profile of user
				
				editPreferences(); //edit preferences
				// 	Have option to go back to options menu	
			}
			else if(userInput == 5) {
				sc.nextLine();
				System.out.print("Please enter the name of the album you want to change: ");
				String albumName = sc.nextLine();
				System.out.print("Please enter the new name for the album: ");
				String newAlbumName = sc.nextLine();
				controller.editAlbum(albumName, newAlbumName);
			}
			else if(userInput == 6) {
				System.out.println("\nLogging out...");
				displayStartMenu(sc);
			}
			else if(userInput == 7) {
				controller.deleteProfile();
				System.out.println("\nGood riddance!");
				run = false;
			}	
			else if (userInput == 8) {
				controller.deletePreferences();
				System.out.println("\nYour preferences have been deleted. You will need to re-enter them.");
				run = false;
				// System.out.println("\nPlease enter the gender you want to match with: ");
				// String preferredGender = sc.nextLine();
				// System.out.println("Please enter your minimum height: ");
				// int minHeight = sc.nextInt();
				// System.out.println("Please enter your maximum height (enter 2000 if you have no preference): ");
				// int maxHeight = sc.nextInt();
				// System.out.println("Please enter your minimum weight (enter 0 if you have no preference): ");
				// int minWeight = sc.nextInt();
				// System.out.println("Please enter your maximum weight (enter 2000 if you have no preference): ");
				// int maxWeight = sc.nextInt();
				// System.out.println("Please enter your minimum age (enter 18 if you have no preference): ");
				// int minAge = sc.nextInt();
				// System.out.println("Please enter your maximum age (enter 2000 if you have no preference): ");
				// int maxAge = sc.nextInt();
				// sc.nextLine();
				// controller.createPreferences(userID, minHeight, maxHeight, minWeight, maxWeight, minAge, maxAge, preferredGender);
			} else if (userInput == 9) {
				sc.nextLine();
				System.out.print("Please enter what you want the album to be named: ");
				String albumName = sc.nextLine();
				System.out.println("\nNow you must upload a photo.");
				System.out.print("Please enter what you want to name your photo: ");
				String photoName = sc.nextLine();
				System.out.print("Please enter the file path: ");
				String path = "/Users/iangowland/Desktop/passports.png";
				controller.createPhoto(path, albumName, photoName);
			} else if (userInput == 10) {
				sc.nextLine();
				System.out.print("Please enter the album you want to upload to: ");
				String albumName = sc.nextLine();
				System.out.println("\nNow you must upload a photo.");
				System.out.print("Please enter what you want to name your photo: ");
				String photoName = sc.nextLine();
				System.out.print("Please enter the file path: ");
				String path = "/Users/iangowland/Desktop/passports.png";
				controller.uploadPhoto(path, albumName, photoName);
			} else if (userInput == 11) {
				controller.retrieveStatistics();
			}
		}
		while(run);
		
		//goodbye message
		System.out.println("\nThank you, Goodbye!");
		//close scanner
		sc.close();


    }//end main

	/**
	 * Helper method to display start menu
	 * Displays menu of options
	 */
	private static void displayStartMenu(Scanner sc){
		String username = "";
		String password = "";
		int userInput = 0;

		// display menu for login, create account, forgot password, or exit
		boolean firstTime = true;
		while(userInput == 0){
			if(!firstTime)
				System.out.println("Invalid Input (follow instructions)");
			firstTime = false;
			System.out.println("\n1: Login");
			System.out.println("2: Create Account");
			System.out.println("3: Forgot Password");
			System.out.println("4: Exit");
			System.out.print("Select your choice: ");
			userInput = loopForInteger(sc);

			//buffer scanner to prevent skipping over the next scanner
			sc.nextLine();
			switch (userInput) {
			//create profile, login, or quit options right here
				case 1: //login
				// enter username & password
				// call logIn()
					System.out.print("\nEnter username: ");
					username = sc.nextLine();
					System.out.print("Enter password: ");
					password = sc.nextLine();
					int resultID = controller.logIn(username, password);
					if(resultID != -1) {
						controller.initializeProfile(resultID);
					} else{
						firstTime = true;
						userInput = 0;
						System.out.println("Username and Profile are incorrect");
					}
		
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
					sc.nextLine();
					System.out.print("Enter gender: ");
					String gender = sc.nextLine();
					boolean created = controller.createProfile(username, email, firstName, lastName, "profile_picture", age, height, weight, gender, password);

					if(!created) {
						System.out.println("Account could not be created. Please try again.");
						continue;
					}

					int userID = controller.logIn(username, password);
					// could we makethe code below into a helper method (lines 76-93)?
					System.out.println("\nNow you need to enter your preferences that will be used for matching!\n");

					System.out.print("\nPlease enter the gender you want to match with: ");
					String preferredGender = sc.nextLine();
					System.out.print("Please enter your minimum height (in inches, enter 0 if you have no preference): ");
					int minHeight = loopForInteger(sc);
					System.out.print("Please enter your maximum height (in inches, enter 2000 if you have no preference): ");
					int maxHeight = loopForInteger(sc);
					System.out.print("Please enter your minimum weight (enter 0 if you have no preference): ");
					int minWeight = loopForInteger(sc);;
					System.out.print("Please enter your maximum weight (enter 2000 if you have no preference): ");
					int maxWeight = loopForInteger(sc);
					String agePrompt = "Please enter your minimum age (enter 18 if you have no preference): ";
					System.out.print(agePrompt);
					int minAge = loopForInteger(sc);
					while(minAge < 18) {
						System.out.print("\nInvalid option. Go get some help. No Diddy. No Drizzy.\n\n" + agePrompt);
						minAge = loopForInteger(sc);
					}
					System.out.print("Please enter your maximum age (enter 2000 if you have no preference): ");
					int maxAge = loopForInteger(sc);
					sc.nextLine();
					controller.createPreferences(userID, minHeight, maxHeight, minWeight, maxWeight, minAge, maxAge, preferredGender);

					userInput = 0;
					firstTime = true;
					break;

				case 3: //Forgot Password
					boolean success = forgotPassword(sc);
					if (success)
					{
						System.out.println("\nPassword successfully reset.");
					}
					
					userInput = 0;
					firstTime = true;
					break;
				case 4: //exit
					System.out.println("Exiting...");
					System.exit(0);
				default:
					userInput = 0;		
			}
		}
	}

	/**
	 * Helper method to display a menu after login 
	 * Displays menu of options
	 */
    private static void displayHomeMenu(){
		System.out.println("\n1: Retrieve suggested users");
		System.out.println("2: Retrieve messages");
		System.out.println("3: Edit profile");
		System.out.println("4: Edit preferences");
		System.out.println("5: Edit album");
		System.out.println("6: Logout");
		System.out.println("7: Delete account");
		System.out.println("8: Delete preferences.");
		System.out.println("9. Create album (you must upload at least one photo)");
		System.out.println("10. Upload photo(s) to existing album");
		System.out.println("11. Retrieve statistics");
		System.out.print("Select your choice: ");
    }
	
	/*
	 * Helper method for editPreferences
	 * Displays menu of options
	 */
	private static void displayEditPreferencesMenu()
    {
        System.out.println("\nWhich preference would you like to edit?");
        System.out.println("1. Preferred gender");
        System.out.println("2. Minimum height");
        System.out.println("3. Maximum height");
        System.out.println("4. Minimum weight");
        System.out.println("5. Maximum weight");
        System.out.println("6. Minimum age");
        System.out.println("7. Maximum age");
        System.out.println("8. Finish editing");
        System.out.print("Select your choice: ");
    }

	/**
	 * Helper method for editProfile
	 * Displays menu of options
	 */
	private static void displayEditProfileMenu()
	{
		System.out.println("\nWhich element of your profie would you like to edit?");
        System.out.println("1. Username");
        System.out.println("2. Email");
        System.out.println("3. First name");
        System.out.println("4. Last name");
        System.out.println("5. Profile picture");
        System.out.println("6. Age");
        System.out.println("7. Height");
		System.out.println("8. Weight");
		System.out.println("9. Gender");
		System.out.println("10. Password");
		System.out.println("11. Exit 'Edit profile'");
        System.out.print("Select your choice: ");
	}

	private static void displayRetrieveSuggestedUsersMenu(Scanner sc) {
		int userInput = 0;
		int rating = -1;
		ArrayList<Profile> sugUsers;
		boolean dismissed = false;

		System.out.println("Would you like to also filter by rating?");
		System.out.println("Enter '1' for yes, or any other number for no: ");
		userInput = loopForInteger(sc);

		if(userInput == 1)
		{
			System.out.println("Enter a minimum rating 1-5: ");
			rating = loopForInteger(sc);
			sugUsers = controller.retrieveSugUsers(rating);
		}
		else
		{
			sugUsers = controller.retrieveSugUsers(-1);
		}

		if( sugUsers == null)
		{
			System.out.println("There are no suggested users for you.");
			System.out.println("Try editing your preferences.");
		}
		else
		{
			for(int i = 0; i < sugUsers.size(); i++)
			{
				System.out.println("Here is a profile that is suggested for you:");
				System.out.println('\n' + sugUsers.get(i).getFirstName() + " " + sugUsers.get(i).getLastName());
				while (!dismissed)
				{
					System.out.println("\nWhat would you like to do?");
					System.out.println("1. View profile");
					System.out.println("2. Dismiss user");
					System.out.print("Select your choice: ");

					userInput = loopForInteger(sc);

					switch (userInput)
					{
						case 1:
							displayViewProfileMenu(sugUsers.get(i), sc);
							break;
						case 2:
							System.out.println("User dismissed."); // just go to next profile
							dismissed = true;
							break;
						default:
							System.out.println("Choose '1' or '2', try again.");
							break;
					}
				}
				dismissed = false; //reset dismissed for next profile
			}
		}
	}

	private static void displayViewProfileMenu(Profile matchedProfile, Scanner sc)
	{

		int userInput = 0;
		boolean goBack = false;

		while(!goBack)
		{
			System.out.println(matchedProfile.getFirstName() + " " + matchedProfile.getLastName());
			System.out.println("Age: " + matchedProfile.getAge());
			System.out.println("Height: " + matchedProfile.getHeight());
			System.out.println("Weight: " + matchedProfile.getWeight());
			System.out.println("Gender: " + matchedProfile.getGender());

			//ADD THE DISPLAYING OF PROFILE PICTURE
			display(controller.getImage(matchedProfile.getProfileID()));

			System.out.print("\nRate this user (1-5): ");
			int rating = 0;
			while (rating == 0) {
				int ratingInput;
				if (sc.hasNextInt()) { 
					ratingInput = sc.nextInt();
					if (ratingInput >= 1 && ratingInput <= 5) { 
						rating = ratingInput;
					} else {
						System.out.println("\nInvalid input. Please rate the user 1-5.");
					}
				} else {
					sc.next(); 
					System.out.print("\nPlease enter a valid integer.\n"); 
				}
			}
			controller.rateUser(matchedProfile.getProfileID(), rating);
			System.out.println("\nWhat would you like to do?");
			System.out.println("1. Match user"); // like this profile
			System.out.println("2. Unmatch user"); // remove like from profile
			System.out.println("3. Block user");

			System.out.print("Selectr your choice: ");
			userInput = loopForInteger(sc);

			switch (userInput)
			{
				case 1://match user
				controller.changeRelationship(matchedProfile.getProfileID(), "matched");
					goBack = true;
					break;
				case 2:// unmatch user
				controller.changeRelationship(matchedProfile.getProfileID(), "unmatched");
					goBack = true;
					break;
				case 3://block user
					controller.changeRelationship(matchedProfile.getProfileID(), "blocked");
					goBack = true;
					break;
				default:
					System.out.println("Enter a number 1-5, try again.");
					break;
			}
		}
	}

	/**
	 * Edit profile method that assists with editing elements of a user's profile
	 * this includes username, email, firstName, lastName, "profile_picture", age, height, weight, gender, password
	 * CASE 11 EXITING LOOP GIVES AN ERROR 
	 * @param user
	 */
	private static void editProfile()
	{
		boolean edited = false;
		boolean correctNum = false;
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		String elementToEdit = "";

		while(!edited)
		{

			displayEditProfileMenu();

			userInput = loopForInteger(scanner);

			//edit below
			switch (userInput) {
                case 1:
                    //update username
					System.out.print("Enter your updated username: ");
					scanner.nextLine();
					String editedUsername = scanner.nextLine();
					elementToEdit = "username";
					controller.editProfile(elementToEdit, editedUsername);
                    break;

                case 2:
                    //update email
                    System.out.print("Enter your updated email: ");
                    scanner.nextLine();
					String editedEmail = scanner.nextLine();
					elementToEdit = "email";
					controller.editProfile(elementToEdit, editedEmail);
                    break;

                case 3:
                    //update first name
                    System.out.print("Enter your updated first name: ");
                    //capture user input and update profile
					scanner.nextLine();
					String editedFirstName = scanner.nextLine();
					elementToEdit = "firstName";
					controller.editProfile(elementToEdit, editedFirstName);
                    break;

                case 4:
                    //update last name
                    System.out.print("Enter your updated last name: ");
                    //capture user input and update profile
					scanner.nextLine();
					String editedLastName = scanner.nextLine();
					elementToEdit = "lastName";
					controller.editProfile(elementToEdit, editedLastName);
                    break;

                case 5:
                    //update profile picture
                    System.out.print("Enter your updated profile picture: ");
                    //capture user input and update profile
					scanner.nextLine();
					String editedProfilePicture = scanner.nextLine();
					elementToEdit = "profilePicture";
					controller.editProfile(elementToEdit, editedProfilePicture);
                    break;

                case 6:
                    //update age
                    while(!correctNum)
                    {
                        System.out.print("Enter your updated age: ");
                        userInput = loopForInteger(scanner);
                        if(userInput >= 18)
                        {
                            //capture user input and update profile
							String editedAge = String.valueOf(userInput);
							elementToEdit = "age";
							controller.editProfile(elementToEdit, editedAge);
							correctNum = true;
                        }
                        else
                            System.out.println("Must be at least 18 years old.");
                    }
                    correctNum = false;
                    break;

                case 7:
                    //update height
                    System.out.print("Enter your updated height: ");
                    userInput = loopForInteger(scanner);
                    //capture user input and update profile
					String editedHeight = String.valueOf(userInput);
					elementToEdit = "height";
					controller.editProfile(elementToEdit, editedHeight);
					correctNum = true;
                    break;

				case 8:
					//update weight
					System.out.print("Enter your updated weight: ");
					userInput = loopForInteger(scanner);
					//capture user input and update profile
					String editedWeight = String.valueOf(userInput);
					elementToEdit = "weight";
					controller.editProfile(elementToEdit, editedWeight);
					correctNum = true;
					break;

				case 9:
					//update gender
					System.out.print("Enter your updated gender: ");
					//capture user input and update profile
					scanner.nextLine();
					String editedGender = scanner.nextLine();
					elementToEdit = "gender";
					controller.editProfile(elementToEdit, editedGender);
					break;

				case 10:
					//update password
					System.out.print("Enter your updated password: ");
					//capture user input and update profile
					scanner.nextLine();
					String editedPassword = scanner.nextLine();
					elementToEdit = "password";
					controller.editProfile(elementToEdit, editedPassword);
					break;

                case 11:
                    //exit loop
					System.out.println("Your profile has been updated.");
                    edited = true;
                    break;
                default:
                    System.out.println("Enter a number 1-11.");
                    break;
            }
            
        }
        scanner.close();
	}

	private static void editPreferences()
	{
		boolean edited = false;
		boolean correctNum = false;
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		String elementToEdit = "";

		while(!edited)
		{

			displayEditPreferencesMenu();

			userInput = loopForInteger(scanner);

			//edit below
			switch (userInput) {
                case 1:
					elementToEdit = "gender";
					System.out.println("Choose your preferred gender. ");
					System.out.println("1. Female");
					System.out.println("2. Male");
					System.out.println("3. Both");
					System.out.print("Select your choice: ");
					userInput = loopForInteger(scanner);
					switch (userInput)
					{
						case 1:
							controller.editPreferences(elementToEdit, 1);
							break;
						case 2:
							controller.editPreferences(elementToEdit, 2);
							break;
						case 3:
							controller.editPreferences(elementToEdit, 3);
							break;
						default:
							System.out.println("Enter a number 1-3. Please try again.");

					}
					break;

                case 2: 
					elementToEdit = "minHeight";
					System.out.print("Enter preferred minimum height (in inches): ");
					userInput = loopForInteger(scanner);
					controller.editPreferences(elementToEdit, userInput);
					break;

                case 3:
					elementToEdit = "maxHeight";
					System.out.print("Enter preferred maximum height (in inches): ");
					userInput = loopForInteger(scanner);
					controller.editPreferences(elementToEdit, userInput);
					break;

                case 4:
					elementToEdit = "minWeight";
					System.out.print("Enter preferred minimum weight (in pounds): ");
					userInput = loopForInteger(scanner);
					controller.editPreferences(elementToEdit, userInput);
					break;

                case 5:
					elementToEdit = "maxWeight";
					System.out.print("Enter preferred maximum weight (in pounds): ");
					userInput = loopForInteger(scanner);
					controller.editPreferences(elementToEdit, userInput);
					break;

                case 6:
                    elementToEdit = "minAge";
                    while(!correctNum)
                    {
                        System.out.print("Enter your preferred minimum age: ");
                        userInput = loopForInteger(scanner);
                        if(userInput >= 18)
                        {
							controller.editPreferences(elementToEdit, userInput);
							correctNum = true;
                        }
                        else
                            System.out.println("Must be at least 18 years old.");
                    }
                    correctNum = false;
                    break;

                case 7:
					elementToEdit = "maxAge";
					while(!correctNum)
					{
						System.out.print("Enter your preferred maximum age: ");
						userInput = loopForInteger(scanner);
						if(userInput >= 18)
						{
							controller.editPreferences(elementToEdit, userInput);
							correctNum = true;
						}
						else
							System.out.println("Must be at least 18 years old.");
					}
					correctNum = false;
					break;

                case 8:
					System.out.println("Your preferences have been updated.");
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
			System.out.print("Please enter a valid integer: ");
			scan.next();
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
	private static boolean forgotPassword(Scanner sc) {
		String usernameInput;
		String emailInput;
		String newPasswordInput;

		System.out.print("Please enter your username: ");
		usernameInput = sc.nextLine();
		System.out.print("Please enter your email: ");
		emailInput = sc.nextLine();
		System.out.print("Please enter your new password: ");
		newPasswordInput = sc.nextLine();

		//searching for username and email in database
		boolean success = controller.forgotPassword(emailInput, usernameInput, newPasswordInput);
		return success;
	}
	private static JFrame frame;
	private static JLabel label;
	public static void display(BufferedImage image){
   		if(frame==null){
       		frame=new JFrame();
       	frame.setTitle("stained_image");
       	frame.setSize(image.getWidth(), image.getHeight());
       	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       	label=new JLabel();
       	label.setIcon(new ImageIcon(image));
       	frame.getContentPane().add(label,BorderLayout.CENTER);
       	frame.setLocationRelativeTo(null);
       	frame.pack();
       	frame.setVisible(true);
   		}else label.setIcon(new ImageIcon(image));
	}

} //end UIMain

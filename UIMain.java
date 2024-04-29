import java.util.Scanner;

public class UIMain {
    public static void main(String[] args){

        //scanner object
		Scanner sc = new Scanner(System.in);
		
		//variables that assist with looped program
		int userInput = 0;
		boolean run = true;
		
		//welcome message
		System.out.println("Welcome to Lovebirds dating app!");

		//create profile, login, or quit options right here
	
		do 
		{
			//prints menu
			displayMenu();
			//gets user input
			userInput = sc.nextInt();
			
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
		System.out.println("Select one of the following: ");
		System.out.println("1: Retrieve Suggested Users");
		System.out.println("2: Retrieve messages");
		System.out.println("3: Edit Profile");
		System.out.println("4: Edit Preferences");
		System.out.println("5: Edit Album");
		System.out.print("6: Logout");
    }

	private static int loopForInteger(Scanner scan) {
		while(!scan.hasNextInt()) {
			String clearInput = scan.nextLine();
			System.out.print("Please enter a valid integer: ");
		}
		int num = scan.nextInt();
		return num;
	}

}//end UIMain

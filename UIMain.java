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
			else if(userInput == 5)
			{
				run = false;
			}
			else if(userInput == 1)
			{
				System.out.println("Option 1 selected");
			}
			else if(userInput == 2)
			{
				System.out.println("Option 2 selected");
			}
			else if(userInput == 3)
			{
				System.out.println("Option 3 selected");
			}
			else if(userInput == 4)
			{
                System.out.println("Option 4 selected");
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
		System.out.println("1: For fun");
		System.out.println("2: For fun");
		System.out.println("3: For fun");
		System.out.println("4: For fun");
		System.out.println("5: For fun");
    }

}//end UIMain

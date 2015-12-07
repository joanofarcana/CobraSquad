// ---------------------------------------------------------------
// Assignment 3 part 1

// Written by: Nina Prentiss		26270611

// For COMP249/2 Section D 
// ---------------------------------------------------------------
import java.io.*;
import java.util.*;

public class CellHashUtilization {

	public static void main(String[] args) {
		
		// Welcome Message
		System.out.println("|--------------------------------------------------|\n"
						+ "|                                                  |\n"
						+ "|                Welcome to Part 2                 |\n"
						+ "|                 Using CellHash                   |\n"
						+ "|                                                  |\n"
						+ "|--------------------------------------------------|\n");
		
		try {
			// Creating a CellHash object
			System.out.println("Now creating a Cell Hash object...");
			CellHash cellHash = new CellHash();
			
			// Initializing cellHash object with info from Cell_Info.txt
			cellHash.addToHashTable();
			
			// User Input
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Now we'll search for some serial numbers.");
			boolean cont = true;
			long userSerial;
			while (cont) {
				System.out.print("Please enter a serial number to search for: ");
				userSerial = Long.parseLong(keyboard.next());
				cellHash.findCell(userSerial);
				
				System.out.print("Would you like to search for another serial number? (Y/N) ");
				String userInput = keyboard.next();
				if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("no")) {
					cont = false;
					System.out.println();
				}
			}
			keyboard.close();
			
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			System.out.println("The program will now terminate.");
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("The program will now terminate.");
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("The program will now terminate.");
		}
		// Goodbye Message
		System.out.println();
		System.out.println("|--------------------------------------------------|\n"
				+ "|                                                  |\n"
				+ "|                  Program End.                    |\n"
				+ "|             Thank you and Good-bye               |\n"
				+ "|                                                  |\n"
				+ "|--------------------------------------------------|");
					
		
	}

}

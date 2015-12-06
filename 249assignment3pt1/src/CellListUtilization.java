// ---------------------------------------------------------------
//
// Assignment 3 part 1
// Written by: Nina Prentiss		26270611
// For COMP249/2 Section D 
//
// ---------------------------------------------------------------

import java.io.*;
import java.util.*;

public class CellListUtilization {

	public static void main(String[] args) {
		// TODO test constructors/methods of classes, use special cases
		
		// Important Attributes
		String fileName = "Cell_Info.txt";
		
		// Welcome Message
		System.out.println("|--------------------------------------------------|\n"
						+ "|                                                  |\n"
						+ "|                Welcome to Part 1                 |\n"
						+ "|                 Using CellList                   |\n"
						+ "|                                                  |\n"
						+ "|--------------------------------------------------|");
		
		
		// Create two empty CellLists
		CellList list1 = new CellList();
		CellList list2 = new CellList();
		
		System.out.println("Now reading " + fileName + "...");
		
		
		// Open Cell_Info.txt and read its contents, assigning values to list1
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			boolean cont = true;
			while (cont) {
				String line = bufferedReader.readLine();
				if (line != null &&!line.isEmpty()) {	
					int year = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1, line.length()));

					line = line.substring(0, line.lastIndexOf(" ")).trim();
					double price = Double.parseDouble(line.substring(line.lastIndexOf(" ") + 1, line.length()));

					line = line.substring(0, line.lastIndexOf(" ")).trim();
					String brand = line.substring(line.lastIndexOf(" ") + 1, line.length());

					line = line.substring(0, line.lastIndexOf(" ")).trim();
					long serialNumber = Long.parseLong(line);
					
					CellPhone temp = new CellPhone(serialNumber, brand, year, price);
					if (list1.find(temp.getSerialNum()) == null) {
						list1.addToStart(temp);
					}
				
				}
				else {
					cont = false;
					System.out.println("Finished reading " + fileName + ".");
					System.out.println();
				}
			}
			bufferedReader.close();
			
			
			// Shows contents of list1
			list1.showContents();
			System.out.println();
			
			
			// Search list1 for user-inputed serial numbers
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			String userInput;
			long userSerial;
			cont = true;
			System.out.println("Let's search for a serial number.");
			while (cont) {
				System.out.print("Please enter a serial number to search for: ");
				userSerial = Long.parseLong(keyboard.readLine());
				
				CellList.CellNode duplicate = list1.find(userSerial);
				if (duplicate != null) {
					System.out.println("Serial number found. " + duplicate.getCellPhone());
				}
				else {
					System.out.println("Serial number not found.");
				}
				
				System.out.print("Would you like to search for another serial number? (Y/N) ");
				userInput = keyboard.readLine();
				if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("no")) {
					cont = false;
					System.out.println();
				}
			}
			
			// Playing with Methods
			// copying list1 into list2
			System.out.println("Now copying list1 to list2.");
			list2 = new CellList(list1);
			
			// are they the same?
			if (list1.equals(list2)) 
				System.out.println("List1 and list2 are equal.");
			else
				System.out.println("List1 and list2 are not equal. Something is wrong.");
			
			// create some new CellPhones
			System.out.println("");
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("The program will now terminate.");
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("The program will now terminate.");
		}
		catch (NoSuchElementException e) {
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

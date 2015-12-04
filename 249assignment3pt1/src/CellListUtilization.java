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
		// TODO Goodbye Message
		
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
					System.out.println("Finished reading " + fileName + ".\n");
				}
			}
			bufferedReader.close();
			
			// Shows contents of list1
			list1.showContents();
			
			
			// Search list1 for user-inputed serial numbers
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			String userInput;
			String no = "N";
			System.out.println("Let's search for a serial number.");
			long userSerial;
			cont = true;
			while (cont) {
				System.out.print("Please enter a serial number to search for: ");
				userSerial = Long.parseLong(keyboard.readLine());
				
				if (list1.find(userSerial) != null) {
					System.out.println("Serial number found. " + list1.find(userSerial).getCellPhone());
				}
				else {
					System.out.println("Serial number not found.");
				}
				
				System.out.print("Would you like to search for another serial number? (Y/N) ");
				userInput = keyboard.readLine();
				if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("no")) {
					cont = false;
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		
		// Goodbye Message
		System.out.println("\n|--------------------------------------------------|\n"
				+ "|                                                  |\n"
				+ "|                  Program End.                    |\n"
				+ "|             Thank you and Good-bye               |\n"
				+ "|                                                  |\n"
				+ "|--------------------------------------------------|");
	}

}

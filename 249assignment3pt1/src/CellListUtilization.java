// ---------------------------------------------------------------
//
// Assignment 3 part 1
// Written by: Nina Prentiss		26270611
// For COMP249/2 Section D 
//
// ---------------------------------------------------------------

import java.io.*;

public class CellListUtilization {

	public static void main(String[] args) {
		// TODO open Cell_Info.txt and read its contents
		// TODO use these records to initialize a CellList (NO duplicates!)
		// TODO show contents
		// TODO search list for user-entered serial numbers
		// TODO test constructors/methods of classes, use special cases
		// TODO Goodbye Message
		
		// Important Attributed
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
		
		
		// Open Cell_Info.txt and read its contents, assigning values to list1
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			boolean cont = true;
			while (cont) {
				String line = BufferedReader.readLine();
				while (!line.isEmpty() && line != null) {	
					long serialNumber = Long.parseLong(line.substring(0, line.indexOf(" ")));
					line = line.substring(line.indexOf(" "));
					String brand = line.substring(0, line.indexOf(" "));
					line = line.substring(line.indexOf(" "));
					double price = Double.parseDouble(line.substring(0, line.indexOf(" ")));
					line = line.substring(line.indexOf(" "));
					int year = Integer.parseInt(line);
					line = "";
					
					CellPhone temp = new CellPhone(serialNumber, brand, price, year);
					list1.addToStart(temp);
				
				}
				cont = false;
			}
			bufferedReader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}

}

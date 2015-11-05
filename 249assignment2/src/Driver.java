// ---------------------------------------------------------------
// Assignment 2 part 1
// 
// Written by: Nina Prentiss	6270611
//
// For COMP249 Section: 	D
//				Tutorial: 	DB
//				Lab: 		DJ-X
//
// Description: Driver.java contains main()
// ---------------------------------------------------------------

import java.util.Scanner;
import java.io.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Declaraions
		Scanner userInput = new Scanner(System.in);
		File newFile;
		PrintWriter newFileWriter = null;
		boolean validFileName = false;
		
		// Welcome Message
		System.out.println("============================================\n\n"
						+ "Welcome to the Library Inventory Program!\n\n"
						+ "============================================\n");
		
		// User Input
		while (!validFileName) {
			System.out.println("Please enter a file name in which to save new modified inventory.");
			newFile = new File(userInput.nextLine());
			if (!newFile.exists()){
				try {
					newFileWriter = new PrintWriter(new FileOutputStream(newFile));
					validFileName = true;
				}
				catch (IOException e) {
					
				}
				finally {
					newFileWriter.close();
					userInput.close();
				}
			}
			else {
				System.out.println("Sorry, a " + newFile.length() + " byte file with the name \"" + newFile.getName() + "\" already exists.");
			}
		}
	}

}

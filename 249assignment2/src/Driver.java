// ---------------------------------------------------------------
// Assignment 2 part 1
// 
// Written by: Nina Prentiss	26270611
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
		
		// Declarations
		Scanner userInput = new Scanner(System.in);
		File newFile;
		File oldFile = new File("Initial_Book_Info.txt");
		BufferedInputStream oldFileReader = null;
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
					validFileName = true;
					oldFileReader = new BufferedInputStream(new FileInputStream(oldFile));
					newFileWriter = new PrintWriter(new FileOutputStream(newFile));
					fixInventory(oldFileReader, newFileWriter);
					displayFileContents(oldFile);
					displayFileContents(newFile);
				}
				catch (IOException e) {
					System.out.println(e.getMessage());
				}
				finally {
					newFileWriter.close();
					userInput.close();
					System.out.println("============================================\n\n"
						+ "Thank you for using the Library Inventory Program!\n\n"
						+ "============================================\n");
				}
			}
			else {
				System.out.println("An error occured. A " + newFile.length() + " byte file with the name \"" + newFile.getName() + "\" already exists.");
			}
		}
	}

}

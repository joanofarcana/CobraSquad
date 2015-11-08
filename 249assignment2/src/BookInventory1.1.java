// ---------------------------------------------------------------
// Assignment 2
// Question: 1
// Written by:	Nina Prentiss		26270611
//				Kyla Lea			21280090
//				Arielle Evans		27380267
//				Himmet Arican		27533934
//
// For COMP249 Section: (Substitute your section letter(s))
// ---------------------------------------------------------------
/*
 * Stuff to be fixed:
 * 
 * 	
 * 	
 * 	fileInventory accepts file stream names and not strings...???????? sorry i am sleep
 */
package assignment2;

import java.util.Scanner;
import java.io.*;


public class BookInventory1 {
	
/* 
 * 
 * +++++++Beginning of BookInventory1 Class Methods+++++++
 * 
 * 
 */
	private static final String inname = "Initial_Book_Info.txt";
	private static String outname = null;
	
					// 1
					// countBooks Method
	
	public static int countBooks(String filename) {
		int numOfLines = 0;
		try {
		    File file = new File(filename);
			Scanner count = new Scanner(file);
		    System.out.println("hi");
			while (count.hasNextLong()){
				numOfLines++;
			    count.nextLine();
			}
			count.close();
			System.out.println(""+numOfLines);
		} catch (Exception e) {
		    e.printStackTrace();
			return 0;
		}
		return numOfLines;
	}
	
					// 2
					// Check Duplicate ISBN Method

		public static boolean checkDuplicate(Book[] array, long isbn, int index) {
		for (int i = 0; i < index; i++) 
		{
			if ((array[i].getISBN() == isbn)&&(i!=index)) 
			{
				return true;
			}
		}
			return false;
		}

					// 3
					// bkArr
	
	public static Book[] bkArr = new Book[countBooks(inname)];
	
	
					// 4
					// fixInventory Method
	
	public static void fixInventory(String inname, String outname) throws Exception {
			
			// 4.1
			// Records counter + SysPrint
		
		Scanner input = new Scanner(System. in );
		int records = countBooks(inname);
		
				if (records <= 1) 
					{
					System.out.println("No correction needed");
					System.exit(0);
					} 
				else 
					{
					System.out.println("Processing number of records...");
					
					}
		
				// 4.2 
				// Creating Book Array
				
				long _ISBN;
				int _issueYear;
				String _title;
				String _author;
				double _price;
				int _numberOfPages; // sorry i know it took a lot to copy and paste temp but i went crazy trying to fix a bug that wasn't there lol
		
		    File file1 = new File(inname);
		    Scanner scan = new Scanner(file1);
		    
			System.out.println("Creating database of "+records+" records..."); 
			
				for (int i = 0; i < records; i++) 
				{
				    
		            if(scan.hasNextLong())
		            	{
					    	_ISBN = Long.parseLong(scan.next(), 10);
					    	_title = scan.next();
					    	_issueYear = Integer.parseInt(scan.next());
					    	_author = scan.next();
					    	_price = Double.parseDouble(scan.next());
					    	_numberOfPages = Integer.parseInt(scan.next());
						    
						    System.out.println(""+_ISBN); // ~~
						    
						    bkArr[i] = new Book(_ISBN, _title, _issueYear, _author, _price, _numberOfPages);
						}
				}

			for (int j = 0; j < records; j++) 
				{
				
				long isbn = bkArr[j].getISBN();
				
				for (int k = j + 1; k < records; k++) 
					{
					
						if (bkArr[k].getISBN() == isbn) 
						{
							do {
						    System.out.println("ISBN error found. Please enter a new isbn for "+bkArr[k].getTitle()+" "+bkArr[k].getISBN()+": ");
							bkArr[k].setISBN(input.nextLong());
							
							} while (checkDuplicate(bkArr, bkArr[k].getISBN(), k));
						}
					}
				}
			
			}
	
					// 5
					// displayFileContents method

	public static void displayFileContents(File file)
	{
		System.out.println("/n/n Now displaying contents of: /n/n");
		try {
			Scanner contentScanner = new Scanner(file);
			
			while(contentScanner.hasNextLong())
				{
					System.out.println(contentScanner.nextLine());
				}
			
			contentScanner.close();
			
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			}
	}


	/* 
	 * 
	 * =================== MAIN PROGRAM ======================= 
	 * 
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		// Declarations
				Scanner userInput = new Scanner(System.in);
				File newFile;
				File oldFile = new File(inname);
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
							fixInventory(oldFileReader, newFileWriter); // is fileInventory accepting two stream titles or two string titles?
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
						while(newFile.exists())
						{
							System.out.println("An error occured. A " + newFile.length() + " byte file with the name \"" + newFile.getName() + "\" already exists.");
						}
					}
				}
			}
	
	}
		
		
		/*
		 * 
		 * arielle's main program code
		 * 
		 * 
		String inname = "Initial_Book_Info.txt";
		
		//private static String[] bkArr = new String[10];
		Scanner scan = new Scanner(System. in );
		String filename = scan.next();
		Writer writer = null;
		boolean fileexists = true;
				
						//asking for filename from user, repeats indefinitely
						do {
							try {
								writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
								fileexists = false;
								writer.close();
							} catch (Exception ex) {
								System.out.println("A file with that name already exists");
								try {
									BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf-8"));
									System.out.println("The size of that file is ");
									br.close();
								} catch (Exception ex1) {
									System.out.println("lol");
								}
								filename = scan.next();
							}
						} while (fileexists);
				

        try{
		fixInventory("Initial_Book_Info.txt", filename);
		}catch(Exception qww){
		    System.out.println("Could not fix inventory");
		    qww.printStackTrace();   
		}
*/

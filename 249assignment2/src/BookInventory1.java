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


import java.util.Scanner;
import java.io.*;


public class BookInventory1 {
	
/* 
 * 
 * +++++++Beginning of BookInventory1 Class Methods+++++++
 * 
 * 
 */
	
	
					// 1
					// countBooks Method
	
	public static int countBooks(File in) {
		try {
			Scanner input = new Scanner(in);
			int numOfLines = 0;
			while (input.hasNextLong()){
				numOfLines++;
			    input.nextLine();
			}
			input.close();
			return numOfLines;
		}
		catch (Exception e) {
		    e.printStackTrace();
			return 0;
		}
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

	
	
					// 4
					// fixInventory Method
	
	public static void fixInventory(File in, PrintWriter output) throws Exception {
			
			// 4.1
			// Records counter + SysPrint
		Scanner input = new Scanner(in);
		Scanner userInput = new Scanner(System.in);
		int records = countBooks(in);
		
			if (records <= 1) {
				System.out.println("No records detected");
				System.exit(0);
				} 
			else {
				System.out.println("Processing number of records...");
				}
	
			// 4.2 
			// Creating Book Array
			
			long _ISBN;
			String _title;
			int _issueYear;
			String _author;
			double _price;
			int _numberOfPages; 
		
		    
			System.out.println("Creating database of "+records+" records..."); 
			
			for (int i = 0; i < records; i++) 
			{
	            if(input.hasNextLong()) {
			    	_ISBN = Long.parseLong(input.next(), 10);
			    	_title = input.next();
			    	_issueYear = Integer.parseInt(input.next());
			    	_author = input.next();
			    	_price = Double.parseDouble(input.next());
			    	_numberOfPages = Integer.parseInt(input.next());
				    
				    bkArr[i] = new Book(_ISBN, _title, _issueYear, _author, _price, _numberOfPages);
				}
			}

			for (int j = 0; j < records; j++) {
				 
				long isbn = bkArr[j].getISBN();
				
				for (int k = j + 1; k < records; k++) 
					{
					
						if (bkArr[k].getISBN() == isbn) 
						{
							do {
						    System.out.println("ISBN error found. Please enter a new isbn for "+bkArr[k].getTitle()+" "+bkArr[k].getISBN()+": ");
							bkArr[k].setISBN(userInput.nextLong());
							
							} while (checkDuplicate(bkArr, bkArr[k].getISBN(), k));
						}
					}
				output.println(bkArr[j].getISBN()+" "+bkArr[j].getTitle()+" "+bkArr[j].getIssueYear()+" "+bkArr[j].getAuthor()+" "+bkArr[j].getPrice()+" "+bkArr[j].getNumberOfPages());
				System.out.println(bkArr[j].getISBN()+" "+bkArr[j].getTitle()+" "+bkArr[j].getIssueYear()+" "+bkArr[j].getAuthor()+" "+bkArr[j].getPrice()+" "+bkArr[j].getNumberOfPages());
				}
			
			input.close();
			userInput.close();
			}
	
					// 5
					// displayFileContents method

	public static void displayFileContents(File file) {
		System.out.println("\n\nNow displaying contents of " + file.getName() + ": \n");
		try {
			Scanner contentScanner = new Scanner(file);
			while(contentScanner.hasNextLong()) {
					System.out.println(contentScanner.nextLine());
				}
			
			contentScanner.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			}
	}

	// 3
	// bkArr
	static Book[] bkArr;
	private static final File oldFile = new File("Initial_Book_Info.txt");

	/* 
	 * 
	 * =================== MAIN PROGRAM ======================= 
	 * 
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		// Declarations
		Scanner oldFileReader;
		try {
			oldFileReader = new Scanner(oldFile);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		bkArr = new Book[countBooks(oldFile)];
		
		File newFile;
		Scanner userInput = new Scanner(System.in);
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
						newFileWriter = new PrintWriter(new FileOutputStream(newFile));
						fixInventory(oldFile, newFileWriter); // fixInventory should accept two streams
						displayFileContents(oldFile);
						displayFileContents(newFile);
					}
					catch (IOException e) {
						System.out.println(e.getMessage());
					}
					catch (Exception e) {
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

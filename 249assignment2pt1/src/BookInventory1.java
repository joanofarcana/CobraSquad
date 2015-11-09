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



import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;


public class BookInventory1 {
	
/* 
 * 
 * +++++++BookInventory1 Class Methods+++++++
 * 
 * 
 */
	
					// 1
					// countBooks Method
					// by Arielle Evans
	
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
			System.out.print("countBooks() ");
			e.printStackTrace();
			return 0;
		}
	}
	
					// 2
					// Check Duplicate ISBN Method
					// by Arielle Evans

	public static boolean checkDuplicate(Book[] array, long isbn, int index) {
		for (int i = 0; i < index; i++) {
			if ((array[i].getISBN() == isbn)&&(i!=index)) {
				return true;
			}
		}
		return false;
	}

	
	
					// 4
					// fixInventory Method
					// by Arielle Evans
	
	public static void fixInventory(Scanner input, PrintWriter output) throws Exception {
			
			// 4.1
			// Records counter + SysPrint
		Scanner userInput = new Scanner(System.in);
		int records = bkArr.length;
		
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
			
		for (int i = 0; i < records; i++) {
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
			for (int k = j + 1; k < records; k++) {
				if (bkArr[k].getISBN() == isbn) {
					do {
						try
						{
						    System.out.println("ISBN error found. Please enter a new isbn for "+bkArr[k].getTitle()+" "+bkArr[k].getISBN()+": ");
							bkArr[k].setISBN(userInput.nextLong());
							System.out.println();
						}
						catch (InputMismatchException e){
							
							userInput.nextLine();
							System.out.println("I'm sorry, but that isn't a valid ISBN. \nPlease re-enter an appropriate ISBN.\n");
						}
					
					} while (checkDuplicate(bkArr, bkArr[k].getISBN(), k));
				}
			}
			output.println(bkArr[j].getISBN()+" "+bkArr[j].getTitle()+" "+bkArr[j].getIssueYear()+" "+bkArr[j].getAuthor()+" "+bkArr[j].getPrice()+" "+bkArr[j].getNumberOfPages());
		}
		input.close();
		output.close();
		userInput.close();
	}
	
					// 5
					// displayFileContents method
					// by Kyla Lea

	public static void displayFileContents(Scanner stream) {
		while(stream.hasNextLong()) {
				System.out.println(stream.nextLine());
		}
		stream.close();
	}
	
				// 3
				// static bkArr Declaration
				// by Arielle Evans
	
	static Book[] bkArr;
	private static final File oldFile = new File("Initial_Book_Info.txt");

	/* 
	 * 
	 * =================== MAIN PROGRAM ======================= 
	 * 
	 *   compiled courtesy of : Eclipse and Nina Prentiss (:3)
	 *    
	 */
	
	
	public static void main(String[] args) {
		
		// Declarations
		bkArr = new Book[countBooks(oldFile)];
		
		File newFile = null;
		Scanner userInput = new Scanner(System.in);
		PrintWriter newFileWriter = null;
		Scanner oldFileReader = null;
		boolean validFileName = false;
		Scanner oldFileDisplay = null;
		Scanner newFileDisplay = null;
				
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
						oldFileReader = new Scanner(oldFile);
						fixInventory(oldFileReader, newFileWriter);
						System.out.println("\n\nNow displaying contents of " + oldFile.getName() + ": \n");
						oldFileDisplay = new Scanner(oldFile);
						displayFileContents(oldFileDisplay);
						System.out.println("\n\nNow displaying contents of " + newFile.getName() + ": \n");
						newFileDisplay = new Scanner(newFile);
						displayFileContents(newFileDisplay);
					}
					catch (IOException e) {
						System.out.println("IOException in the main.");
						System.out.println(e.getMessage());
					}
					catch (Exception e) {
						System.out.println("Other Exception in the main.");
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
					finally {
						newFileWriter.close();
						userInput.close();
						System.out.println("\n============================================\n\n"
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

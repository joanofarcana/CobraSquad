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


public class BookInventory2 {

	/* 
	 * 
	 * +++++++BookInventory2 Class Methods+++++++
	 * 
	 * 
	 */
	 
	
						// 1
						// addRecords Method
						// by Kyla Lea
						
		public static void addRecords(OutputStream outputStreamName) {			 // ?????? why is this invalid /confused
			Scanner kb = new Scanner(System.in);								// It shouldn't be.... o_o;
			boolean yesAddNew = true;
			DataOutputStream dataOut;
			
			System.out.println("Please enter new records you wish to append to the file: ");
				do {
					try {
						dataOut = new DataOutputStream(new FileOutputStream("newFile.dat"));
						dataOut.writeUTF(kb.nextLine()); // however one appends records to file
							System.out.println("Your record has been successfully appended!\n\nDo you wish to add a new record?");
						yesAddNew = kb.nextBoolean(); // determine how the user will input the boolean 
						}
					catch (FileNotFoundException e) {
						e.printStackTrace();; // exception message
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				} while(yesAddNew);
			
			if (!yesAddNew)
			{
				System.out.println("You've decided //not// to continue adding records to the file.\n\n " +
						"addRecords program segment has ended.");
			}
			kb.close(); 
		}

				// 2
				// displayFileContents()
				// by Kyla Lea
	public static void displayFileContents(BufferedReader input) throws IOException {
		
			while(input.readLine() != null) {
					System.out.println(input.readLine());
			}
			input.close();
		}

				// 3
				// binaryBookSearch()
				// by Nina Prentiss
	public void binaryBookSearch(Book[] arr, int start, int end, long isbn) {
		int count = 0;
		boolean isbnFound = false;
		if (start >= 0 && start <= end && end < arr.length && arr != null) {
			while (start <= end && !isbnFound) {
				int mid = start + (end - start)/2;
				count++;
				if (arr[mid].getISBN() < isbn) {
					start = mid + 1; 
				}
				else if (arr[mid].getISBN() > isbn) {
					end = mid - 1;
				}
				else {
					System.out.println("Took " + count + " iteration(s) to find book with ISBN #" + isbn + ".");
					System.out.println(arr[mid].toString());
					isbnFound = true;
				}
				
			}
		}
		if (isbnFound == false) {
			System.out.println("ISBN #" + isbn + " not found in " + count + " iterations.");
		}
	}

				// 4
				// sequentialBookSearch()
				// by Himmet Arican
    	public void SequentialSearch (Book[] b, int start, int end, int isbn) 
    {   
        int iterations = 0;
        boolean wrongIndex = false;
        boolean notFound = true;
        
        if (end>b.length)
        {
            System.out.println("The end index is too big!");
            wrongIndex = true;
        }
            else 
            {   
                while(notFound)
                for (int i=start ; i<end; i++) 
                {   
                    iterations++;
                    if (b[i].getISBN() == isbn)
                    {
                        notFound = false;
                    }
                }
            }
        
        if (notFound == false && wrongIndex == false)
        {
            System.out.println("It took " + iterations + " iteration(s) to find the book with ISBN #"+isbn);

        }
            else if(notFound == true && wrongIndex == false)
            {
                System.out.println("ISBN #" + isbn + " not found in " + iterations + " iterations.");
            }
        
    }

	static Book[] bkArr;
	private static final File oldFile = new File("Initial_Book_Info.txt");

	/* 
	 * 
	 * =================== MAIN PROGRAM ======================= 
	 * 
	 * 
	 */


	public static void main(String[] args) {

		/**
		// Declarations
		bkArr = new Book[countBooks(oldFile)];

		File newFile = null;
		Scanner userInput = new Scanner(System.in);
		PrintWriter newFileWriter = null;
		Scanner oldFileReader = null;
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
						oldFileReader = new Scanner(oldFile);
						System.out.println(oldFileReader.toString());
						fixInventory(oldFileReader, newFileWriter); // fixInventory should accept two streams
						displayFileContents(oldFile);
						displayFileContents(newFile);
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
					System.out.println("An error occurred. A " + newFile.length() + " byte file with the name \"" + newFile.getName() + "\" already exists.");
				}
			}
		 **/
	}
}

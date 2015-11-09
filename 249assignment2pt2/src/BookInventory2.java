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

		
		// Declarations
		
		Scanner userInput = new Scanner(System.in);
		Scanner oldFileReader = null;
		// PrintWriter oldFileWriter = null;
		DataOutputStream os = null;
		long _ISBN, ISBN;
		String _title;
		int _issueYear;
		String _author;
		double _price;
		int _numberOfPages; 
		
		// boolean validFileName = false;
		int records = countBooks(oldFile);

			// Welcome Message
			System.out.println("============================================\n\n"
							+ "Welcome to the Library Inventory Program!\n\n"
							+ "============================================\n");
		
		
		//addRecords(oldFile);
		displayFileContents(oldFileReader);
		bkArr = new Book[records];
		
		try {
	       	os = new DataOutputStream(new FileOutputStream("Books.dat"));
			oldFileReader = new Scanner(oldFile);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			for (int i = 0; i < records; i++) {
	            if(oldFileReader.hasNextLong()) {
			    	_ISBN = Long.parseLong(oldFileReader.next(), 10);
			    	_title = oldFileReader.next();
			    	_issueYear = Integer.parseInt(oldFileReader.next());
			    	_author = oldFileReader.next();
			    	_price = Double.parseDouble(oldFileReader.next());
			    	_numberOfPages = Integer.parseInt(oldFileReader.next());
				    
				    bkArr[i] = new Book(_ISBN, _title, _issueYear, _author, _price, _numberOfPages);
				}
			}
		}
		catch(Exception e){
		    System.out.println("Could not read records from file.");
		}
		
		System.out.println("Please enter the ISBN you want to find. ");
		ISBN = userInput.nextLong();
		
		binaryBookSearch (bkArr, 0, records, ISBN);
		sequentialBookSearch (bkArr, 0, records, ISBN);

        try {
            for(int j = 0; j< records; j++){
                os.writeChars(bkArr[j].getISBN()+" "+bkArr[j].getTitle()+" "+bkArr[j].getIssueYear()+" "+bkArr[j].getAuthor()+" "+bkArr[j].getPrice()+" "+bkArr[j].getNumberOfPages()+"\n");
            }
        }
        catch(Exception e2) {
            System.out.println("Could not output binary data");
        }
        finally {
            // Make sure to close the file when done
        	userInput.close();
        }
        
    
		System.out.println("\n============================================\n\n"
							+ "Thank you for using the Library Inventory Program!\n\n"
							+ "============================================\n");
	}
}

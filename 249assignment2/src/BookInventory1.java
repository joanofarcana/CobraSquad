// ---------------------------------------------------------------
// Assignment 2
// Question: 1
// Written by:	Nina Prentiss		26270611
//				Kyla Lea			21280090
//				Arielle Evans		27380267
//				Himmet Arican		27533934
// For COMP249 Section: (Substitute your section letter(s))
// ---------------------------------------------------------------
package src;

import java.util.Scanner;
import java.io.*;



public class BookInventory1 {

	public static Book[] bkArr = new Book[countBooks("Initial_Book_Info.txt")];

	public static void main(String[] args) {
		//private static String[] bkArr = new String[10];
		Scanner scan = new Scanner(System. in );
		System.out.print("Please enter a name for a new text file ");
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
					File f = new File(filename);
					//need to fix this. supposed to show the size of the already-existing file
					System.out.println("The size of that file is " + f.length());
				} catch (Exception ex1) {
					//this really shouldn't happen...
				}
				System.out.print("Please enter a name for a new text file ");
				filename = scan.next();
			}
		} while (fileexists);
		try {
			fixInventory("Initial_Book_Info.txt", filename);
		} catch (Exception ex5) {
			System.out.println("Could not fix inventory");
			ex5.printStackTrace();
		}
	}

	public static int countBooks(String filename) {
		int lines = 0;
		try {
			File file = new File(filename);
			Scanner temp = new Scanner(file);
			while (temp.hasNextLine()) {
				lines++;
				temp.nextLine();
			}
			temp.close();
		} catch (Exception e) {
			return 0;
		}
		return lines-1;
	}

	public static boolean checkDuplicate(Book[] array, long isbn, int index) {
		for (int i = 0; i < array.length; i++) {
			if ((array[i].getISBN() == isbn) && (i != index)) {
				return true;
			}
		}
		return false;
	}



	public static void fixInventory(String inname, String outname) throws Exception {

		Scanner input = new Scanner(System. in );
		//number of books in the file
		int records = countBooks(inname);
		if (records == 0) {
			System.out.println("No records detected");
			System.exit(0);
		}
		//making array
		long tempisbn;
		int tempyear;
		String temptitle;
		String tempauthor;
		double tempprice;
		int tempnum;

		//file with books in it
		File file1 = new File(inname);
		Scanner scan = new Scanner(file1);

		//creating objects in bkArr
		for (int i = 0; i < records; i++) {
			if (scan.hasNextLine()) {
			    System.out.println(""+records);
				tempisbn = Long.parseLong(scan.next(), 10);
				temptitle = scan.next();
				tempyear = Integer.parseInt(scan.next());
				tempauthor = scan.next();
				tempprice = Double.parseDouble(scan.next());
				tempnum = Integer.parseInt(scan.next());
				bkArr[i] = new Book(tempisbn, tempyear, temptitle, tempauthor, tempprice, tempnum);
			}
		}

		//checking for duplicate isbns
		for (int j = 0; j < records; j++) {
			long isbn = bkArr[j].getISBN();
			for (int k = j + 1; k < records; k++) {
				if (bkArr[k].getISBN() == isbn) {
					do {
						System.out.println("ISBN error found. Please enter a new isbn for " + bkArr[k].getTitle() + " " + bkArr[k].getISBN() + ": ");
						bkArr[k].setISBN(input.nextLong());
					} while (checkDuplicate(bkArr, bkArr[k].getISBN(), k));
				}
			}
		}
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outname), "utf-8"));
		for (int i = 0; i < records; i++) {
			writer.write("" + bkArr[i].getISBN() + " " + bkArr[i].getIssueYear() + 
			            " " + bkArr[i].getTitle() + " " + bkArr[i].getAuthor() + 
			            " " + bkArr[i].getPrice() + " " + bkArr[i].getPages() + "\n");
		}
		writer.close();
	}

	public static void displayFileContents(String inname) {

	}
}

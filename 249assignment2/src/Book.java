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

package assignment2;

public class Book {

	// PRIVATE ATTRIBUTES
	
	private long ISBN;
	
	private String title;	// title and author names are parsed with _ underscores
	private String author;
	
	private int issueYear;
	private int numberOfPages;
	private double price;
	
	
	// DEFAULT CONSTRUCTOR
	
	public Book()
	{
		price = 0;	
		ISBN = 100000000;
		numberOfPages = 0;
		issueYear = 1900;
		author = "unknown";
		title = "untitled";
	}
	
	
	// PARAMETERIZED CONSTRUCTOR
	
	public Book(long ISBN, String title, int issueYear, String author, double price, int numberOfPages) {
		
		this.price = price;
		this.ISBN = ISBN;
		this.numberOfPages = numberOfPages;
		this.author = author;
		this.title = title;
		this.issueYear = issueYear;
		
	}
	
	
	// COPY CONSTRUCTOR
	
	public Book(Book b) {
		
		price = b.price;
		ISBN = b.ISBN;
		numberOfPages = b.numberOfPages;
		issueYear = b.issueYear;
		author = b.author;
		title = b.title;
		
	}
	
	
	// TO STRING METHOD
	
	public String toString()
	{
		return ("This book is called " + this.getTitle() + ", by " + this.getAuthor() + ". It is priced at "+this.getPrice()+"$, " +
				"has " +this.getNumberOfPages() +" pages, was issued in " + this.getIssueYear() +", and has an ISBN of " +this.getISBN()+".");
	}
	
	
	// EQUALS METHOD
	
	public boolean equals(Book b)
	{
		if (b != null 
				&& getPrice() == b.getPrice() 
				&& getIssueYear()== b.getIssueYear() 
				&& getNumberOfPages() == b.getNumberOfPages()
				&& getAuthor() == b.getAuthor() 
				&& getTitle() == b.getTitle()
				&& getISBN() == b.getISBN())
			return true;	
		else
			return false;
		}


	// GETTER DONE METHODS
	

	public double getPrice()
	{
		return price;
	}
	
	public int getIssueYear()
	{
		return issueYear;
	}
	
	public int getNumberOfPages()
	{
		return numberOfPages;
	}
	
	public long getISBN()
	{
		return ISBN;
	}
	
	public String getTitle()	
	{
		return title;
	}
	
	public String getAuthor()	
	{
		return author;
	}
	
	
	// SETTER METHODS
	
	public void setAuthor(String author)	
		{
			this.author = author;
		}
	
	public void setTitle(String title)
		{
			this.title = title;
		}

	public void setISBN(long ISBN)
		{
			this.ISBN = ISBN;
		}
	
	public void setNumberOfPages(int numberOfPages)
		{
			if (numberOfPages >0)
			this.numberOfPages = numberOfPages;
		}

	public void setPrice(double price)
		{
			if (price > 0)
			this.price = price;
		}
	
	public void setIssueYear(int issueYear)
		{
			this.issueYear = issueYear;
		}
}

// ---------------------------------------------------------------
// Assignment 3 part 1

// Written by:	Kyla Lea			21280090
//				Himmet Arican		27533934
//				Nina Prentiss		26270611

// For COMP249/2 Section D 
// ---------------------------------------------------------------
import java.util.Scanner;

// to do:
// implements cloneable? cloneable 2? 
// conditional for setBrand() : what is appropriate? [one word brands]
// fix equals method [duplicate serial number issue]
// for setSerialNum() and clone() methods : are the conditionals for checking serial number duplicity valid?

public class CellPhone 
{
	private String brand;
	private int year;
	private double price;
	private long serialNum;
	
	// Default Constructor
	public CellPhone()
	{
		serialNum = 0000000;
		year = 2009;
		price = 0.00;
		brand = null;		
	}
	
	// Parameterized Constructor
	public CellPhone(long serialNum, String brand, int year, double price)
	{
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	// Copy Constructor
	public CellPhone(CellPhone c, long serialNum)
	{
		setBrand(c.brand);
		setYear(c.year);
		setPrice(c.price);
		setSerialNum(serialNum);
	}
	
	// clone method
	public CellPhone clone() {
		Scanner kb = new Scanner(System.in);
		CellPhone phone = new CellPhone();
		System.out.print("Please enter a new serial number for this cell phone: ");
		long userSerial = kb.nextLong();
		phone.setSerialNum(userSerial);
		phone.setBrand(this.getBrand());
		phone.setYear(this.getYear());
		phone.setPrice(this.getPrice());
		
		kb.close();
		return phone;
	}
	
	// toString Method
	public String toString() {
		return (getSerialNum() + ": " + getBrand() + "; " + getYear() + "; " + getPrice() +"$");
	}
	
	// equals Method
	public boolean equals(CellPhone c) { 
		if (c != null 
				&& (Math.abs(getPrice() - c.getPrice()) < .01) 
				&& getYear() == c.getYear() 
				&& getBrand().equals(c.getBrand()))
			return true;	
		else
			return false;
		}
	
	// Get Methods
	//
	public int getYear(){
		return year;
	}
	
	public String getBrand(){
		return brand;
	}
	
	public double getPrice(){
		return price;
	}
	
	public long getSerialNum(){
		return serialNum;
	}
	
	// Set Methods
	//
	public void setPrice(double price)
	{	
	//	if (price>0)
			this.price = price;
	}
	
	public void setBrand(String brand)
	{
	//	if (true) 						// appropriate way of distinguishing brands
			this.brand = brand;
	}
	
	public void setYear(int year)
	{
	//	if (year >= 1985 || year <= 2020) 
			this.year = year;
	}
	
	public void setSerialNum(long serialNum)
	{ 
	//	if (serialNum != serialNumCount) 		// fix iterable serialNum
			this.serialNum = serialNum;			// is setSerialNum() even required?
	}
		
}

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
	public CellPhone clone(CellPhone c) {
		Scanner kb = new Scanner(System.in);
		CellPhone phone = new CellPhone();
		System.out.println("Please enter a new serial number for this CellPhone: ");
		long userSerial = kb.nextLong();
		phone.setSerialNum(userSerial);
		phone.setBrand(c.getBrand());
		phone.setYear(c.getYear());
		phone.setPrice(c.getPrice());
		
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
				&& getPrice() == c.getPrice() 
				&& getYear() == c.getYear() 
				&& getBrand() == c.getBrand())
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

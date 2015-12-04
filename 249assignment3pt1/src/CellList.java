package assignment3;

// to do:
// NoSuchElementException -> where to put the program termination
// NullPointerException
// exception stuff in general
// equals() method
// clone() method ("deep clone")? -> cellNode clone
// insertAtIndex() method (tbcompleted)
// deleteFromIndex() method (tbcompleted)

public class CellList implements Cloneable { // probably will have to implement cloneable2 
	
				// NoSuchElementException class
		public class NoSuchElementException extends Exception
			{
					// Default Constructor
				public NoSuchElementException() 
				{
					super("That index does not exist. Program Terminates.");	// should we put the system.exit(0) here????					
				}
				
					// Input Alternative Exception Message Constructor
				public NoSuchElementException(String s) 
				{
					super(s);
				}
				
					// getMessage() method
				public String getMessage(String s) 
				{
					return super.getMessage();
				}
			}
		
			// Inner CellNode class 
		private class CellNode {
			
			// Private Attributes
			private CellPhone c;
			private CellNode next;
			
			// Default Constructor
			private CellNode()
			{
				c = null;
				next = null;
			}
			
			// Parameterized Constructor
			private CellNode(CellPhone c, CellNode next)
			{
				this.c = c;
				this.next = next;
				
				System.out.println("Initializing CellNode...");
			}
			
			// Copy Constructor
			private CellNode(CellNode node)
			{
				c = node.c;
				next = node.next;
			}
			
                        //Deep copy			
                        public Object clone() {
                        CellNode cn = new CellNode(c ,next.getCellNode());
                        return cn;
                        }			
			// Set Methods
			//
			public void setCellPhone() {
				this.c = c;
			}
			
			public void setCellNode() {
				this.next = next;
			}
			
			// Get Methods
			//
			public CellPhone getCellPhone() {
				return c;
			}
			
			public CellNode getCellNode() {
				return next;
			}
		}
	
		// ... returning to the CellList class...
		//Private Attributes
	private CellNode head;
	private int size;
	
		// Default Constructor
	public CellList() {
		head = null;
		size = 0;
	}
	
		// Copy Constructor
	public CellList(CellList cl) {
			this.head = head;
			this.size = size;
		}
	
		// determines the size of the list
	public int size() {
		CellNode temp = head;
		while (temp != null){
			size++;
			temp = temp.next;
		}
		return size;
	}
		
		// addToStart() method
	public CellNode addToStart(CellPhone c) {
		CellNode node = new CellNode(c, head);
		return node; 
	}
	
		// insertAtIndex() method
	public CellNode insertAtIndex(CellPhone c, int index) { 

		try{
			if (index <0 || index > size()-1)
				throw new NoSuchElementException();
		}
		catch (NoSuchElementException ne)
		{
			String s = ne.getMessage();
			System.out.println(s);
			System.exit(0); 		// should it be here or in the actual exception constructor
		}
		// if valid, creates and inserts node at index chosen by user
		System.out.println("Valid index chosen. Node is currently being created and inserted at desired index .");
		CellNode node = new CellNode(); // new CellNode is created with CellPhone c and Pointer
		return node;
	}
	
		// deleteFromIndex() method
	public void deleteFromIndex(int index) {
		
		try{
			if (index <0 || index > size-1)
				throw new NoSuchElementException();
		}
		catch (NoSuchElementException ne)
		{
			String s = ne.getMessage();
			System.out.println(s);
			System.exit(0);
		}
		// if valid, deletes node at index chosen by user; ties together broken list
	}

		// deleteFromStart() method
	public boolean deleteFromStart() {
		if (head != null) {
			head = head.getCellNode();
			return true;
		}
		else
			return false;
	}
	
		// contains() method
	public boolean contains(long serialNum) 
	{
		if (find(serialNum) != null)
		{
			return true;
		}
		else
			return false;
	}
	
		// find() method
	public CellNode find(long serialNum) 
	{
		CellNode temp = head;
		while (temp != null)
		{
			if (temp.c.getSerialNum() == serialNum)
			{
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
	
		// showContents() method
	public void showContents() 
	{
		CellNode temp = head;
		if (temp == null)
		{
			System.out.println("There is nothing to display.");
		}
		else 
		{
			System.out.println("Contents of the list: ");
		}
		while (temp!=null)
		{
			System.out.println("[" + temp.getCellPhone() + "] --> "); // how does this display the cellphone object
		}
		
	}
	
	
		// equals() method
	public boolean equals(CellList cl)
	{
		if (cl != null 
				&& getCellPhone() == cn.getCellPhone()) /////???????????????????
			return true;	
		else
			return false;
		}
	}



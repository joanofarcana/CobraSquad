// TODO
// NullPointerException
// exception stuff in general
// clone() method ("deep clone")? -> cellNode clone
// deleteFromStart() --> size stuff
// deleteFromIndex() tbcompleted

public class CellList implements Cloneable2 extends Cloneable { // probably will have to implement cloneable2 
	
				// NoSuchElementException class
		public class NoSuchElementException extends Exception
			{
					// Default Constructor
				public NoSuchElementException() 
				{
					super("That index does not exist. Program Terminates.");				
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
		class CellNode {
			
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
	public void addToStart(CellPhone c) {
		CellNode node = new CellNode(c, head);
		head = node;
		size++;
	}
	
		// insertAtIndex() method
	public void insertAtIndex(CellPhone c, int index) { 

		try{
			if (index <0 || index > size()-1)
				throw new NoSuchElementException();
		}
		catch (NoSuchElementException ne)
		{
			String s = ne.getMessage();
			System.out.println(s);
			System.exit(0); 
		}
		// if valid, creates and inserts node at index chosen by user
		System.out.println("Valid index chosen. Node is currently being created with CellPhone" + c + "and inserted at index " + index + ".");
		
		CellNode temp = head;
		int i = 0;
		if (index == 0)
		{
			CellNode node = new CellNode(c, head);
			head = node;
			node = null;
		}
		else
		{
			while (i != index-1)
			{
				temp = temp.next;
				i++;
			}
			CellNode node = new CellNode(c, temp.next);
			temp.next = node;
			node = null; //why
		}
		size++;
	}
	
	// replaceAtIndex() method
		public void replaceAtIndex(CellPhone c, int index)
		{
			if (index <0 || index > size-1)
			{
				return;
			}
			else
			{
				if (index == 0)
				{
					CellNode node = new CellNode(c, head);
					head = node;
					node = null;
				}
				int i = 0;
				CellNode temp = head;
				while(i != index)
				{
					temp = temp.next;
					i++;
				}
				System.out.println("Valid index chosen. Now replacing CellPhone " + temp.c + " at index " + index + " to " + c + ".");
				temp.c = c;	
			}
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
		
		int i = 0;
		CellNode temp = head;
		
		if (index == 0)
		{
			head = head.next;
		}
		else {
			while(i != index-1)
			{
				temp = temp.next; 
				i++;
			}
			temp = temp.next.next;
		}
		size--; /// kind of confused ok goodnight
	}

	// deleteFromStart() method
	public boolean deleteFromStart() {
		if (head != null) {
			head = head.next;
			size--; // would this actually decrease the size
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
			System.out.println("[" + temp.getCellPhone() + "] --> "); 
			temp = temp.next;
		}
		
	}
	
	
	// equals() method
	public boolean equals(CellList cl)
	{
		CellNode temp = head;
		CellNode temp2 = cl.head;
		while (temp!=null)
		{
			if (temp.c != temp2.c)
			{
				return false;
			}
			else
			{
				temp = temp.next;
				temp2 = temp.next;
			}
		}
		return true;
		temp = null; temp2 = null;
	}
}


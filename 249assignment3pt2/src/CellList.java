// ---------------------------------------------------------------
// Assignment 3 part 1

// Written by:	Kyla Lea			21280090
//				Himmet Arican		27533934
//				Nina Prentiss		26270611

// For COMP249/2 Section D 
// ---------------------------------------------------------------
import java.util.*;

// TODO
// NullPointerException
// exception stuff in general

public class CellList implements Cloneable { 
	
		// Inner CellNode class 
		class CellNode {
			
			// Private Attributes
			private CellPhone c;
			private CellNode next;
			
			// Default Constructor
			public CellNode() {
				c = null;
				next = null;
			}
			
			// Parameterized Constructor
			public CellNode(CellPhone c, CellNode next) {
				this.c = c;
				this.next = next;
			}
			
			// Copy Constructor
			public CellNode(CellNode node) {
				c = node.getCellPhone();
				next = node.getNext();
			}
			
            //Deep copy			
            public Object clone() {
	            CellNode cn = new CellNode(this.getCellPhone(), this.getNext());
	            return cn;
            }
                        
			// Set Methods
			//
			public void setCellPhone(CellPhone c) {
				this.c = c;
			}
			
			public void setNext(CellNode next) {
				this.next = next;
			}
			
			// Get Methods
			//
			public CellPhone getCellPhone() {
				return c;
			}
			
			public CellNode getNext() {
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
		CellNode pos = cl.head.getNext();
		head = new CellNode(cl.head);
		CellNode newPos = head;
		while (pos != null) {
			CellNode temp = new CellNode(pos);
			newPos.setNext(temp);
			newPos = temp;
			pos = pos.getNext();
		}
		newPos.setNext(null);
		this.size = cl.size;
	}

	
	// getSize() accessor
	public int getSize() {
		return this.size;
	}
	
	// addToStart() method
	public void addToStart(CellPhone c) {
		CellNode node = new CellNode(c, head);
		head = node;
		size++;
	}
	
	// insertAtIndex() method
	public void insertAtIndex(CellPhone c, int index) { 

		if (index < 0 || index > size - 1)
			throw new NoSuchElementException();		
		
		CellNode pos = head;
		if (index == 0) {
			addToStart(c);
		}
		while (index > 1) {
			pos = pos.getNext();
			index--;
		}
		
		CellNode node = new CellNode(c, pos.next);
		pos.next = node;
		size++;
	}
	
	// replaceAtIndex() method
	public void replaceAtIndex(CellPhone c, int index)
	{
		if (index < 0 || index > size - 1)
			throw new NoSuchElementException();		
		
		CellNode pos = head;
		while (index > 0) {
			pos = pos.getNext();
			index--;
		}
		
		pos.setCellPhone(c);
	}

	// deleteFromIndex() method
	public void deleteFromIndex(int index) {
		
		if (index <0 || index > size - 1)
			throw new NoSuchElementException();
		
		CellNode pos = head;
		if (index == 0) {
			pos = pos.getNext();
			return;
		}
		
		while(index > 1) {
			pos = pos.getNext(); 
			index--;
		}
		pos.setNext(pos.getNext().getNext());
		size--;
	}

	// deleteFromStart() method
	public void deleteFromStart() {
		if (head != null) {
			head = head.next;
			size--;
		}
	}
	
		// contains() method
	public boolean contains(long serialNum) {
		return (find(serialNum) != null);
	}
	
		// find() method
	public CellNode find(long serialNum) {
		int count = 1;
		CellNode temp = head;
		while (temp != null) {
			if (temp.getCellPhone().getSerialNum() == serialNum) {
				System.out.println("Took " + count + " iterations.");
				return temp;
			}
			temp = temp.getNext();
			count++;
		}
		return null;
	}
	
		// showContents() method
	public void showContents() {
		CellNode pos = head;
		if (pos == null) {
			System.out.println("There is nothing to display.");
		}
		else {
			System.out.println("Contents of the list: ");
		}
		while (pos != null) {
			System.out.println("[" + pos.getCellPhone() + "] --> "); 
			pos = pos.getNext();
		}
	}
	
	
	// equals() method
	public boolean equals(CellList cl) {
		return (isSuperset(this, cl) && isSuperset(cl, this));
	}
	
	private boolean isSuperset(CellList list1, CellList list2) {
		CellNode pos = list1.head;
		
		while (pos != null) {	
			CellNode pos2 = list2.head;
			while (!pos.getCellPhone().equals(pos2.getCellPhone())) {
				pos2 = pos2.getNext();
				if (pos2 == null)
					return false;
			}
			pos = pos.getNext();
		}
		return true;
	}
}


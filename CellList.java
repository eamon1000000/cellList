import java.util.NoSuchElementException;

//-----------------------------------------------------
//COMP 249 Assignment 3
//Written by: Eamon Foley 40233231
//Due Date: December 2, 2023
//-----------------------------------------------------
/**
 * The CellList class represents a linked list of CellNode objects, each containing a CellPhone.
 * It provides methods to manipulate the list such as adding, deleting, and replacing elements.
 */
public class CellList {
	
	/**
     * The CellNode class represents a node in the linked list containing a CellPhone.
     * It includes methods to access and manipulate the CellPhone and the next node in the list.
     */
	public class CellNode{
		private CellPhone cellPhone;
		private CellNode next;
		
		/**
         * Constructs an empty CellNode with null CellPhone and next references.
         */
		public CellNode() {
			this.cellPhone = null;
			this.next = null;
		}
		/**
         * Constructs a CellNode with the given CellPhone and next node reference.
         *
         * @param cP The CellPhone to be stored in the node.
         * @param cN The reference to the next node in the linked list.
         */
		public CellNode(CellPhone cP, CellNode cN) {
			this.cellPhone = cP;
			this.next = cN;
		}
		/**
         * Constructs a new CellNode by cloning an existing CellNode.
         *
         * @param node The CellNode to be cloned.
         */
		public CellNode(CellNode node) {
			this.cellPhone = node.cellPhone.clone();
			this.next = node.next;
		}
		/**
         * Retrieves the CellPhone stored in the node.
         *
         * @return The CellPhone stored in the node.
         */
		public CellPhone getCellPhone() {
			return this.cellPhone;
		}
		/**
         * Sets the CellPhone in the node to the specified CellPhone.
         *
         * @param cellPhone The new CellPhone to be set in the node.
         */
		public void setCellPhone(CellPhone cellPhone) {
			this.cellPhone = cellPhone;
		}
		/**
         * Retrieves the reference to the next node in the linked list.
         *
         * @return The reference to the next node.
         */
		public CellNode getNext() {
			return next;
		}
		/**
         * Sets the reference to the next node in the linked list.
         *
         * @param next The new reference to the next node.
         */
		public void setNext(CellNode next) {
			this.next = next;
		}
		/**
         * Creates a cloned CellNode with the same CellPhone and next node reference.
         *
         * @return The cloned CellNode.
         */
		public CellNode clone() {
			CellNode c = new CellNode(this.cellPhone.clone(), this.next);
			return c;
			
		}
		/**
         * Checks if the current CellNode is equal to the specified object.
         *
         * @param x The object to compare for equality.
         * @return True if the objects are equal, false otherwise.
         */
		public boolean equals(Object x) {
			if(x == null || this.getClass() != x.getClass()) {
				return false;
			}
			else {
				CellNode k = (CellNode)x;
				if(this.cellPhone.equals(k.cellPhone) && this.next== null && k.next == null) {
					return true;
				}
				if(this.cellPhone.equals(k.cellPhone) && this.next.equals(k.next)) {
					return true;
				}
				
				return false;
			}
			
		}
	}
	
	private CellNode head;
	private int size = this.getSize();
	/**
	 * Retrieves the head of the linked list.
	 *
	 * @return The head of the linked list.
	 */
	public CellNode getHead() {
		return head;
	}
	/**
	 * Sets the head of the linked list to the specified CellNode.
	 *
	 * @param head The new head of the linked list.
	 */
	public void setHead(CellNode head) {
		this.head = head;
	}
	/**
	 * Calculates and retrieves the current size of the CellList.
	 * Ensures that size is changed when cell nodes are added/deleted from the cell list
	 *
	 * @return The current size of the CellList.
	 */
	public int getSize() {
		int count = 0;
		CellNode t = head;
		while(t != null) {
			count++;
			t = t.next;
			
		}
		size = count;
		return size;
	}	
	/**
	 * Constructs an empty CellList with a null head and a size of 0.
	 */
	public CellList() {
		this.head = null;
		this.size = 0;
	}
	/**
	 * Constructs a new CellList by cloning an existing CellList.
	 *
	 * @param copy The CellList to be cloned.
	 */
	public CellList(CellList copy) {
		if(copy.head == null) {
			this.head = null;
		}
		else {
			this.head = null;
			CellNode t1,t2,t3;
			t1 = copy.head;
			t2 = t3 = null;
			while(t1!=null) {
				if(head == null) {
					t2 = new CellNode(t1.cellPhone.clone(),null);
					this.head = t2;
				}
				else {
					t3 = new CellNode(t1.cellPhone.clone(),null);
					t2.next=t3;
					t2=t3;
				}
				t1 = t1.next;
			}
			t2 = t3 = null;
		}
	}
	/**
	 * Adds a CellPhone to the start of the CellList.
	 * Prints an error message if the CellPhone is already present in the list.
	 *
	 * @param x The CellPhone to be added to the list.
	 */
	public void addToStart(CellPhone x) {
		if(this.contains(x.getSerialNum())) {
			System.out.println("Error Adding CellPhone to list...");

			System.out.println("Duplicate found at index " + this.foundIndex);
			return;
		}
		this.head = new CellNode(x, head);
		System.out.println("Adding CellPhone to list...");

	}
	/**
	 * Deletes the first CellNode from the CellList.
	 * Prints an error message if the list is empty or null.
	 */
	public void deleteFromStart() {
		if(this.head == null) {
			System.out.println("The Cell List is empty, therefore We cannot delete the first element\n");
		}
		else if (this.equals(null)) {
			System.out.println("Cell List is null\n");	
		}
		else {
			this.head = this.head.next;
		}	
	}
	/**
	 * Inserts a CellPhone at the specified index in the CellList.
	 * Throws a NoSuchElementException if the index is out of bounds.
	 * Prints an error message if the CellPhone is already present in the list.
	 *
	 * @param cp    The CellPhone to be inserted.
	 * @param index The index at which the CellPhone should be inserted.
	 * @throws NoSuchElementException If the index is out of bounds.
	 */
	public void insertAtIndex(CellPhone cp, int index) throws NoSuchElementException {
		try {
			
		if(this.contains(cp.getSerialNum())) {
			System.out.println("Error Adding CellPhone to list...");

			System.out.println("Duplicate found at index " + this.foundIndex);
			return;
		}
		if(this.head != null) {
			if(index <= (this.getSize()-1) && index > 0) {
				CellNode t = this.head;
				for (int i = 0; i< (index-2); i++) {
				t = t.next;
				}
			t.next = new CellNode(cp,t.next);
			System.out.println("\nSuccessfully inserted at index " + index);
			
			}
			else {
				System.out.println("Desired Index is Out of bound of the Cell List size");
				throw new NoSuchElementException();
			}
		}
		else {
			System.out.println("Cell List is Empty");
			throw new NoSuchElementException();
		}
		}
		catch (NoSuchElementException e) {
			System.out.println("Program exiting...");
			System.exit(0);
		}
		
	}
	/**
	 * Deletes a CellNode from the CellList at the specified index.
	 * Throws a NoSuchElementException if the index is out of bounds.
	 *
	 * @param index The index from which the CellNode should be deleted.
	 * @throws NoSuchElementException If the index is out of bounds.
	 */
	public void deleteFromIndex(int index) {
		try {
		if(this.head != null) {
			if(index <= (this.getSize()-1) && index > 0) {
				CellNode t = this.head;
				CellNode t2 = this.head.next;
				for (int i = 0; i< (index-1); i++) {
				t = t.next;
				t2 = t2.next;
				}
			t.next = t2.next;
			t2.next = null;
			System.out.println("\nSuccessfully deleted from index " + index);

			
			}
			else {
				System.out.println("Desired Index is Out of bound of the Cell List size");
				throw new NoSuchElementException();
			}
		}
		else {
			System.out.println("Cell List is Empty");
			throw new NoSuchElementException();
		}
		}
		catch (NoSuchElementException e) {
			System.out.println("Program exiting...");
			System.exit(0);
		}
	}
	/**
	 * Replaces the CellPhone at the specified index in the CellList with the given CellPhone.
	 * Prints an error message if the CellPhone is already present in the list.
	 *
	 * @param cp    The new CellPhone to replace the existing one.
	 * @param index The index at which the replacement should occur.
	 */

	public void replaceAtIndex(CellPhone cp, int index) {
		if(this.contains(cp.getSerialNum())) {
			System.out.println("Duplicate found at index " + this.foundIndex +  ", CellPhone not replaced");
			return;
		}
		if(this.head != null) {
			if(index <= (this.getSize()-1) && index > 0) {
				CellNode t = this.head;
				for (int i = 0; i< (index-1); i++) {
				t = t.next;
				}
			t.cellPhone = cp;
			System.out.println("Cellphone replaced at index " + index);
			
			}
			else {
				return;
			}
		}
		else {
			System.out.println("Cell List is Empty");
			return;
		}
	}
	/**
	 * Finds the first occurrence of a CellNode with the given serial number in the CellList.
	 * Updates the foundIndex variable to represent the index of the found CellNode.
	 *
	 * @param sn The serial number to search for.
	 * @return The first CellNode with the specified serial number, or null if not found.
	 * 
	 *PRIVACY LEAK IN METHOD
	 *this Method returns a pointer to a CellNode, which is dangerous because it allows the user access to the  private
	 *attributes of the cellNode Class. in order to fix this, we could make the entire cell node inner class private,
	 *in turn making accessors and mutators to implement the characteristics of the find method
	 * 
	 * 
	 */
	
	
	
	//PRIVACY LEAK IN METHOD
	//this Method returns a pointer to a CellNode, which is dangerous because it allows the user access to the  private
	//attributes of the cellNode Class. in order to fix this, we could make the entire cell node inner class private,
	//in turn making accessors and mutators to implement the characteristics of the find method
	
	int foundIndex = 0;
	public CellNode find(long sn) {
		CellNode t = this.head;
		foundIndex = 0;
		while(t != null) {
			if(t.cellPhone.getSerialNum() == sn) {
				return t;
			}
			t = t.next;
			foundIndex++;
		}
		return null;
	}
	/**
	 * Checks if the CellList contains a CellNode with the specified serial number.
	 *
	 * @param sn The serial number to check for.
	 * @return True if a CellNode with the specified serial number is found, false otherwise.
	 */
	public boolean contains(long sn) {
		CellNode t = this.find(sn);
		if(t!= null) {
			return true;
		}
		return false;
	}
	/**
	 * Displays the contents of the CellList, printing the details of each CellPhone.
	 */
	public void showContents() {
		CellNode t = this.head;
		int count = 0;
		System.out.println("\nThe current size of the list is " + this.getSize() + ". Here are the Contents of the list");
		System.out.println("======================================================================");
		while(t!=null) {
			System.out.print("[" + t.cellPhone.toString() + "] ---> ");
			t = t.next;
			count++;
			if(count == 3) {
				System.out.println("");
				count = 0;
			}
		}
		System.out.println("X\n");
		
	}
	/**
	 * Checks if the current CellList is equal to the specified object.
	 *
	 * @param x The object to compare for equality.
	 * @return True if the objects are equal, false otherwise.
	 */
	public boolean equals(Object x) {
		if(x == null || this.getClass() != x.getClass()) {
			return false;
		}
		else {
			CellList c = (CellList)x;
			if(this.getSize() != c.getSize()) {
				return false;
			}
			boolean check = true;
			CellNode t1 = this.head;
			CellNode t2 = c.head;
			while(t1 != null && t2 != null) {
				if(t1.equals(t2)) {
					t1 = t1.next;
					t2 = t2.next;
				}
				else {
					check = false;
					break;
				}
			}
			return check;
		}
	}
	
	public void addAtEnd(CellNode x) {
		if(this.head == null) {
			this.head = x;
			return;
		}
		else {
			CellNode t = this.head;
			while(t.next!=null) {
				t = t.next;
			}
			t.next = x;
		}
		
	}
	
	public void appendToList(CellList l1) {
		l1.addAtEnd(this.head);
	}
	
	
	
	
	
	
	
	
	
 
	

}

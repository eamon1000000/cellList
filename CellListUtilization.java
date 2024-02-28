import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//-----------------------------------------------------
//COMP 249 Assignment 3
//Written by: Eamon Foley 40233231
//Due Date: December 2, 2023
//-----------------------------------------------------
/**
 * The CellListUtilization class demonstrates the utilization of the CellList class
 * by performing various operations such as reading cell phone information from a file,
 * creating and manipulating CellList instances,adding, deleting and replacing nodes in the lists
 *  and comparing their contents.
 */
public class CellListUtilization {

	public static void main(String[] args) {
		CellList l1 = new CellList();
		CellList l2 = new CellList();
		
		Scanner sc = null;
		Scanner kb = new Scanner(System.in);
		
		try {
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));
			
			
			CellPhone c = null;
			long sn;
			String brand;
			Double price;
			int year;
			
			
			
			while(sc.hasNextLine()) {
				sn =sc.nextLong();
				brand = sc.next();
				price = sc.nextDouble();
				String t = sc.next().substring(0,4);
				year = Integer.parseInt(t);
				sc.nextLine();
				
				c = new CellPhone(sn,brand, year, price);
				
				l1.addToStart(c);
				
			}
			
			l1.showContents();
			String input;
	
			
			while(true){
				System.out.print("\nPlease enter a serial number you would like to search for, or x to move to the next step of the program: ");
				input = kb.next();
				if(input.equals("x")) {
					break;
				}
				else {
					sn = Long.parseLong(input);
					if(l1.contains(sn)) {
						System.out.print("CellPhone found at index " + l1.foundIndex + ": ");
						System.out.print(l1.find(sn).getCellPhone().toString() + "\n");
					}
					else {
						System.out.println("No such serial number was found in the list\n");
					}
							
				}	
			}
			System.out.println("\nDeleting from start of list...");
			l2.deleteFromStart();//special case, deleting from start of null list
			
			//Creating objects from parameterized constructor and adding them to the start of an empty list
			System.out.println("Creating CellPhone from Parameterized Constructor...");
			CellPhone c1 = new CellPhone(12345678,"Apple", 2023, 500.45);//New cell phone from parameterized constructor with unique serial number
			l2.addToStart(c1);
			System.out.print("\n");

			System.out.println("Creating CellPhone from Parameterized Constructor...");
			CellPhone c2 = new CellPhone(6987612,"Apple", 2019, 295.89);//New cell phone from parameterized constructor with unique serial number
			l2.addToStart(c2);
			System.out.print("\n");
			
			System.out.println("Creating CellPhone from Parameterized Constructor...");
			CellPhone c3 = new CellPhone(6987612,"Samsung", 2020, 670.00);//New cell phone from parameterized constructor with non-unique serial number
			l2.addToStart(c3);
			System.out.print("\n");
			
			
			//Creating objects from copy constructor and adding them to the start of the list
			System.out.println("Creating CellPhone from Copy Constructor...");
			CellPhone c4 = new CellPhone(c1, 10455890);//copy constructor, copying a cell phone and inputting a unique serial number
			l2.addToStart(c4);
			System.out.print("\n");
			
			System.out.println("Creating CellPhone from Copy Constructor...");
			CellPhone c5 = new CellPhone(c1, 12345678);//copy constructor, copying a cell phone and inputting a non-unique serial number
			l2.addToStart(c5);
			System.out.print("\n");
			
			//Creating objects from clone method and adding them to the start of the list
			System.out.println("Creating CellPhone With Clone Method...");
			CellPhone c6 = c1.clone();//cloning cell phone c1
			l2.addToStart(c6);
			System.out.print("\n");
			
			System.out.println("Creating CellPhone With Clone Method...");
			CellPhone c7 = c2.clone();//cloning cell phone c2
			l2.addToStart(c7);
			System.out.print("\n");
			
			l2.showContents();
			
			System.out.println("\nDeleting from start of list...");
			l2.deleteFromStart();//special case, deleting from start of null list

			l2.showContents();//showing contents after deletion from start of list
			
			//Creating objects from parameterized constructor and inserting them at a given index
			System.out.println("Creating CellPhone from Parameterized Constructor...");
			CellPhone c8 = new CellPhone(172527,"Huawei", 2022, 780.42);//New cell phone from parameterized constructor with unique serial number
			l2.insertAtIndex(c8, 3);//inserting at an index within the bounds of the list size
			
			System.out.print("\n");
			
			l2.showContents();//showing contents after inserting at index within bounds
			
			int index; //creating variable for users to choose where they want to delete/ add elements from the list
			
			//Creating objects from parameterized constructor and inserting them at an index chosen by the user
			System.out.println("Creating CellPhone from Parameterized Constructor...");
			CellPhone c9 = new CellPhone(172007,"Blackberry", 2014, 295.67);//New cell phone from parameterized constructor with unique serial number
			System.out.print("\nPlease enter an index to insert the cell phone within the bounds of list size " + l2.getSize() + ": ");
			 index = kb.nextInt();
			l2.insertAtIndex(c9, index);//inserting at an index chosen by user, if it is greater than the list size, system will exit, otherwise it will insert the cell phone into the list
			
			System.out.print("\n");
			
			l2.showContents();//showing contents after inserting at index chosen by user

			System.out.print("\nPlease enter an index to delete a cell phone within the bounds of list size " + l2.getSize() + ": ");
			index = kb.nextInt();
			l2.deleteFromIndex(index);
			
			l2.showContents();//showing contents after deleting from index chosen by user
			
			System.out.println("Creating CellPhone from Parameterized Constructor...");
			CellPhone c10 = new CellPhone(10000067,"Samsung", 2023, 800.56);//New cell phone from parameterized constructor with unique serial number
			l2.replaceAtIndex(c10, 4);
			System.out.print("\n");			

			l2.showContents();//showing contents after replacing cellphone at index 4
			
			System.out.println("\nCreating new CellList with copy constructor...");
			CellList l3 = new CellList(l2);
			
			System.out.println("\nComparing cell list one and two...");
			System.out.println(l1.equals(l2));
			System.out.println("\nComparing cell list two and three...");
			System.out.println(l2.equals(l3));

			l2.appendToList(l1);
			l1.showContents();


			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

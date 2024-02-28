import java.util.Scanner;
//-----------------------------------------------------
// COMP 249 Assignment 3
// Written by: Eamon Foley 40233231
//Due Date: December 2, 2023
//-----------------------------------------------------
/**
 * The CellPhone class represents a mobile phone with essential attributes
 * such as serial number, brand, manufacturing year, and price.
 */
public class CellPhone {
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	/**
     * Retrieves the serial number of the cell phone.
     *
     * @return The serial number of the cell phone.
     */
	public long getSerialNum() {
		return serialNum;
	}
	/**
     * Sets the serial number of the cell phone.
     *
     * @param serialNum The new serial number to set.
     */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	
	/**
     * Retrieves the brand of the cell phone.
     *
     * @return The brand of the cell phone.
     */
	public String getBrand() {
		return brand;
	}
	/**
     * Sets the brand of the cell phone.
     *
     * @param brand The new brand to set.
     */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
     * Retrieves the manufacturing year of the cell phone.
     *
     * @return The manufacturing year of the cell phone.
     */
	public int getYear() {
		return year;
	}
	/**
     * Sets the manufacturing year of the cell phone.
     *
     * @param year The new manufacturing year to set.
     */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
     * Retrieves the price of the cell phone.
     *
     * @return The price of the cell phone.
     */
	public double getPrice() {
		return price;
	}
	/**
     * Sets the price of the cell phone.
     *
     * @param price The new price to set.
     */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
     * Constructs a new CellPhone object with the specified attributes.
     *
     * @param inSN    The serial number of the new cell phone.
     * @param inBrand The brand of the new cell phone.
     * @param inYear  The manufacturing year of the new cell phone.
     * @param inPrice The price of the new cell phone.
     */
	public CellPhone(long inSN,String inBrand, int inYear, double inPrice) {
		this.serialNum = inSN;
		this.brand = inBrand;
		this.year = inYear;
		this.price = inPrice;
	}
	/**
     * Constructs a new CellPhone object by cloning an existing CellPhone
     * with the specified serial number.
     *
     * @param inPhone The cell phone to clone.
     * @param inSN    The unique serial number of the new cell phone.
     */
	public CellPhone(CellPhone inPhone, long inSN) {
		this.brand = inPhone.brand;
		this.year = inPhone.year;
		this.price = inPhone.price;
		this.serialNum = inSN;
	}
	
	/**
     * Creates a cloned CellPhone object by taking user input for a unique
     * serial number.
     *
     * @return The cloned CellPhone object.
     */
	Scanner sc = null;
	public CellPhone clone() {
		sc = new Scanner(System.in);
		long inSN;
		
		System.out.println("Please enter a unique Serial Number for the cloned object you wish to create: ");
		inSN = sc.nextLong();
		CellPhone t = new CellPhone(inSN,this.brand, this.year, this.price);
		return t;
	}
	/**
     * Returns a string representation of the CellPhone object.
     *
     * @return A string containing the serial number, brand, price, and year of the cell phone.
     */
	public String toString() {
		return this.getSerialNum() + ": " + this.getBrand() + " " + this.getPrice() + "$ " + this.getYear(); 
	}
	/**
     * Checks if the specified object is equal to the current CellPhone object.
     *
     * @param x The object to compare for equality.
     * @return True if the objects are equal, false otherwise.
     */
	public boolean equals(Object x) {
		if(x == null || x.getClass() != this.getClass()) {
			return false;
		}
		else {
			CellPhone c = (CellPhone)x;
			if(this.brand.equals(c.brand) && this.price == c.price && this.year == c.year) {
				return true;
			}
			return false;
		}
	}
	
	
	
	

}

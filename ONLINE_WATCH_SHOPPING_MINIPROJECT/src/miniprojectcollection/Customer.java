package miniprojectcollection;

public class Customer{
	
	/*                     ONLINE WATCH SHOPPING -> WRIST BLISS CLICK 
	 Customer Class:

Attributes[ data members or variables that define the state of an object] :
 CustomerID, customerName, customerAddress, customerEmailID,
            customerPassword, customerPhoneNumber.
Methods: Constructors, getters, setters, and toString.
Functionality: Represents a customer with unique ID and stores personal information.
	 */

	private int CustomerID;
	private static int idgen=001;
    private String customerName;
    private String customerAddress;
    private String customerEmailID;
    private String customerPassword;
    private long customerPhoneNumber;


	public Customer() { // default constructor
		CustomerID =idgen++;

	}


	public int getCustomerID() {
		return CustomerID;
	}


	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public String getCustomerEmailID() {
		return customerEmailID;
	}


	public void setCustomerEmailID(String customerEmailID) {
		this.customerEmailID = customerEmailID;
	}


	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}


	public void setCustomerPhoneNumber(long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	
	public Customer(String customerName, String customerAddress, String customerEmailID, String customerPassword,
			long customerPhoneNumber)   //parameterized constructor
	{
		this();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmailID = customerEmailID;
		this.customerPassword = customerPassword;
		this.customerPhoneNumber = customerPhoneNumber;
	}


	@Override
	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerEmailID=" + customerEmailID + ", customerPassword=" + customerPassword
				+ ", customerPhoneNumber=" + customerPhoneNumber + "]";
	}
	
	

	


}	





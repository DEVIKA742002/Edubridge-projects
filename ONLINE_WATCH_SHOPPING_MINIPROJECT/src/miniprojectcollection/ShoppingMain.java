package miniprojectcollection;

import java.util.Scanner;

public class ShoppingMain {
	
	/*
	 ShoppingMain Class:  serves as the entry point for the application, 
	                         coordinating the overall flow and user interactions.

Methods: main (contains the main logic of the program).
Functionality: Handles the user interface, takes user input, 
                and interacts with the ShoppingApp to provide a seamless shopping experience.
	 */

	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("                                                                                                                                       ");
		System.out.println("============================================ ONLINE WATCH SHOPPING -> WRIST BLISS CLICK ===============================================");
		System.out.println("                                                                                                                                       ");

		String ch = null;

		ShoppingApp app=new ShoppingApp(); //obj
		Customer customer = app.addCustomerInfo();

		do
		{

			System.out.println("\t\t 					1) Display Product Details \r\n"
					+ "\t\t 					2) Select Product by ProductID  \r\n"
					+ "\t\t 					3) Add Products to cart  \r\n"
					+ "\t\t 					4) View Cart  \r\n"
					+ "\t\t 					5) User Authentication \r\n"
					+ "\t\t 					6) Order Confirmation \r\n"
					+ "\t\t 					7) View Order History \r\n"
					+ "\t\t 					8) Proceed to Payment \r\n"
					+ "\t\t 					9) Feedback ");
			System.out.println("                                                                                        ");
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();

			switch(choice)
			{

			case 1:	
				app.DisplayProductDetails();
				break;

			case 2:	
				app.SelectProductInfo();
				break;

			case 3:
				app.addProductToCart();
				break;

			case 4:	
				app.viewCart();
				break;

			case 5:	
				System.out.println("Enter Customer EmailID: ");
				String enteredEmailID = sc.next();
				System.out.println("Enter Customer Password: ");
				String enteredPassword = sc.next();

				if (customer.getCustomerEmailID().equals(enteredEmailID) && customer.getCustomerPassword().equals(enteredPassword)) 
				{
					System.out.println("Authentication Successful!...You can Proceed further...");
					System.out.println("=======================================================================================================================");
				}
				else 
				{
					System.out.println("Authentication Failed!...");
					System.out.println("========================================================================================================================");
				}
				break;


			
				
			case 6:
			    app.orderConfirmation(new OrderConfirmation(), customer);
			    break;



			case 7:
				app.viewOrderHistory();
				break;
				
			
			case 8:
				app.getPayment();
				break;
				
			

			case 9:
				app.getFeedback();
				break;



			default:
				System.out.println("Wrong choice!!"); 		   
			}

			System.out.println("Do you want to continue for next options? (Y-Yes / N-No)");
			ch=sc.next();
		}


		while(ch.equals("YES")||ch.equals("yes"));
		System.out.println("=======================================================================================================================================");

		System.out.println("                 Thank you for shopping with us! We hope to welcome you again soon.........     ");

		System.out.println("=======================================================================================================================================");


	}
}

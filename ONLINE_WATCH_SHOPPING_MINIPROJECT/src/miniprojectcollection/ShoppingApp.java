package miniprojectcollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingApp {
	/*
	 When the Scanner class is used in a static context,
	  it means that the methods or variables associated with it belong to the class itself 
	  rather than an instance of the class.
	 */
	
	/*
	 ShoppingApp Class:  manages the main functionality of the application, such as displaying products, 
	                     managing the shopping cart, and interacting with customers.

Attributes: ProductList, cart (List of Product), customerList (List of Customer), orderHistory (List of Order).
Methods: Constructors, DisplayProductDetails, SelectProductInfo, addProductToCart, 
         viewCart, addCustomerInfo, orderConfirmation, removeProductFromCart, 
           getCart, addToOrderHistory, viewOrderHistory, getPayment, getFeedback.
Functionality: Manages the overall shopping application, including displaying products, 
             handling cart operations, customer authentication, order confirmation, payment, and feedback.
	 */

	static Scanner sc=new Scanner(System.in);

	ArrayList<Product> ProductList=new ArrayList<Product>();
	private List<Product> cart = new ArrayList<>();
	private List<Customer> customerList = new ArrayList<>();
	private List<Order> orderHistory = new ArrayList<>();


	ShoppingApp()
	{
		// String productName, String productPrice, String brandName, String modelID
		ProductList.add(new Product("Chrono Elegance","Rs.22,000","Time Master","TM-CE001"));
		ProductList.add(new Product("Midnight Sapphire","Rs.13,500","Starlight","SW-MS202"));
		ProductList.add(new Product("Urban Explorer","Rs.18,500","City Style","CS-UE003"));
		ProductList.add(new Product("Solar Flare","Rs.11,500","Lumina Time","LT-SF101"));
		ProductList.add(new Product("Zenith Horizon","Rs.20,499","Zen Master","ZM-ZH202"));
		ProductList.add(new Product("Royal Mariner","Rs.15,999","Regal TP","RT-RM301"));
		ProductList.add(new Product("Horizon Voyager","Rs.27,500","Skyline","SC-HV004"));
		ProductList.add(new Product("Eternal Elegance","Rs.31,999","TimeCraft","TC-EE001"));
		ProductList.add(new Product("Ocean Voyager","Rs.22,799","Aqua Marine", "AM-OV004"));
		ProductList.add(new Product("Tech Explorer","Rs.24,500", "InnoTech","IT-TE003"));

	}
	
	

	public Customer addCustomerInfo()   //5 [user authentication] 
	{  //allows users to manually input their details - obj creation- obj return

		System.out.println("Enter CustomerName: ");
		String customerName = sc.next();
		System.out.println("Enter CustomerAddress: ");
		String customerAddress = sc.next();
		System.out.println("Enter CustomerEmailID: ");
		String customerEmailID = sc.next();
		System.out.println("Enter CustomerPassword: ");
		String customerPassword = sc.next();
		System.out.println("Enter CustomerPhoneNumber: ");
		long customerPhoneNumber = sc.nextLong();

		Customer customer = new Customer(customerName, customerAddress, customerEmailID, customerPassword, customerPhoneNumber);

		// Add the customer to the list
		customerList.add(customer);

		System.out.println("                                            Customer information added successfully!...                                               ");

		System.out.println("======================================================================================================================================");

		System.out.println("                                     Welcome to our Watch Collection! Here are the available Options:                                 ");
		System.out.println("                                                                                                                                      ");

		return customer;
	}



	public void DisplayProductDetails()  //1.
	{   		
		System.out.println("=======================================================================================================================================");

		if(ProductList.size()==0)
		{
			System.out.println("No record found!!");
		}
		else 
		{
			System.out.println("         Explore the elegance of time with our handpicked selection of exquisite watches...       ");
			System.out.println("                                                                                                                                   ");
		}
		for(Product p:ProductList)
		{
			System.out.println("ProductID:"+p.getProductid()+"\t ProductName:"+p.getProductName()+"\t ProductPrice:"+p.getProductPrice()+"\t BrandName:"+p.getBrandName()+"\t ModelID:"+p.getModelID());
		}
		System.out.println("                                                                                                                                       ");
		System.out.println("=======================================================================================================================================");
	}


	public void SelectProductInfo()   //2.
	{
		System.out.println("Enter ProductId : ");
		int ProductId=sc.nextInt();
		int flag=0;
		System.out.println("=======================================================================================================================================");

		for(Product p:ProductList)
		{
			if(ProductId==p.getProductid())
			{  
				flag=1;


				System.out.println("                                       Here's a glimpse of our featured products...                                               ");
				System.out.println("                                                                                                                                  ");
				System.out.println("ProductName : "+p.getProductName()+"\t "
						+ "ProductPrice : "+p.getProductPrice()+"\t "
						+ "BrandName : "+p.getBrandName()+
						"\t ModelID : "+p.getModelID());
				System.out.println("                                                                                                                                  ");
				System.out.println("                                      We hope you find the perfect watch!!....                                                    ");
			}
		}

		if(flag==0)
			System.out.println("Product Id does not exist!!");
		System.out.println("======================================================================================================================================");
	}


	public void addProductToCart()      //3.
	{
		Scanner sc = new Scanner(System.in);
		String ch;

		do {
			System.out.println("Enter ModelID : ");
			String modelID = sc.next();
			String flag = null;
			System.out.println("==============================================================================================================================");

			for (Product p : ProductList) {
				if (modelID.equals(p.getModelID())) {
					flag = "1";
					System.out.println("ProductName : " + p.getProductName() + "\t " + "ProductPrice : "
							+ p.getProductPrice() + "\t " + "BrandName : " + p.getBrandName() + "\t ModelID : "
							+ p.getModelID());
					System.out.println("                                                                                                                       ");
					System.out.println("Product " + modelID + " Successfully Added to the Cart");
					cart.add(p); // Add the product to the cart
				}
			}

			if (flag == null) {
				System.out.println("                          Product Id does not exist!!                                                                     ");
			}
			System.out.println("                                                                                                                              ");
			System.out.println("                    Do you want to add another product to the cart? (Y-Yes / N-No)                                            ");
			ch = sc.next();
			System.out.println("                                                                                                                              ");

		} while (ch.equalsIgnoreCase("yes"));

		System.out.println("==================================================================================================================================");
	}


	public void viewCart()       //4.
	{ 
		System.out.println("=======================================================================================================================================");
		System.out.println("Your Shopping Cart:");
		System.out.println("                                                                                                                                      ");

		List<Product> cart = getCart();

		if (cart.isEmpty())
		{
			System.out.println("Oops!....Your shopping cart is empty.");
		} 
		else
		{

			System.out.printf("%-15s %-25s %-15s %-20s %-15s\n", "ProductID", "ProductName", "ProductPrice", "BrandName", "ModelID");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");

			for (Product p : cart) 
			{
				System.out.printf("%-15d %-25s %-15s %-20s %-15s\n", p.getProductid(), p.getProductName(), p.getProductPrice(), p.getBrandName(), p.getModelID());
			}

			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");


			// Calculate the total price
			double totalPrice = cart.stream()
					.mapToDouble(p -> Double.parseDouble(p.getProductPrice().substring(3).replace(",", "")))
					.sum();
			System.out.println("                                                                                                     ");
			System.out.println("Total Price: Rs." + totalPrice);
		}

		System.out.println("=======================================================================================================================================");
	}


 public void orderConfirmation(OrderConfirmation orderConfirmation, Customer customer)  //6.
	{
		Order order = orderConfirmation.confirmOrder(this, customer, sc); // Pass the 'sc' scanner

		if (order != null)
		{                                                                                                                                   

			addToOrderHistory(order);
			System.out.println("                                                                                                                                      ");
			System.out.println("Order successfully added to history!");
			System.out.println("                                                                                                                                      ");
			System.out.println("======================================================================================================================================");


		}
		else 
		{
			System.out.println("Order creation failed.");
		}
	}

	public void removeProductFromCart()
	{
		System.out.println("Enter the ModelID of the product you want to remove from the cart:");
		String modelIDToRemove = sc.next();

		boolean removed = cart.removeIf(product -> product.getModelID().equals(modelIDToRemove));

		if (removed)
		{
			System.out.println("                                                                                                                                       ");
			System.out.println("Product with ModelID " + modelIDToRemove + " removed from the cart.");
			System.out.println("=======================================================================================================================================");
		} 
		else 
		{
			System.out.println("                                                                                                                                       ");
			System.out.println("Product with ModelID " + modelIDToRemove + " not found in the cart.");
			System.out.println("=======================================================================================================================================");
		}

	}


	public List<Product> getCart() //cart
	{ 
		return cart;
	}



	public void addToOrderHistory(Order order) //7.
	{
		orderHistory.add(order);
	}

	public void viewOrderHistory() 
	{
		if (orderHistory.isEmpty())
		{
			System.out.println("Order history is empty...");
			System.out.println("======================================================================");
		} 
		else 
		{
			System.out.println("Order History Before Removing Cart:");
			System.out.println("                                                                                                      ");

			System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

			for (Order order : orderHistory) {
				System.out.println(order);
			}

			System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

			System.out.println("                                                                                                      ");
			System.out.println("Order History After Removing Cart:");
			System.out.println("                                                                                                       ");
			viewCart();


		}
	}


	public void getPayment()  //8.
	{
		System.out.println("Please proceed with the payment to confirm your order...");
		System.out.println("                                                                                                                                       ");
		System.out.println("Enter the payment method (Credit Card, Debit Card, UPI):");
		String paymentMethod = sc.next();
		System.out.println("                                                                                                                                       ");



		if (paymentMethod.equalsIgnoreCase("Credit Card") || 
				paymentMethod.equalsIgnoreCase("Debit Card") ||
				paymentMethod.equalsIgnoreCase("UPI"))
		{
			System.out.println("Payment Successful!............");
			System.out.println("=======================================================================================================================================");
		}
		else 
		{
			// Display "Payment Failed" if the entered payment method is not one of the specified options
			System.out.println("Payment Failed!.. Please enter a valid payment method.");
			System.out.println("=======================================================================================================================================");
		}
	}



	public void getFeedback() //9.
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to provide feedback? (Y-Yes / N-No)");
		String feedbackConfirmation = sc.next();

		if (feedbackConfirmation.equalsIgnoreCase("yes")) {
			sc.nextLine();  // Consume the newline character
			System.out.println("Please provide your feedback:");
			String feedback = sc.nextLine(); // Get the feedback from the user

		}

		System.out.println("                                          Thank you for your valuable feedback!                                                               ");
		System.out.println("                                                                                                                                              ");
		System.out.println("==============================================================================================================================================");
		System.out.println("                                                                                                                                              ");
		System.out.println("                                   Watch Perfection, Thanks for your Selection!......                                                         ");
		System.out.println("                                                                                                                                              ");
		System.out.println("==============================================================================================================================================");
	}















}














package miniprojectcollection;

import java.util.List;
import java.util.Scanner;

public class OrderConfirmation {
	
	/*
	 OrderConfirmation Class:
	 
	  handles the process of confirming an order, displaying cart contents, 
	  calculating the total price, and obtaining user confirmation.

Methods: confirmOrder (takes a ShoppingApp, Customer, and Scanner to confirm the order).
Functionality: Manages the order confirmation process, displays cart items, 
                calculates total price, and handles user confirmation
                ensuring a user-friendly and secure transaction experience.

*/

    public Order confirmOrder(ShoppingApp shoppingApp, Customer customer, Scanner sc) 
    { //instance of the ShoppingApp class,customer,scanner in shoppingMain[to read user input]
        System.out.println("Order Confirmation:");
        System.out.println("================================================================================================================================");

        List<Product> cart = shoppingApp.getCart();

        if (cart.isEmpty()) {
            System.out.println("Your shopping cart is empty. Add products before confirming the order.");
            return null;
        }
        

        // Display the products in the cart
        System.out.println("                                             Displaying the Products in Your Cart:                                                       ");
        for (Product p : cart) {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ProductID:" + p.getProductid() + "\t ProductName:" + p.getProductName()
                    + "\t ProductPrice:" + p.getProductPrice() + "\t BrandName:" + p.getBrandName() + "\t ModelID:"
                    + p.getModelID());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        }
        

        // Calculate the total price
        double totalPrice = cart.stream()
                .mapToDouble(p -> Double.parseDouble(p.getProductPrice().substring(3).replace(",", "")))
                .sum();
        System.out.println("Total Price: Rs." + totalPrice);
        System.out.println("                                                                                                                                      ");

        
        // Ask if the user wants to remove any product
        System.out.println("Do you want to remove any product from the cart? (Y-Yes / N-No)");
        String removeConfirmation = sc.next().toLowerCase();
        System.out.println("                                                                                                                                      ");

        if (removeConfirmation.equals("yes")) {
            shoppingApp.removeProductFromCart(); // Assuming you have this method in ShoppingApp
        }

        
        // Ask for confirmation to proceed with the order
        System.out.println("Do you want to confirm the order? (Y-Yes / N-No)");
        String confirmation = sc.next();

        if (confirmation.equalsIgnoreCase("yes")) 
        {     System.out.println("Order confirmed!!!!...");

            System.out.println("===================================================================================================================");
           
            // Create an Order object
            Order order = new Order(customer, cart, totalPrice);
            return order;
        }
        else 
        {
            System.out.println("Order Cancelled!!");
            return null;
        }
    }
}

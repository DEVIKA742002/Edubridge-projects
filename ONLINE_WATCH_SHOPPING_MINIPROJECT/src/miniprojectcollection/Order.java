package miniprojectcollection;

import java.util.List;

public class Order {
	
	/*
Order Class:  which represents a customer's order and contains details about the products they have selected.

Attributes: Customer, products (List of Product), totalPrice.
Methods: Constructors, getters, setters, and toString.
Functionality: Represents an order with customer details, list of products, and total price.
	 */
	
	    private Customer customer;
	    private List<Product> products;
	    private double totalPrice;

	    public Order(Customer customer, List<Product> products, double totalPrice)
	    { //parameterized constructor
	        this.customer = customer;
	        this.products = products;
	        this.totalPrice = totalPrice;
	    }

	    public List<Product> getProducts() {
	        return products;
	    }

	    public void setProducts(List<Product> products) {
	        this.products = products;
	    }

	    public double getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(double totalPrice) {
	        this.totalPrice = totalPrice;
	    }

	    @Override
	    public String toString() {
	        return "Order[customer=" + customer + ", products=" + products + ", totalPrice=" + totalPrice + "]";
	    }
	}

		
	




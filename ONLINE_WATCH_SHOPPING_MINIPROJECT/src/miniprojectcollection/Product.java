package miniprojectcollection;

public class Product {
	
	/*
	 Product Class:   central component 

Attributes: Productid, ProductName, ProductPrice, BrandName, ModelID.
Methods: Constructors, getters, setters, and toString.
Functionality: Represents a product with details like name, price, brand, and model.
	 */
	

	private int Productid;
	private static int idgen=001;
	private String ProductName;
	private String ProductPrice;
	private String BrandName;
	private String ModelID;
	
	
	public Product() {//default constructor
		Productid =idgen++;
		
	}


	public int getProductid() {
		return Productid;
	}


	public void setProductid(int productid) {
		Productid = productid;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProductName(String productName) {
		ProductName = productName;
	}


	public String getProductPrice() {
		return ProductPrice;
	}


	public void setProductPrice(String productPrice) {
		ProductPrice = productPrice;
	}


	public String getBrandName() {
		return BrandName;
	}


	public void setBrandName(String brandName) {
		BrandName = brandName;
	}


	public String getModelID() {
		return ModelID;
	}


	public void setModelID(String modelID) {
		ModelID = modelID;
	}
	
	public Product( String productName, String productPrice, String brandName, String modelID) 
	{//parameterized constructor
		this();
		ProductName = productName;
		ProductPrice = productPrice;
		BrandName = brandName;
		ModelID = modelID;
	}


	@Override
	public String toString() {
		return "Product [ProductName=" + ProductName + ", ProductPrice=" + ProductPrice
				+ ", BrandName=" + BrandName + ", ModelID=" + ModelID + "]";
	}
	
	
	

	
	

}

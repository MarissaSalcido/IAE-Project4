package com.tomerestservice.model;


import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "orderitem")
//You will need to create a Java Object. Jersey uses these to construct requests and responses.

public class OrderItem {
	private String productId;
	private String imageSrc;
	private String itemName;
	private double price;
	private int quantity;
	
	// Constructor
	OrderItem(String productId, String imageSrc, String itemName, double price, int quantity) {
		this.productId = productId;
		this.imageSrc = imageSrc;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;		
	}
	
	public String getProductId() {
		return this.productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getImageSrc() {
		return this.imageSrc;
	}
	
	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	// Returns the quantity as an int
	public int getQuantity() {
		return this.quantity;
	}
	
	// Sets the quantity as an int
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}


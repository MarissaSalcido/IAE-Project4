package com.tomerestservice.model;


import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "order")
//You will need to create a Java Object. Jersey uses these to construct requests and responses.

public class Order {
    private int orderId;
    
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private String shippingMethod;
    
    private String cardType;
    private String cardNumber;
    private int expMonth;
    private int expYear;
    private int cvv;
    private String subtotal;
    private String tax;
    private String shippingCost;
    private String total;
    

    // orders table vector? with item?
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFirstName() {
    	return firstName;
    }
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }

    public String getLastName() {
    	return lastName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public String getPhoneNum() {
    	return phoneNum;
    }
    
    public void setPhoneNum(String phoneNum) {
    	this.phoneNum = phoneNum;
    }
    
    public String getAddress1() {
    	return address1;
    }
    
    public void setAddress1(String address1) {
    	this.address1 = address1;
    }
    
    public String getAddress2() {
    	return address2;
    }
    
    public void setAddress2(String address2) {
    	this.address2 = address2;
    }
    
    public String getCity() {
    	return city;
    }
    
    public void setCity(String city) {
    	this.city = city;
    }
    
    public String getState() {
    	return state;
    }
    
    public void setState(String state) {
    	this.state = state;
    }

    public String getZipcode() {
    	return zipcode;
    }
    
    public void setZipcode(String zipcode) {
    	this.zipcode = zipcode;
    }

    public String getShippingMethod() {
    	return shippingMethod;
    }
    
    public void setShippingMethod(String shippingMethod) {
    	this.shippingMethod = shippingMethod;
    }
    
    public String getCardType() {
    	return cardType;
    }
    
    public void setCardType(String cardType) {
    	this.cardType = cardType;
    }

    public String getCardNumber() {
    	return cardNumber;
    }
    
    public void setCardNumber(String cardNumber) {
    	this.cardNumber = cardNumber;
    }
    
    public int getExpMonth() {
    	return expMonth;
    }
    
    public void setExpMonth(int expMonth) {
    	this.expMonth = expMonth;
    }

    public int getExpYear() {
    	return expYear;
    }
    
    public void setExpYear(int expYear) {
    	this.expYear = expYear;
    }
    
    public int getCvv() {
    	return cvv;
    }
    
    public void setCvv(int cvv) {
    	this.cvv = cvv;
    }

    public String getSubtotal() {
    	return subtotal;
    }
    
    public void setSubtotal(String subtotal) {
    	this.subtotal = subtotal;
    }

    public String getTax() {
    	return tax;
    }
    
    public void setTax(String tax) {
    	this.tax = tax;
    }
    
    public String getTax() {
    	return tax;
    }
    
    public void setTax(String tax) {
    	this.tax = tax;
    }
    
    public String getShippingCost() {
    	return shippingCost;
    }
    
    public void setShippingCost(String shippingCost) {
    	this.shippingCost = shippingCost;
    }
    
    public String getTotal() {
    	return total;
    }
    
    public void setTotal(String total) {
    	this.total = total;
    }
}
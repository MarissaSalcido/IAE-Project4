package com.tomerestservice.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tomerestservice.db.DatabaseConnector;
import com.tomerestservice.db.DatabaseUtils;
import com.tomerestservice.model.Order;
import com.tomerestservice.model.OrderItem;

public class OrderService {

    private final static String ALL_CUSTOMERS_QUERY = "SELECT * FROM customers";
    private final static String ALL_BILLING_QUERY = "SELECT * FROM billing";
    private final static String ALL_ORDER_ITEMS_QUERY = "SELECT * FROM order_items";
    
    public static int postOrder(Order order) {
    	boolean insertIntoCustomers = false;
    	boolean insertIntoBilling = false;
    	boolean insertIntoOrderItems = false;
    	boolean validFields = validateFields(order);
    	int orderId = -1;
    	
    	if (validFields) {
			// Insert order info to into customers table
		    String sql = "INSERT INTO customers (first_name, last_name, phone_num, address_1, address_2, city, state, zipcode, shipping_method)" +
		            		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    Connection connection = DatabaseConnector.getConnection();
		    orderId = DatabaseUtils.performDBUpdateForCustomers(connection, sql, order.getFirstName(), order.getLastName(), order.getPhoneNum(), order.getAddress1(), order.getAddress2(), order.getCity(), order.getState(), order.getZipcode(), order.getShippingMethod());
			
		    System.out.println("Order Id: "+ orderId);
		    // If order info was not successfully inserted into customers table, return false
		    if (orderId <= 0) {
		    	insertIntoCustomers = false;
		    }
		    else {
		    	insertIntoCustomers = true;
		    	order.setOrderId(orderId);
		    	
		    	sql = "INSERT INTO billing (order_id, card_type, card_number, exp_month, exp_year, cvv, subtotal, tax, shipping_cost, total)" +
		        		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    	insertIntoBilling = DatabaseUtils.performDBUpdateForBilling(connection, sql, order.getOrderId(), order.getCardType(), order.getCardNumber(), order.getExpMonth(), order.getExpYear(), order.getCvv(), order.getSubtotal(), order.getTax(), order.getShippingCost(), order.getTotal());
		    	
		    	// If not successfully inserted into billing table, remove entry in customer table for this order to preserve idempotent of the database
		    	if (!insertIntoBilling) {
		    		deleteCustomersEntry(connection, order.getOrderId());
		    	}
		    	else {
		        	sql = "INSERT INTO order_items (order_id, product_id, image_src, item_name, price, quantity)" +
		            		"VALUES (?, ?, ?, ?, ?, ?)";
		        	
		        	List<OrderItem> itemsList = order.getOrderItems();
		        	
		        	for (int i = 0; i < itemsList.size(); ++i) {
		        		OrderItem item = itemsList.get(i);
		        		
			        	insertIntoOrderItems = DatabaseUtils.performDBUpdateForOrderItems(connection, sql, orderId, item.getProductId(), item.getImageSrc(), item.getItemName(), item.getPrice(), item.getQuantity());
			        
			        	// If not successfully able to insert an order item into the order_items table, remove entry in all tables to preserve idempotent of the database
			        	if (!insertIntoOrderItems) {
			        		// Delete entry in customers table for this order
			        		deleteCustomersEntry(connection, order.getOrderId());
			        		
			        		// Delete entry in billing table for this order
			        		deleteBillingEntry(connection, order.getOrderId());
			        		
			        		// If i > 0, then delete any entries in order table for this order
			        		if (i > 0) {
			        			deleteOrderItems(connection, order.getOrderId());		        			
			        		}
			        		
			        		// To get out of the loop inserting each item into the order_items table
			        		i = itemsList.size();
			        	}
		        	}
		    	}
		    }
		    
		    try {
		
		        // Close database connection
		        connection.close();
		    } 
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
    	}

    	if (validFields && insertIntoCustomers && insertIntoBilling && insertIntoOrderItems) {
    		return orderId;
    	}
    	else {
    		return -1;
    	}
    }

    public static Order getOrderById(int orderId) {
        // Establishing a new connection
        Connection connection = DatabaseConnector.getConnection();
        boolean customerResult = false;
        boolean billingResult = false;
        boolean orderItemsResult = false;
        
        
        try {
	        Order order = new Order();	
	        ResultSet resultSet;
	        
	        // Retrieve order info from customers table
	        resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_CUSTOMERS_QUERY + " WHERE order_id = " + orderId);
	        if (resultSet != null) {
	        	resultSet.next();
	            order.setOrderId(resultSet.getInt("order_id"));
	            order.setFirstName(resultSet.getString("first_name"));
	            order.setLastName(resultSet.getString("last_name"));
	            order.setPhoneNum(resultSet.getString("phone_num"));
	            order.setAddress1(resultSet.getString("address_1"));
	            order.setAddress2(resultSet.getString("address_2"));
	            order.setCity(resultSet.getString("city"));
	            order.setState(resultSet.getString("state"));
	            order.setZipcode(resultSet.getString("zipcode"));
	            order.setShippingMethod(resultSet.getString("shipping_method"));
	            customerResult = true;	            
	        }
	        
	        // Retrieve order info from billing table
	        resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_BILLING_QUERY + " WHERE order_id = " + orderId);
	        if (resultSet != null) {
	        	resultSet.next();
	        	order.setCardType(resultSet.getString("card_type"));
	        	order.setCardNumber(resultSet.getString("card_number"));
	        	order.setExpMonth(resultSet.getString("exp_month"));
	        	order.setExpYear(resultSet.getString("exp_year"));
	        	order.setCvv(resultSet.getString("cvv"));
	        	order.setSubtotal(resultSet.getDouble("subtotal"));
	        	order.setTax(resultSet.getDouble("tax"));
	        	order.setShippingCost(resultSet.getDouble("shipping_cost"));
	        	order.setTotal(resultSet.getDouble("total"));
	        	billingResult = true;
	        }
	        
	        // Retrieve order info from order_items table
	        resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_ORDER_ITEMS_QUERY + " WHERE order_id = " + orderId);
	        if (resultSet != null) {
		    	OrderItem itemFromDB;
		    	List<OrderItem> itemsList = new ArrayList<OrderItem>();
		    	
		    	while (resultSet.next()) {
		    		itemFromDB = new OrderItem();
		    		itemFromDB.setProductId(resultSet.getString("product_id"));
		    		itemFromDB.setImageSrc(resultSet.getString("image_src"));
		    		itemFromDB.setItemName(resultSet.getString("item_name"));
		    		itemFromDB.setPrice(resultSet.getDouble("price"));
		    		itemFromDB.setQuantity(resultSet.getInt("quantity"));
		    		itemsList.add(itemFromDB);
			    	
			    	orderItemsResult = true;
		    	}
		    	
	    		order.setOrderItems(itemsList);
	        }
	        
	        // Retrieve order info from orders table
	        if (customerResult && billingResult && orderItemsResult) {
	        	return order;
	        }
	        else {
	        	return null;
	        }
        } 
            catch (SQLException e) {
                e.printStackTrace();
            } 
            finally {
                try {

                    // Close database connection
                    connection.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        return null;


    }
    
    private static boolean deleteCustomersEntry(Connection connection, int orderId) {

        String sql = "DELETE FROM customers WHERE order_id=?;";

        boolean updateStatus = DatabaseUtils.performDelete(connection, sql, orderId);
        
        if (!updateStatus) {
        	System.out.println("Error deleting " + orderId + " entry from customers table");
        }

        return updateStatus;
    }
    
    private static boolean deleteBillingEntry(Connection connection, int orderId) {

        String sql = "DELETE FROM billing WHERE order_id=?;";

        boolean updateStatus = DatabaseUtils.performDelete(connection, sql, orderId);
        
        if (!updateStatus) {
        	System.out.println("Error deleting " + orderId + " entry from billing table");
        }

        return updateStatus;
    }
    
    private static boolean deleteOrderItems(Connection connection, int orderId) {

        String sql = "DELETE FROM order_items WHERE order_id=?;";

        boolean updateStatus = DatabaseUtils.performDelete(connection, sql, orderId);
        
        if (!updateStatus) {
        	System.out.println("Error deleting " + orderId + " entries from order_items table");
        }

        return updateStatus;
    }

	private static boolean validateFields(Order order) {
		return (!order.getFirstName().isEmpty() && 
				!order.getLastName().isEmpty() &&
				(order.getPhoneNum().length() == 10) &&
				!order.getAddress1().isEmpty() && 
				!order.getCity().isEmpty() &&
				(order.getState().length() == 2) && 
				(order.getZipcode().length() == 5) &&
				!order.getShippingMethod().isEmpty() &&
				!order.getCardType().isEmpty() && 
				(order.getCardNumber().length() == 16) &&
				!order.getExpMonth().isEmpty() && 
				!order.getExpYear().isEmpty() &&
				(order.getCvv().length() == 3));		
	}
}



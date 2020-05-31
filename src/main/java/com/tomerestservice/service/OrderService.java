package com.tomerestservice.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tomerestservice.db.DatabaseConnector;
import com.tomerestservice.db.DatabaseUtils;
import com.tomerestservice.model.Order;

public class OrderService {

    private final static String ALL_CUSTOMERS_QUERY = "SELECT * FROM customers";
    private final static String ALL_BILLING_QUERY = "SELECT * FROM billing";
    private final static String ALL_ORDERS_QUERY = "SELECT * FROM orders";
    

    public static Order getOrderById(int orderId) {
        //Get a new connection object before going forward with the JDBC invocation.
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
	        	order.setExpMonth(resultSet.getInt("exp_month"));
	        	order.setExpYear(resultSet.getInt("exp_year"));
	        	order.setCvv(resultSet.getInt("cvv"));
	        	order.setSubtotal(resultSet.getString("subtotal"));
	        	order.setTax(resultSet.getString("tax"));
	        	order.setShippingCost(resultSet.getString("shipping_cost"));
	        	order.setTotal(resultSet.getString("total"));
	        	billingResult = true;
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

                    // We will always close the connection once we are done interacting with the Database.
                    connection.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;


    }

    public static boolean postOrder(Order order) {
/*
        String sql = "INSERT INTO TODOS  (TODO_SUMMARY, TODO_DESC)" +
                "VALUES (?, ?)";
        Connection connection = DatabaseConnector.getConnection();
        return DatabaseUtils.performDBUpdate(connection, sql, example.getSummary(), example.getDescription());*/
    	
    	return;
    }
}



package com.tomerestservice.db;

import java.sql.*;


public class DatabaseUtils {


    public static ResultSet retrieveQueryResults(Connection connection, final String sql) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public static ResultSet retrieveQueryResultsWithParam(Connection connection, final String sql, Object param) {

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, (Integer) param);
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;


    }

    public static boolean performDBUpdate(Connection connection, String sql, String... params) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);


            int i = 1;
            for (String param : params) {

                preparedStatement.setString(i++, param);

            }

            return preparedStatement.executeUpdate() > 0 ;

        } catch (SQLException e) {
            return false;
        }
    }

    
    public static int performDBUpdateForCustomers(Connection connection, String sql, String... params) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            int i = 1;
            for (String param : params) {

                preparedStatement.setString(i++, param);

            }

            if (preparedStatement.executeUpdate() > 0) {
            	ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
    	    	if (generatedKeys.next()) {
    	    		return generatedKeys.getInt(1);
    	    	}
    	    	else {
    	    		return -1;
    	    	}
            }
            else {
            	return -1;
            }

        } catch (SQLException e) {
            return -1;
        }
    }
    
    public static boolean performDBUpdateForBilling(Connection connection, String sql, int orderId, String cardType, String cardNumber, String month, String year, String cvv, double subtotal, double tax, double shippingCost, double total) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, orderId);
            preparedStatement.setString(2, cardType);
            preparedStatement.setString(3, cardNumber);
            preparedStatement.setString(4, month);
            preparedStatement.setString(5, year);
            preparedStatement.setString(6, cvv);
            preparedStatement.setDouble(7, subtotal);
            preparedStatement.setDouble(8, tax);
            preparedStatement.setDouble(9, shippingCost);
            preparedStatement.setDouble(10, total);
            
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
        	 System.err.println("Message: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean performDBUpdateForOrderItems(Connection connection, String sql, int orderId, String productId, String imageSrc, String itemName, double price, int quantity) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, orderId);
            preparedStatement.setString(2, productId);
            preparedStatement.setString(3, imageSrc);
            preparedStatement.setString(4, itemName);
            preparedStatement.setDouble(5, price);
            preparedStatement.setInt(6, quantity);
            
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
        	 System.err.println("Message: " + e.getMessage());
            return false;
        }
    }
}

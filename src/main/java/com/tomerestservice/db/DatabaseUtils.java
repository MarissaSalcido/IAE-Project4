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

    
    public static int performDBUpdateAndReturnOrderId(Connection connection, String sql, String... params) {
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
    
    public static boolean performDBUpdateWithOrderId(Connection connection, String sql, int orderId, String... params) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, orderId);
            System.out.println("orderId param: "+ orderId);
            
            int j = 2;
            for (String param : params) {
                preparedStatement.setString(j, param);
                System.out.println("paramInUtil: " + j + " " + param);
                ++j;
            }

            //int mysqlOutput = preparedStatement.executeUpdate();
          //  System.out.println("mysqlOutput: " + );
          //  return mysqlOutput > 0 ;
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
        	 System.err.println("Message: " + e.getMessage());
            return false;
        }
    }
}

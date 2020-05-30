package com.tomerestservice.db;

import java.sql.*;


public class DatabaseConnector {
	private final static String DRIVER = "org.mariadb.jdbc.Driver";
	private final static String URL = "jdbc:mariadb://127.0.0.1/tomedatabase";
//	private final static String URL = "jdbc:mysql://127.0.0.1:3306"; // previous url used in pa3
	private final static String USERNAME = "root";
	private final static String PASSWORD = "";
	

    private DatabaseConnector() {

    }

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }


}

package com.tomerestservice.db;

import java.sql.*;


public class DatabaseConnector {


    private DatabaseConnector() {

    }

    public static Connection getConnection() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection("jdbc:mariadb://127.0.0.1/tomedatabase",
                    "root", "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }


}

package com.tomerestservice.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tomerestservice.db.DatabaseConnector;
import com.tomerestservice.db.DatabaseUtils;
import com.tomerestservice.model.Example;

public class ExampleService {


    private final static String ALL_TODOS_QUERY = "SELECT * FROM TODOS";

    public static Example getExampleById(int id) {
        //Get a new connection object before going forward with the JDBC invocation.
        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_TODOS_QUERY + " WHERE TODO_ID = " + id);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Example example = new Example();


                    example.setId(resultSet.getInt("TODO_ID"));
                    example.setDescription(resultSet.getString("TODO_DESC"));
                    example.setSummary(resultSet.getString("TODO_SUMMARY"));

                    return example;

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {

                    // We will always close the connection once we are done interacting with the Database.
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;


    }

    public static List<Example> getAllExamples() {
        List<Example> examples = new ArrayList<Example>();

        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_TODOS_QUERY);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Example todo = new Example();

                    todo.setId(resultSet.getInt("TODO_ID"));
                    todo.setDescription(resultSet.getString("TODO_DESC"));
                    todo.setSummary(resultSet.getString("TODO_SUMMARY"));

                    examples.add(todo);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return examples;
    }

    public static boolean AddExample(Example example) {

        String sql = "INSERT INTO TODOS  (TODO_SUMMARY, TODO_DESC)" +
                "VALUES (?, ?)";
        Connection connection = DatabaseConnector.getConnection();
        return DatabaseUtils.performDBUpdate(connection, sql, example.getSummary(), example.getDescription());

    }

    public static boolean updateExample(Example example) {

        String sql = "UPDATE TODOS SET TODO_SUMMARY=?, TODO_DESC=? WHERE TODO_ID=?;";

        Connection connection = DatabaseConnector.getConnection();

        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, example.getSummary(), example.getDescription(),
                String.valueOf(example.getId()));

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateStatus;

    }

    public static boolean deleteExample(Example retrievedExample) {

        String sql = "DELETE FROM TODOS WHERE TODO_ID=?;";

        Connection connection = DatabaseConnector.getConnection();

        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, String.valueOf(retrievedExample.getId()));

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateStatus;
    }
}


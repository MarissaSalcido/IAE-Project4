package com.tomerestservice.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tomerestservice.db.DatabaseConnector;
import com.tomerestservice.db.DatabaseUtils;
import com.tomerestservice.model.Book;

public class BookService {


    private final static String ALL_TODOS_QUERY = "SELECT * FROM books";

    public static Book getBookById(String id) {
        //Get a new connection object before going forward with the JDBC invocation.
        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_TODOS_QUERY + " WHERE id="+ "\""+id+"\"");

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Book book = new Book();

                    book.setId(resultSet.getString("id"));
                    book.setAuthor(resultSet.getString("author"));                   	
                    book.setGenre(resultSet.getString("genre"));
                    book.setName(resultSet.getString("name"));
                    book.setPrice(resultSet.getFloat("price"));
                    book.setType(resultSet.getString("type"));
                    book.setImage(resultSet.getString("image"));
                    book.setSummary(resultSet.getString("summary"));

                    return book;

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

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();

        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_TODOS_QUERY);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                	Book book = new Book();

                    book.setId(resultSet.getString("id"));
                    book.setAuthor(resultSet.getString("author"));                   	
                    book.setGenre(resultSet.getString("genre"));
                    book.setName(resultSet.getString("name"));
                    book.setPrice(resultSet.getFloat("price"));
                    book.setType(resultSet.getString("type"));
                    book.setImage(resultSet.getString("image"));
                    book.setSummary(resultSet.getString("summary"));

                    books.add(book);

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

        return books;
    }

//    public static boolean AddBook(Book book) {
//
//        String sql = "INSERT INTO TODOS  (TODO_SUMMARY, TODO_DESC)" +
//                "VALUES (?, ?)";
//        Connection connection = DatabaseConnector.getConnection();
//        return DatabaseUtils.performDBUpdate(connection, sql, book.getSummary(), book.getDescription());
//
//    }

//    public static boolean updateBook(Book book) {
//
//        String sql = "UPDATE TODOS SET TODO_SUMMARY=?, TODO_DESC=? WHERE TODO_ID=?;";
//
//        Connection connection = DatabaseConnector.getConnection();
//
//        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, book.getSummary(), book.getDescription(),
//                String.valueOf(book.getId()));
//
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return updateStatus;
//
//    }

//    public static boolean deleteBook(Book retrievedBook) {
//
//        String sql = "DELETE FROM TODOS WHERE TODO_ID=?;";
//
//        Connection connection = DatabaseConnector.getConnection();
//
//        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, String.valueOf(retrievedBook.getId()));
//
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return updateStatus;
//    }
}

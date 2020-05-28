package com.tomerestservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tomerestservice.model.Book;
import com.tomerestservice.service.BookService;

import java.util.List;

/**
 * This class contains the methods that will respond to the various endpoints that you define for your RESTful API Service.
 *
 */
//todos will be the pathsegment that precedes any path segment specified by @Path on a method.
@Path("/books")
public class BookResource {


    //This method represents an endpoint with the URL /todos/{id} and a GET request ( Note that {id} is a placeholder for a path parameter)
    @Path("{id}")
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) //This provides only JSON responses
    public Response getBookById(@PathParam("id") int id/* The {id} placeholder parameter is resolved */) {
        //invokes the DB method which will fetch a todo_list item object by id
        Book book = BookService.getBookById(id);

        //Respond with a 404 if there is no such todo_list item for the id provided
        if(book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //Respond with a 200 OK if you have a todo_list_item object to return as response
        return Response.ok(book).build();
    }

    //This method represents an endpoint with the URL /todos and a GET request.
    // Since there is no @PathParam mentioned, the /todos as a relative path and a GET request will invoke this method.
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getAllBooks() {
        List<Book> bookList = BookService.getAllBooks();

        if(bookList == null || bookList.isEmpty()) {

        }

        return Response.ok(bookList).build();
    }

    //This method represents an endpoint with the URL /todos and a POST request.
    // Since there is no @PathParam mentioned, the /todos as a relative path and a POST request will invoke this method.
    @POST
    @Consumes({MediaType.APPLICATION_JSON}) //This method accepts a request of the JSON type
    public Response addBook(Book book) {

        //The todo object here is automatically constructed from the json request. Jersey is so cool!
        if(BookService.AddBook(book)) {
            return Response.ok().entity("TODO Added Successfully").build();
        }

        // Return an Internal Server error because something wrong happened. This should never be executed
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

    //Similar to the method above.
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED}) //This method accepts form parameters.
    //If you were to send a POST through a form submit, this method would be called.
    public Response addBook(@FormParam("summary") String summary,
                            @FormParam("description") String description) {
        Book book = new Book();
        book.setSummary(summary);
        book.setDescription(description);

        if(BookService.AddBook(book)) {
        	System.out.println("TODO added successfully");
        	
            return Response.ok().entity("TODO Added Successfully").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

    //This method represents a PUT request where the id is provided as a path parameter and the request body is provided in JSON
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateBook(@PathParam("id") int id, Book book) {

        // Retrieve the todo that you will need to change
        Book retrievedBook = BookService.getBookById(id);

        if(retrievedBook == null) {
            //If not found then respond with a 404 response.
            return Response.status(Response.Status.NOT_FOUND).
                    entity("We could not find the requested resource").build();
        }

        // This is the todo_object retrieved from the json request sent.
        book.setId(id);

        // if the user has provided null, then we set the retrieved values.
        // This is done so that a null value is not passed to the todo object when updating it.
        if(book.getDescription() == null) {
            book.setDescription(retrievedBook.getDescription());
        }

        //Same as above. We only change fields in the todo_resource when the user has entered something in a request.
        if (book.getSummary() == null) {
            book.setSummary(retrievedBook.getSummary());
        }

        //This calls the JDBC method which in turn calls the the UPDATE SQL command
        if(BookService.updateBook(book)) {

            return Response.ok().entity(book).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

    //This method represents a DELETE request where the id is provided as a path parameter and the request body is provided in JSON
    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    public Response deleteBook(@PathParam("id") int id) {

        //Retrieve the todo_object that you want to delete.
        Book retrievedBook = BookService.getBookById(id);

        if(retrievedBook == null) {
            //If not found throw a 404
            return Response.status(Response.Status.NOT_FOUND).
                    entity("We could not find the requested resource").build();
        }

        // This calls the JDBC method which in turn calls the DELETE SQL command.
        if(BookService.deleteBook(retrievedBook)) {
            return Response.ok().entity("TODO Deleted Successfully").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

}

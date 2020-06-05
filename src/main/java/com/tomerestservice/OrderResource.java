package com.tomerestservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tomerestservice.model.Order;
import com.tomerestservice.service.OrderService;

import java.util.List;

/**
 * This class contains the methods that will respond to the various endpoints that you define for your RESTful API Service.
 *
 */

@Path("/order")
public class OrderResource {
    //This method represents an endpoint with the URL /order and a POST request.
    // Since there is no @PathParam mentioned, the /order as a relative path and a POST request will invoke this method.
    @POST
    @Consumes({MediaType.APPLICATION_JSON}) //This method accepts a request of the JSON type
    public Response addOrder(Order newOrder) {
    	
    	int orderId = OrderService.postOrder(newOrder);
    	
        //The todo object here is automatically constructed from the json request. Jersey is so cool!
        if(orderId > 0) {
        	// Retrieve the order using getById and place in a new object called order 
            return Response.ok(OrderService.getOrderById(orderId), MediaType.APPLICATION_JSON).build();
        }

        // Return an Internal Server error because something wrong happened. This should never be executed
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

    }
}



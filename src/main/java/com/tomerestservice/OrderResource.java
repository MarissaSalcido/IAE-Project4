package com.tomerestservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tomerestservice.model.Order;
import com.tomerestservice.service.OrderService;

@Path("/order")
public class OrderResource {
    //This method represents an endpoint with the URL /order and a POST request.
    @POST
    @Consumes({MediaType.APPLICATION_JSON}) //This method accepts a request of the JSON type
    public Response addOrder(Order newOrder) {
    	
    	int orderId = OrderService.postOrder(newOrder);
    	
        if (orderId > 0) {
        	// Retrieve the order using getById and place in a new object called order 
            return Response.ok(OrderService.getOrderById(orderId), MediaType.APPLICATION_JSON).build();
        }
        else {
        	return Response.status(Response.Status.NOT_FOUND).entity("Unable to process order").build();
        }

        // Return an Internal Server error because something wrong happened. This should never be executed
        //return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

    }
}



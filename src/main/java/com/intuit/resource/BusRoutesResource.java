package com.intuit.resource;

import com.intuit.mongo.MongoDao;
import com.intuit.types.BusRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/***
 *
 */
@Consumes("application/json")
@Produces("application/json")
@Path("/busroute")
@Singleton
@Component
public class BusRoutesResource {

    @Autowired
    private MongoDao mongoDao;

    @GET
    @Path("/{routeNumber}")
    public Response getBusRoute(@PathParam("routeNumber") String routeNumber){
        BusRoute busRoute = mongoDao.getBusRoute(routeNumber);
        return Response.ok().entity(busRoute).build();
    }
}

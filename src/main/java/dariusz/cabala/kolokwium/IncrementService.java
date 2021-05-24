package dariusz.cabala.kolokwium;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

@Path("/increment")
public class IncrementService {
    @Context
    ServletContext context;
    @Inject
    CounterResourceInterface counterResource;
    @GET
    public String increment(
    ){
        counterResource.addCounter(context, 1);
        return "";
    }
    @GET
    @Path("/{n}")
    public String addN(@PathParam("n") int n) {
        counterResource.addCounter(context, n);
        return "";
    }

}

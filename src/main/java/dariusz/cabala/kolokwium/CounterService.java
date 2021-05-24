package dariusz.cabala.kolokwium;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

@Path("/counter")
public class CounterService {
    @Context
    ServletContext context;
    @GET
    public String increment(
    ){
        return "Hello increment";
    }
    @GET
    @Path("/{n}")
    public String addN(@PathParam("n") int n){
        return "Hello"+" "+n;
    }

}

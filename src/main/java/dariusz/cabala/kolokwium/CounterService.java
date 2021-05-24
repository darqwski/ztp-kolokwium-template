package dariusz.cabala.kolokwium;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

@Path("/counter")
public class CounterService {
    @Context
    ServletContext context;
    @Inject
    CounterResourceInterface counterResource;
    @GET
    public String counter(
    ){
        try {
            return ""+counterResource.counter();
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

}

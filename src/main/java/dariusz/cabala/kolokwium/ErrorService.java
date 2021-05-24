package dariusz.cabala.kolokwium;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

@Path("/error")
public class ErrorService {
    @Context
    ServletContext context;
    @Inject
    CounterResourceInterface counterResource;
    @GET
    public String increment(
    ){
        try {
            return ""+counterResource.error();
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

}

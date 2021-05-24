package dariusz.cabala.kolokwium;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/stop")
public class StopService {
    @Context
    ServletContext context;
    @Inject
    CounterResourceInterface counterResource;
    @GET
    public String increment(
    ){
        counterResource.stop(context);
        return "Hello increment";
    }

}

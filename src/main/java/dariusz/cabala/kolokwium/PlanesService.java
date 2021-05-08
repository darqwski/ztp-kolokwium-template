package dariusz.cabala.kolokwium;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.HashMap;

@Path("/planes")
public class PlanesService {
    @Context
    ServletContext context;

    //Poniższe zmienne Context'owe nie są używane, jednak zostają ponieważ mogą się przydać
    @Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;
    @Inject
    PlanesResourceInterface planesResourceInterface;

    @GET
    public String getPlanes(){
        HashMap<String, Plane> planes = planesResourceInterface.getPlanes(context);
        return new Gson().toJson(planes);
    }

    @POST
    public String addPlane(
            @FormParam("name") String name,
            @FormParam("longitude") double longitude,
            @FormParam("latitude") double latitude,
            @FormParam("capacity") int capacity
    ){
        try{
            planesResourceInterface.addPlane(context, name, longitude, latitude,capacity);
            return buildMessage("Plane has been added correctly");

        }catch (Exception e){
            e.printStackTrace();
            return buildMessage("Plane has not been, something goes wrong");

        }
    }
    @PUT
    @Path("/{name}")
    public String updatePlane(
            @PathParam("name") String name,
            @FormParam("longitude") double longitude,
            @FormParam("latitude") double latitude,
            @FormParam("capacity") int capacity
    ){
        HashMap<String, Plane> planes = planesResourceInterface.getPlanes(context);
        if(name == null){
            return buildMessage("Provide plane name");
        }
        if(planes.get(name) == null){
            return buildMessage("No plane");
        }
        boolean success = planesResourceInterface.updatePlane(context, name, longitude, latitude,capacity);
        if(success){
            return buildMessage("Plane has updated added correctly");

        } else {
            return buildMessage("Plane has not been updated correctly, Something goes wrong");
        }
    }
    @DELETE
    @Path("/{name}")
    public String deletePlane(@PathParam("name") String planeName){
        boolean result = planesResourceInterface.deletePlane(context,planeName);
        if(result){
            return buildMessage("Plane has been deleted correctly");

        }
        return buildMessage("Plane has not been deleted correctly, something goes wrong or plane does not exist");
    }

    public static String buildMessage(String message){
        HashMap<String, String> hashMap= new HashMap<>();
        hashMap.put("message",message);
        return new Gson().toJson(hashMap);
    }
}

package dariusz.cabala.kolokwium;

import javax.servlet.ServletContext;
import java.util.HashMap;

public class PlanesResourceImpl implements PlanesResourceInterface{
    @Override
    public HashMap<String, Plane> getPlanes(ServletContext context) {
        return (HashMap<String, Plane>)context.getAttribute("planes");
    }

    @Override
    public boolean deletePlane(ServletContext context, String planeName) {
        HashMap<String, Plane> planes = (HashMap<String, Plane>)context.getAttribute("planes");
        if(planes.get(planeName)!= null){
            planes.remove(planeName);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePlane(ServletContext context, String planeName, double longitude, double latitude, int capacity) {
        HashMap<String, Plane> planes = getPlanes(context);
        try{
            //planeName i plane == null, jest łapane wyżej
            Plane plane = planes.get(planeName);
            plane.setLatitude(latitude);
            plane.setLongitude(longitude);
            plane.setCapacity(capacity);
            planes.put(planeName, plane);
            context.setAttribute("planes",planes);
            return true;

        } catch (Exception e ){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addPlane(ServletContext context, String planeName, double longitude, double latitude, int capacity) {
        try{
            HashMap<String, Plane> planes = (HashMap<String, Plane>)context.getAttribute("planes");
            Plane plane = new Plane(planeName, latitude, longitude, capacity);
            planes.put(planeName, plane);
            context.setAttribute("planes",planes);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

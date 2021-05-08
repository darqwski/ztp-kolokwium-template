package dariusz.cabala.kolokwium;

import javax.servlet.ServletContext;
import java.util.HashMap;

public interface PlanesResourceInterface {
    HashMap<String, Plane> getPlanes(ServletContext context);
    boolean deletePlane(ServletContext context, String planeName);
    boolean updatePlane(ServletContext context, String planeName, double longitude, double latitude, int capacity);
    boolean addPlane(ServletContext context, String planeName, double longitude, double latitude, int capacity);
}

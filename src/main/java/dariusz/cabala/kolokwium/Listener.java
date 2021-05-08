package dariusz.cabala.kolokwium;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public Listener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        HashMap<String, Plane> planes = new HashMap<>();
        for(int i=0;i< 10;i++){
            double longitude = Math.random()*360 - 180;
            double latitude = Math.random()*360 - 180;
            int capacity = (int)Math.round(Math.random()*10);
            String name = "Plane "+i;
            planes.put(
                    name,
                    new Plane(
                            name,
                            latitude,
                            longitude,
                            capacity
                    )
            );
        }
        sce.getServletContext().setAttribute("planes",planes);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}

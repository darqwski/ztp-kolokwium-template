package dariusz.cabala.kolokwium;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class KolokwiumApplication extends Application {

    public static int counter = 0;
    public static int error = 0;
    public static boolean isStarted = false;
    //Klasy są rejestrowane za pomocą builder'a
    //Nie trzeba ich dodawać za pomocą getClasses lub getSingletons
}
package dariusz.cabala.kolokwium;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class KolokwiumApplication extends Application {
    //Klasy są rejestrowane za pomocą builder'a
    //Nie trzeba ich dodawać za pomocą getClasses lub getSingletons
}
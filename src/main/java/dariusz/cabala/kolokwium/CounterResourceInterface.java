package dariusz.cabala.kolokwium;

import javax.servlet.ServletContext;

public interface CounterResourceInterface {
    public int counter(ServletContext context);
    public int error(ServletContext context);
    String addCounter(ServletContext context,int n);
    public void incrementError(ServletContext context);
    public void start(ServletContext context);
    public void stop(ServletContext context);
}

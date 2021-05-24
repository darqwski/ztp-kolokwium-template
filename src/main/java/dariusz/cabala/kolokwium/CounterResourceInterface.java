package dariusz.cabala.kolokwium;

import javax.servlet.ServletContext;

public interface CounterResourceInterface {
    public int counter(ServletContext context);
    public int error(ServletContext context);
    public void addCounter(ServletContext context,int n);
    public void incrementError(ServletContext context);
    public void start(ServletContext context);
    public void stop(ServletContext context);
}

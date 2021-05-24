package dariusz.cabala.kolokwium;

import javax.servlet.ServletContext;

public interface CounterResourceInterface {
    public int counter();
    public int error();
    String addCounter(int n);
    public void incrementError();
    public void start();
    public void stop();
}

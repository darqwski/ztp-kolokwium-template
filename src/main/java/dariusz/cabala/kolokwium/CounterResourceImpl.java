package dariusz.cabala.kolokwium;

import javax.servlet.ServletContext;
import java.util.HashMap;

public class CounterResourceImpl implements CounterResourceInterface{

    @Override
    public int counter(ServletContext context) {
        return (int)context.getAttribute("counter");
    }

    @Override
    public int error(ServletContext context) {
        return (int)context.getAttribute("error");
    }

    @Override
    public void addCounter(ServletContext context, int n) {
        int currentCounter = counter(context);
        boolean isStarted =  (boolean)context.getAttribute("isStarted");

        if(isStarted){
            context.setAttribute("counter", currentCounter+n);
        } else {
            incrementError(context);
        }
    }

    @Override
    public void incrementError(ServletContext context) {
        int errorCounter = (int)context.getAttribute("error");
        context.setAttribute("error", errorCounter+1);
    }

    @Override
    public void start(ServletContext context) {
        boolean isStarted =  (boolean)context.getAttribute("isStarted");
        if(isStarted){
            incrementError(context);
        } else {
            context.setAttribute("isStarted", true);
        }
    }

    @Override
    public void stop(ServletContext context) {
        boolean isStarted =  (boolean)context.getAttribute("isStarted");
        if(isStarted){
            context.setAttribute("isStarted", false);
        } else {
            incrementError(context);
        }
    }
}

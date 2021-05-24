package dariusz.cabala.kolokwium;

import javax.servlet.ServletContext;
import java.util.HashMap;

import static dariusz.cabala.kolokwium.KolokwiumApplication.*;

public class CounterResourceImpl implements CounterResourceInterface{

    @Override
    public int counter() {
        return counter;
    }

    @Override
    public int error() {
        return error;
    }

    @Override
    public String addCounter(int n) {

        if(isStarted){
            counter+=n;
            return "Counter has been incremented";
        } else {
            incrementError();
            return "CounterService is not started";
        }
    }

    @Override
    public void incrementError() {
        error+=1;
    }

    @Override
    public void start() {
        if(isStarted){
            incrementError();
        } else {
            isStarted=true;
        }
    }

    @Override
    public void stop() {
        if(isStarted){
            isStarted=false;
        } else {
            incrementError();
        }
    }
}

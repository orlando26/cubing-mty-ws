package com.cubingmty.ws.exceptions;

public class TimeLimitException  extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TimeLimitException(String msg){
        super(msg);
    }

    public TimeLimitException(){
        super("Time limit is 3599999 ms");
    }

}
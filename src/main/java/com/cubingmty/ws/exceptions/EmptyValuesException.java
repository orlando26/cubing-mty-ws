package com.cubingmty.ws.exceptions;

public class EmptyValuesException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public EmptyValuesException(String msg){
        super(msg);
    }

    public EmptyValuesException(){
        super("Por favor llena todos los campos v:!");
    }

}
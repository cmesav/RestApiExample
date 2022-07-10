package com.restapiexample.dummy.exceptions;

public class StatusCode extends AssertionError{

    public StatusCode(String message, Throwable cause){
        super(message, cause);
    }
}

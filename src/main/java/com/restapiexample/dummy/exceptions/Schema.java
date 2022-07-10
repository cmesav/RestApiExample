package com.restapiexample.dummy.exceptions;

public class Schema extends AssertionError{

    public Schema(String message, Throwable cause){
        super(message, cause);
    }
}

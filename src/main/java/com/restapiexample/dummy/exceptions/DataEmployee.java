package com.restapiexample.dummy.exceptions;

public class DataEmployee extends AssertionError{

    public DataEmployee(String message, Throwable cause){
            super(message, cause);
        }
    }
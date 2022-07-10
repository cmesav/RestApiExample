package com.restapiexample.dummy.exceptions;

public class Message extends AssertionError{

    public Message(String message, Throwable cause){
        super(message, cause);
    }
}
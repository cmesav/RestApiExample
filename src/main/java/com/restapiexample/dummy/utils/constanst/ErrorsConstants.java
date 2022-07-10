package com.restapiexample.dummy.utils.constanst;

public class ErrorsConstants {

    public static final String STATUS_ERROR = "The status code is not equal to expected";
    public static final String ERROR_SCHEMA = "The response schema is not equal than expected";
    public static final String ERROR_MESSAGE = "The response message is different than expected";
    public static final String ERROR_DATA = "The returned data is different than expected";


    private ErrorsConstants() {
        throw new IllegalStateException("Utility class");
    }
}

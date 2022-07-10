package com.restapiexample.dummy.utils;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    private Headers() {
    }

    public static Map<String, Object> build   () {

        Map<String, Object> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Cache-Control","no-cache");
        headers.put("Host","dummy.restapiexample.com");
        headers.put("Connection","keep-alive");
        headers.put("Content-Type","application/json");

        return headers;
    }
}

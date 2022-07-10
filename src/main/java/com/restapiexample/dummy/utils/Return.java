package com.restapiexample.dummy.utils;

public class Return {

    private Return() {
    }

    public static String path(String path) {
        switch (path) {
            case "Get":
                return "src/test/resources/schemas/employees.json";
            case "Post":
                return "src/test/resources/schemas/create.json";
            case "GetEmployee":
                return "src/test/resources/schemas/particular_employee.json";
            default:
                break;
        }
        return "";
    }
}

package com.restapiexample.dummy.setup.datadefinitions;


import com.restapiexample.dummy.models.Employee;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class Modeldefinitions {

    @DataTableType
    public Employee employeeEntry(Map<String, String> entry) {
        return new Employee(
                Integer.parseInt(entry.get("id")),
                entry.get("employee_name"),
                Integer.parseInt(entry.get("employee_salary")),
                Integer.parseInt(entry.get("employee_age")),
                entry.get("profile_image")
        );

    }
}

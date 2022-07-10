package com.restapiexample.dummy.utils;

import com.github.javafaker.Faker;
import com.restapiexample.dummy.models.Data;

import java.util.Locale;

public class With {

    private With() {
    }

    private static final Faker FAKER = new Faker(new Locale("es"));

    public static Data theInfo() {
        return new Data(
                FAKER.name().fullName(),
                FAKER.bothify("######"),
                FAKER.bothify("##")
        );
    }
}


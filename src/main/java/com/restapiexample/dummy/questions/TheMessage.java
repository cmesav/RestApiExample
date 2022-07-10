package com.restapiexample.dummy.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().jsonPath().get("message").toString();
    }

    public static TheMessage is(){
        return new TheMessage();
    }
}

package com.restapiexample.dummy.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

import java.util.logging.Logger;

public class Del implements Task {

    private final String path;
    private final int id;

    public Del(String path, int id) {
        this.path = path;
        this.id = id;
    }

    @Step("{0} delete the employeed with {id}")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Logger logger = Logger.getLogger(Del.class.getName());

        actor.attemptsTo(Delete.from(path).with(
                requestSpecification -> requestSpecification.pathParam("id", id))
        );

        logger.info("Response Body delete Employee with id");
        SerenityRest.lastResponse().prettyPrint();
    }

    public static Del employee(String path, int id) {
        return Tasks.instrumented(Del.class, path, id);
    }
}

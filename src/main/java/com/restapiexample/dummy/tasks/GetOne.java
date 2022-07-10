package com.restapiexample.dummy.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import java.util.logging.Logger;

public class GetOne implements Task {

    private final String path;
    private final int id;

    public GetOne(String path, int id) {
        this.path = path;
        this.id = id;
    }

    @Step("{0} obtains the information for the employee")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Logger logger = Logger.getLogger(GetOne.class.getName());

        actor.attemptsTo(Get.resource(path).with(
                requestSpecification -> requestSpecification.pathParam("id", id))
        );

        logger.info("Response Body Get Employee with id");
        SerenityRest.lastResponse().prettyPrint();

    }

    public static GetOne employee(String path, int id) {
        return Tasks.instrumented(GetOne.class, path, id);
    }
}

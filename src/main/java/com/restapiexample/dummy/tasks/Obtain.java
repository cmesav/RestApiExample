package com.restapiexample.dummy.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import java.util.logging.Logger;

public class Obtain implements Task {

    private final String path;

    public Obtain(String path) {
        this.path = path;
    }

    @Step("{0} Gets the employee list")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Logger logger = Logger.getLogger(Obtain.class.getName());

        actor.attemptsTo(Get.resource(path));

        logger.info("Response Body Get Employees");
        SerenityRest.lastResponse().prettyPrint();
    }

    public static Obtain theEmployees(String path) {
        return Tasks.instrumented(Obtain.class, path);
    }
}

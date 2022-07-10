package com.restapiexample.dummy.tasks;

import com.restapiexample.dummy.models.Data;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Create implements Task {

    private final Data data;
    private final String path;

    public Create(Data data, String path) {
        this.data = data;
        this.path = path;
    }

    @Step("{0} create a new employee")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Logger logger = Logger.getLogger(Obtain.class.getName());

        actor.attemptsTo(Post.to(path).with(requestSpecification -> requestSpecification
                .headers(heads()).body(data).relaxedHTTPSValidation()));

        logger.info("Create employee response body");
        SerenityRest.lastResponse().prettyPrint();

    }

    public static Create employee(Data data, String path){
        return Tasks.instrumented(Create.class, data, path);
    }

    private static Map<String, Object> heads() {

        Map<String, Object> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Cache-Control","no-cache");
        headers.put("Host","dummy.restapiexample.com");
        headers.put("Connection","keep-alive");
        headers.put("Content-Type","application/json");

        return headers;
    }
}

package com.restapiexample.dummy.stepdefinitions;

import com.restapiexample.dummy.exceptions.Message;
import com.restapiexample.dummy.exceptions.Schema;
import com.restapiexample.dummy.exceptions.StatusCode;
import com.restapiexample.dummy.models.Employee;
import com.restapiexample.dummy.questions.TheMessage;
import com.restapiexample.dummy.questions.TheResponseCode;
import com.restapiexample.dummy.tasks.Create;
import com.restapiexample.dummy.tasks.Del;
import com.restapiexample.dummy.tasks.GetOne;
import com.restapiexample.dummy.tasks.Obtain;
import com.restapiexample.dummy.utils.Return;
import com.restapiexample.dummy.utils.With;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.io.File;

import static com.restapiexample.dummy.utils.constanst.ErrorsConstants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class RestApiExampleStepDefinitions {
    @Given("Im conected to the service")
    public void imConectedToTheService() {
        setTheStage(new OnlineCast());
        theActorCalled("cmesa").whoCan(
                CallAnApi.at("http://dummy.restapiexample.com/api/v1")
        );
    }

    @When("I use the get with path {string}")
    public void iUseTheGetWithPath(String path) {
        theActorInTheSpotlight().attemptsTo(Obtain.theEmployees(path));
    }

    @Then("I see the status code {int}")
    public void iSeeTheStatusCode(Integer statusCode) {
        theActorInTheSpotlight().should(seeThat(TheResponseCode.is(), equalTo(statusCode))
                .orComplainWith(StatusCode.class, STATUS_ERROR));
    }

    @And("the correct schema for the method {string} response")
    public void theCorrectSchemaForTheResponse(String method) {
        theActorInTheSpotlight().should(
                seeThatResponse(response -> response.body(JsonSchemaValidator
                        .matchesJsonSchema(new File(Return.path(method)))))
                        .orComplainWith(Schema.class, ERROR_SCHEMA)
        );
    }

    @When("I send the request wit path {string}")
    public void iSendTheRequestWitPath(String path) {
        theActorInTheSpotlight().attemptsTo(Create.employee(With.theInfo(), path));
    }

    @And("the message {string}")
    public void theMessage(String message) {
        theActorInTheSpotlight().should(seeThat(TheMessage.is(), equalTo(message))
                .orComplainWith(Message.class, ERROR_MESSAGE));
    }

    @When("I use the path {string} to consult employee id {int}")
    public void iUseThePathToConsultEmployeeId(String path, int id) {
        theActorInTheSpotlight().attemptsTo(GetOne.employee(path, id));
    }

    @And("the correct employee info")
    public void theCorrectEmployeeInfo(Employee data) {
        theActorInTheSpotlight().should(seeThatResponse("all employee data is ok",
                response -> response.body("data.employee_name", equalTo(data.getEmployee_name()))
                        .body("data.id", equalTo(data.getId()))
                        .body("data.employee_salary", equalTo(data.getEmployee_salary()))
                        .body("data.employee_age", equalTo(data.getEmployee_age())))
                );
    }

    @When("I send the petition with path {string} an id {int}")
    public void iSendThePetitionWithPathAnId(String path, int id) {
        theActorInTheSpotlight().attemptsTo(Del.employee(path,id));
    }
}

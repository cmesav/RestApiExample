package com.restapiexample.dummy.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/rest_api_example.feature",
        glue = {"com.restapiexample.dummy.setup","com.restapiexample.dummy.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE, tags = "")
public class RestApiExampleRunners {
}

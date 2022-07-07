package helpers;

import baseEntities.BaseApiTest;
import core.Endpoints;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.TestRuns;
import org.apache.http.HttpStatus;
import org.openqa.selenium.json.Json;
import org.testng.Assert;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class TestRunsAndResultsHelper {

    private Response response;

    private RequestSpecification requestSpecification;


    @Given("I Set GET posts api endpoint with run id {int}")
    public void givenTestRunNFERequest(int runId) {
        requestSpecification = RestAssured.given().pathParams("run_id", runId);
    }

    @When("Send GET HTTP request")
    public void whenTestRunNFERequest() {
        response = requestSpecification.when().get(Endpoints.GET_RUN);
    }

    @Then("I receive valid HTTP response status code {int} for \"GET.\"")
    public void thenTestRunNFERequest(Integer statusCode) {
        int actualResponseCode = response.then().extract().statusCode();
        Assert.assertEquals(statusCode, actualResponseCode);
    }

    @And("Response BODY \"GET\" is non-empty")
    public void getResponseBody() {
        String actualResponseBody = response.then().log().body().extract().as((String) TestRuns.class);
        Assert.assertNotEquals(actualResponseBody, null);
    }


}



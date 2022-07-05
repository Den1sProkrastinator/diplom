package helpers;

import baseEntities.BaseApiTest;
import core.Endpoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.TestRuns;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class TestRunsAndResultsHelper {
    @Given("I Set GET posts api endpoint {int}")
    @When("Send GET HTTP request")
    @Then("I receive valid HTTP response code 200 for \"GET.\"")
    @And("Response BODY \"GET\" is non-empty")
    public TestRuns iSetGETPostsApiEndpoint(int runId) {
        return given()
                .pathParams("run_id", runId)
                .get(Endpoints.GET_RUN)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(TestRuns.class);
    }

}

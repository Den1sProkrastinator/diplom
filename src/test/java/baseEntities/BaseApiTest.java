package baseEntities;

import core.ReadProperties;
import helpers.TestRunsAndResultsHelper;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    public TestRunsAndResultsHelper testRunAndResultHelper;

    @BeforeTest
    @Given("I set sample REST API url and I Set HEADER param request content type as \"json\"")
    public void iSetSampleRESTAPIUrl() {
        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());
        testRunAndResultHelper = new TestRunsAndResultsHelper();

    }
}

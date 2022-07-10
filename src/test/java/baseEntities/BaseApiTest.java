package baseEntities;

import core.ReadProperties;
import helpers.ProjectHelper;
import helpers.TestRunsAndResultsHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    public TestRunsAndResultsHelper testRunsAndResultsHelper;
    public ProjectHelper projectHelper;


    @BeforeTest
    public void setupEnv() {
        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());


        testRunsAndResultsHelper = new TestRunsAndResultsHelper();
        projectHelper = new ProjectHelper();

    }
}
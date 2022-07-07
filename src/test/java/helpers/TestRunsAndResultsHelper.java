package helpers;

import core.Endpoints;
import models.TestRuns;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class TestRunsAndResultsHelper {


    public TestRuns getProject(int testRun) {
        return given()
                .pathParam("run_id",1)
                .get(Endpoints.GET_RUN)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(TestRuns.class);
    }



}



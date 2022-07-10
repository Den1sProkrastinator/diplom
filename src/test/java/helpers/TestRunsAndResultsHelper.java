package helpers;

import core.Endpoints;
import models.Project;
import models.TestRuns;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRunsAndResultsHelper {


    public TestRuns getProject(int testRunID) {
        return given()
                .pathParam("run_id", testRunID)
                .get(Endpoints.GET_RUN)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(TestRuns.class);
    }

    public TestRuns getProjects(int projectID) {
        return given()
                .pathParams("project_id", projectID)
                .get(Endpoints.GET_RUNS)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(TestRuns.class);
    }

    public TestRuns addRun(int projectID, Map jsonMap) {

        return given()
                .pathParams("project_id", projectID)
                .body(jsonMap)
                .post(Endpoints.ADD_RUN)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(TestRuns.class);
    }

    public void deleteRun(int testRunID) {

        given()
                .when()
                .pathParams("run_id", testRunID)
                .post(Endpoints.DELETE_RUN)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }


}



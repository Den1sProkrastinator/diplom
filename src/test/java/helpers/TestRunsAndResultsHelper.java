package helpers;

import core.Endpoints;
import models.TestRuns;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRunsAndResultsHelper {


    public TestRuns getProject(int testRun) {
        return given()
                .pathParam("run_id",testRun)
                .get(Endpoints.GET_RUN)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(TestRuns.class);
    }

    public TestRuns getProjects(int projectID){
        return  given()
                .pathParams("project_id",2)
                .get(Endpoints.GET_RUNS)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(TestRuns.class);
    }

    public TestRuns addProject(int projectID,Map jsonMap){

       return   given()
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




}



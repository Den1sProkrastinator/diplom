package helpers;


import core.Endpoints;
import models.TestRuns;
import org.apache.http.HttpStatus;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestRunsAndResultsHelper {

//
//    public TestRuns getRun(int testRunID, int httpSatus) {
//        return given()
//                .pathParam("run_id", testRunID)
//                .get(Endpoints.GET_RUN)
//                .then()
//                .assertThat()
//                .statusCode(httpSatus)
//                .log().body()
//                .extract()
//                .as(TestRuns.class);
//    }
//
//    public TestRuns getRuns(int projectID, int httpStatus) {
//        return given()
//                .pathParams("project_id", projectID)
//                .get(Endpoints.GET_RUNS)
//                .then()
//                .assertThat()
//                .statusCode(httpStatus)
//                .log().body()
//                .extract()
//                .as(TestRuns.class);
//    }
//
//    public TestRuns addRun(int projectID, Map jsonMap, int httpStatus) {
//
//        return given()
//                .pathParams("project_id", projectID)
//                .body(jsonMap)
//                .when()
//                .post(Endpoints.ADD_RUN)
//                .then()
//                .assertThat()
//                .statusCode(httpStatus)
//                .log().body()
//                .extract()
//                .as(TestRuns.class);
//
//    }
//
//
//    public TestRuns getExactProjectAsObjects(int runID) {
//        return given()
//                .pathParams("run_id", runID)
//                .get(Endpoints.GET_RUN)
//                .then()
//                .extract()
//                .as(TestRuns.class);
//    }
//
//    public void deleteRun(int testRunID) {
//
//        given()
//                .when()
//                .pathParams("run_id", testRunID)
//                .post(Endpoints.DELETE_RUN)
//                .then()
//                .statusCode(HttpStatus.SC_OK)
//                .log().body();
//    }




}



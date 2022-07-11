package tests.api;


import baseEntities.BaseApiTest;
import core.ReadProperties;
import helpers.ProjectHelper;
import helpers.TestRunsAndResultsHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.TestRuns;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTest extends BaseApiTest {
    public int projectId;
    public int runID;

    @Test(priority = 3)
    public void getRun() {
        testRunsAndResultsHelper.getProject(runID);
    }

    @Test(priority = 4)
    public void getsRun() {
        testRunsAndResultsHelper.getProjects(projectId);
    }

    @Test(priority = 2)
    public void addRun() {
        TestRuns testRun = TestRuns.builder()
                .name("TestRun")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("name", testRun.getName());

        testRunsAndResultsHelper.addRun(20, jsonMap);
    }

    @Test(priority = 5)
    public void deleteRun() {
        testRunsAndResultsHelper.deleteRun(4);
    }

    @Test(priority = 1)
    public void addProject() {
        TestRuns milestone = TestRuns.builder()
                .name("TEEEEET")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", milestone.getName());
        projectId= projectHelper.addProject(jsonMap);

    }

    @Test
    public void addRun1() {
        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        testRunsAndResultsHelper = new TestRunsAndResultsHelper();
        projectHelper = new ProjectHelper();
        TestRuns testRun = TestRuns.builder()
                .name("TestRun")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("name", testRun.getName());

        given()

                .body(jsonMap)
                .post("index.php?/api/v2/add_run/20")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body();

    }
}

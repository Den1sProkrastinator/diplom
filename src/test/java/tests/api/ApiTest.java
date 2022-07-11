package tests.api;


import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import models.TestRuns;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTest extends BaseApiTest {
    public int projectId;
    public int runID;

    @Test(priority = 3, description = "Positive Get run test")
    public void getRun() {
        testRunsAndResultsHelper.getRun(runID, HttpStatus.SC_OK);
    }

    @Test(priority = 4, description = "Positive Get Runs test")
    public void getRuns() {
        testRunsAndResultsHelper.getRuns(projectId, HttpStatus.SC_OK);
    }

    @Test(priority = 2, description = "Positive Add Run test")
    public void addRun() {
        TestRuns testRun = TestRuns.builder()
                .name("TestRun")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("name", testRun.getName());

        testRunsAndResultsHelper.addRun(projectId, jsonMap, HttpStatus.SC_OK);

    }

    @Test(priority = 5, description = "Positive Delete run test")
    public void deleteRun() {
        testRunsAndResultsHelper.deleteRun(runID);
    }

    @Test(priority = 1, description = "Positive Add project test")
    @Description("Создание проекта с Lombok  и Builder ")
    public void addProject() {
        TestRuns milestone = TestRuns.builder()
                .name("TEEEEET")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", milestone.getName());
        projectId = projectHelper.addProject(jsonMap, HttpStatus.SC_OK);

    }


}

package tests.api;


import baseEntities.BaseApiTest;

import io.qameta.allure.Description;

import models.TestRuns;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTest extends BaseApiTest {
    public int projectId;
    public int runID;

    @Test(priority = 3,description = "Get run")
    public void getRun() {
        testRunsAndResultsHelper.getRun(runID);
    }

    @Test(priority = 4,description = "Get Runs")
    public void getRuns() {
        testRunsAndResultsHelper.getRuns(projectId);
    }

    @Test(priority = 2,description = "Add Run")
    public void addRun() {
        TestRuns testRun = TestRuns.builder()
                .name("TestRun")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("name", testRun.getName());

        testRunsAndResultsHelper.addRun(20, jsonMap);
    }

    @Test(priority = 5,description = "Delete run")
    public void deleteRun() {
        testRunsAndResultsHelper.deleteRun(4);
    }

    @Test(priority = 1,description = "Add project")
//    @Description("Создание проекта с помощью Builder и Lombok ")
    public void addProject() {
        TestRuns milestone = TestRuns.builder()
                .name("TEEEEET")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", milestone.getName());
        projectId= projectHelper.addProject(jsonMap);

    }


}

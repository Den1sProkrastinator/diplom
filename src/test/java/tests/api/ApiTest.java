package tests.api;


import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import models.Project;
import models.TestRuns;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Epic("Diploma API tests")

public class ApiTest extends BaseApiTest {
    public int projectId;
    public int runID;
    public String runName;


    //NFE test
    @Test(priority = 1, description = "NFE Add project test")
    @Feature("NFE tests")
    @Story("NFE test")
    @Description("Create project by Lombok and Builder, expected status code - 200 ")
    public void addProjectNFETest() {
        TestRuns milestone = TestRuns.builder()
                .name("Test project")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", milestone.getName());
        projectId = projectHelper.addProject(jsonMap, HttpStatus.SC_OK);

    }

    @Test(priority = 2, description = "NFE Add Run test")
    @Feature("NFE tests")
    @Story("NFE add run test")
    @Description("Create test run with Builder and Lombok , expected status code 200")
    public void addTestRunNFETest() {
        TestRuns testRun = TestRuns.builder()
                .name(runName)
                .build();
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("name", testRun.getName());

        testRunsAndResultsHelper.addRun(projectId, jsonMap, HttpStatus.SC_OK);

    }

    @Test(priority = 3, description = "NFE Get run test")
    @Feature("NFE tests")
    @Story("NFE  get test run test")
    @Description("Get test run, expected status code - 200 ")
    public void getTestRunNFETest() {
        testRunsAndResultsHelper.getRun(runID, HttpStatus.SC_OK);
    }

    @Test(priority = 4, description = "NFE Get Runs test")
    @Feature("NFE tests")
    @Story("NFE get runs test")
    @Description("Get test runs , expected status cod - 200 ")
    public void getTestRunsNFETest() {
        testRunsAndResultsHelper.getRuns(projectId, HttpStatus.SC_OK);
    }


    @Test(description = "Get exact project as objects test")
    @Feature("NFE tests")
    @Story("NFE get exact project as objects test")
    @Description("Get exact test run as object ")
    public void getExactTestRunAsObjectsTest() {
        Response response = (Response) testRunsAndResultsHelper.getExactProjectAsObjects(runID);

        TestRuns actualRun = new Gson().fromJson(response.getBody().asString(), TestRuns.class);

        Assert.assertEquals(actualRun.getName(), runName);


    }

    @Test(priority = 5, description = "NFE Delete run test")
    @Feature("NFE tests")
    @Story("NFE delete run test")
    @Description("Delete test run, expected status cod - 200")
    public void deleteRunNFETest() {
        testRunsAndResultsHelper.deleteRun(runID);
    }


    //AEF tests
    @Test(description = "AEF get project test")
    @Feature("AEF tests")
    @Story("AEF  get test")
    @Description("Get project with  don't exist run id, expected status -400")
    public void getTestRunAEFTest() {
        testRunsAndResultsHelper.getRun(runID, HttpStatus.SC_BAD_REQUEST);
    }

    @Test(description = "AEF add project test ")
    @Feature("AEF tests")
    @Story("AEF add test")
    @Description("Add project with uncorrected field, expected status - 400")
    public void addTestRunTest(){
        TestRuns testRun = TestRuns.builder()
                .name(runName)
                .build();
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("uncorrectedField", testRun.getName());

        testRunsAndResultsHelper.addRun(projectId, jsonMap, HttpStatus.SC_BAD_REQUEST);

    }

}

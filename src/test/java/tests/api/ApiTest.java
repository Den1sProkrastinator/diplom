package tests.api;


import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import core.ReadProperties;
import helpers.ProjectHelper;
import helpers.TestRunsAndResultsHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Project;
import models.Suite;
import models.TestRuns;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Epic("Diploma API tests")

public class ApiTest extends BaseApiTest {
    public int projectId;
    public int suiteID;

    public String suiteName = "Test Name";


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

    @Test(priority = 2, description = "NFE Add Suite test")
    @Feature("NFE tests")
    @Story("NFE add suite test")
    @Description("Create suite with Builder and Lombok , expected status code 200")
    public void addSuite() {
        Suite suite = Suite.builder()
                .name(suiteName)
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", suite.getName());

        suiteID = suiteHelper.addSuite(projectId, jsonMap, HttpStatus.SC_OK);

    }


    @Test(priority = 3, description = "NFE Get Suite test")
    @Feature("NFE tests")
    @Story("NFE  get Suite test")
    @Description("Get Suite, expected status code - 200 ")
    public void getSuiteNFETest() {
        suiteHelper.getSuite(suiteID, HttpStatus.SC_OK);
    }

    @Test(priority = 4, description = "NFE Get Suites test")
    @Feature("NFE tests")
    @Story("NFE get Suites test")
    @Description("Get Suites , expected status cod - 200 ")
    public void getSuitesNFETest() {
        suiteHelper.getSuites(projectId, HttpStatus.SC_OK);
    }


    @Test(priority = 5, description = "NFE Comparison actual and name")
    @Feature("NFE tests")
    @Story("NFE get  Suite name")
    @Description(" Comparison of current ")
    public void getSuiteName() {
       suiteHelper.getSuiteName(suiteID,suiteName);
    }

    //AEF tests
    @Test(priority = 6, description = "AEF get project test")
    @Feature("AEF tests")
    @Story("AEF  get test")
    @Description("Get project with  don't exist run id, expected status -400")
    public void getSuiteAEFTest() {
        suiteHelper.getSuite(50, HttpStatus.SC_BAD_REQUEST);
    }

    @Test(priority = 7, description = "AEF add project test ")
    @Feature("AEF tests")
    @Story("AEF add test")
    @Description("Add project with uncorrected field, expected status - 400")
    public void addSuiteAEFTest() {
        Suite suite = Suite.builder()
                .name(suiteName)
                .build();
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("uncorrectedField", suite.getName());

        suiteHelper.addSuite(projectId, jsonMap, HttpStatus.SC_BAD_REQUEST);

    }

    @Test(priority = 8, description = "NFE Delete Suite test")
    @Feature("NFE tests")
    @Story("NFE delete Suite test")
    @Description("Delete Suite, expected status cod - 200")
    public void deleteSuite() {
        suiteHelper.deleteSuite(suiteID);
    }


    @Test(priority = 9)
    public void deleteProject() {
        projectHelper.deleteProject(projectId);
    }


}

package tests.api;


import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.Project;
import models.Suite;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


@Epic("Diploma API tests")

public class ApiTest extends BaseApiTest {
    public int projectId;
    public int suiteID;

    public String suiteName = "Test Name";

    //NFE test
    @Test(description = "NFE Add project test", groups = "main tests")
    @Feature("NFE tests")
    @Story("Create project")
    @Description("Create project by Lombok and Builder, expected status code - 200 ")

    public void addProjectNFETest() {
        Project project = Project.builder()
                .name(suiteName)
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", project.getName());
        projectId = projectHelper.addProject(jsonMap, HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "addProjectNFETest", description = "NFE Add Suite test", groups = "main tests")
    @Feature("NFE tests")
    @Story("Create suite")
    @Description("Create suite with Builder and Lombok , expected status code 200")
    public void addSuite() {
        Suite suite = Suite.builder()
                .name(suiteName)
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", suite.getName());
        suiteID = suiteHelper.addSuite(projectId, jsonMap, HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "addSuite", description = "NFE Get Suite test", groups = "main tests", threadPoolSize = 3)
    @Feature("NFE tests")
    @Story("Get suite")
    @Description("Get Suite, expected status code - 200 ")
    public void getSuiteNFETest() {
        suiteHelper.getSuite(suiteID, HttpStatus.SC_OK);
    }


    @Test(dependsOnMethods = "addSuite", description = "NFE Get Suites test", groups = "main tests", threadPoolSize = 3)
    @Feature("NFE tests")
    @Story("Get suites")
    @Description("Get Suites , expected status cod - 200 ")
    public void getSuitesNFETest() {
        suiteHelper.getSuites(projectId, HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "addSuite", description = "NFE Comparison actual suite name and adjusted suite name ", groups = "main tests", threadPoolSize = 3)
    @Feature("NFE tests")
    @Story("Comparison Suite names")
    @Description(" Comparison of current and comparable suite names ")
    public void getSuiteName() {
        String actualSuiteName = suiteHelper.getSuiteName(suiteID);
        Assert.assertEquals(actualSuiteName, suiteName);
    }


    //AEF tests
    @Test(dependsOnMethods = "addSuite", description = "AEF get project test", groups = "main tests", threadPoolSize = 3)
    @Feature("AEF tests")
    @Story("Get suite with fake suite ID")
    @Description("Get project with  don't exist run id, expected status -400")
    public void getSuiteAEFTest() {
        suiteHelper.getSuite(50, HttpStatus.SC_BAD_REQUEST);
    }


    @Test(dependsOnMethods = "addSuite", description = "AEF add project test ", groups = "main tests", threadPoolSize = 3, expectedExceptions = NullPointerException.class)
    @Feature("AEF tests")
    @Story("Try to create suite with fake field")
    @Description("Add project with uncorrected field, expected status - 400")
    public void addSuiteAEFTest() {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("incorrect field", "incorrect value");
        suiteHelper.addSuite(projectId, jsonMap, HttpStatus.SC_BAD_REQUEST);
    }


    @Test(description = "NFE Delete Suite test", dependsOnGroups = "main tests")
    @Feature("NFE tests")
    @Story("Delete Suite test")
    @Description("Delete Suite, expected status cod - 200")
    public void deleteSuiteTest() {
        suiteHelper.deleteSuite(suiteID);
    }


    @Test(description = "NFE Delete Project test", dependsOnMethods = "deleteSuite")
    @Feature("NFE tests")
    @Story("Delete Project test")
    @Description("Delete Project, expected status cod - 200")
    public void deleteProjectTest() {
        projectHelper.deleteProject(projectId);
    }


    @Test
    public void justForFailProject() {
        projectHelper.deleteProject(50);
    }


}

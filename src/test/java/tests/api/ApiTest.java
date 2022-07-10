package tests.api;

import baseEntities.BaseApiTest;
import models.TestRuns;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

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
        TestRuns milestone = TestRuns.builder()
                .name("TestRun")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("name", milestone.getName());

        testRunsAndResultsHelper.addRun(21, jsonMap);
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
}

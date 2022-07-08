package tests.api;

import baseEntities.BaseApiTest;
import models.TestRuns;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTest extends BaseApiTest {
    @Test
    public void get() {

        testRunsAndResultsHelper.getProject(2);


    }

    @Test
    public void gets() {
        testRunsAndResultsHelper.getProjects(2);
    }

    @Test
    public void add() {
        TestRuns milestone = TestRuns.builder()
                .name("DenisMilestoneAPI")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("name", milestone.getName());

        testRunsAndResultsHelper.addProject(2, jsonMap);
    }
}

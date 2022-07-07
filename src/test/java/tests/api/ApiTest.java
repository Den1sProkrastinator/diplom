package tests.api;

import baseEntities.BaseApiTest;
import org.testng.annotations.Test;

public class ApiTest extends BaseApiTest {
    @Test
    public void test(){

testRunsAndResultsHelper.getProject(1);
    }
}

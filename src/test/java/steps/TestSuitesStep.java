package steps;

import baseEntities.BaseStep;
import pages.AddTestSuitePage;
import pages.TestSuiteOverviewPage;

public class TestSuitesStep extends BaseStep {

    public AddTestSuitePage addTestSuite() {
        testSuite();
        return addTestSuitePage;
    }

    public void testSuite() {
        testSuitesPage.getAddTestSuiteButtonLocator().click();
    }

    public TestSuiteOverviewPage openTestSuite(String testSuiteName) {
        testSuitesPage.OpenTestSuiteByNameLocator(testSuiteName).click();
        return testSuiteOverviewPage;
    }
}

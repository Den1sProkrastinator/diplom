package steps;

import baseEntities.BaseStep;
import pages.TestSuitesPage;

public class ProjectOverviewStep extends BaseStep {
    public TestSuitesPage selectSuite() {
        testSuite();
        return testSuitesPage;
    }

    public void testSuite() {
        projectOverviewPage.getTestSuitesAndCasesButtonLocator().click();
    }
}

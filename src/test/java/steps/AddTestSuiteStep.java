package steps;

import baseEntities.BaseStep;
import pages.ProjectOverviewPage;

public class AddTestSuiteStep extends BaseStep {
    public ProjectOverviewPage createTestSuite(String testSuiteName, String testSuiteDescription)  {
        fillTestSuite(testSuiteName, testSuiteDescription);
        return new ProjectOverviewPage();
    }

    public void fillTestSuite(String testSuiteName, String testSuiteDescription)  {
        addTestSuitePage.getNameTestSuiteInputLocator().setValue(testSuiteName);
        addTestSuitePage.getDescriptionTestSuiteInputLocator().setValue(testSuiteDescription);
        addTestSuitePage.getAddTestSuiteButtonLocator().click();
    }


}

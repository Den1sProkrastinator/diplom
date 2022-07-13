package steps;

import baseEntities.BaseStep;
import com.codeborne.selenide.SelenideElement;
import pages.TestSuiteOverviewPage;

public class EditTestSuiteStep extends BaseStep {

    public TestSuiteOverviewPage editTestSuite(String testSuiteName, String testSuiteDescription) {
        fillTestSuite(testSuiteName, testSuiteDescription);
        return testSuiteOverviewPage;
    }

    public TestSuiteOverviewPage deleteTestSuite(String testSuite) {
        editTestSuitePage.DeleteTestSuiteButtonLocator(testSuite).click();
        editTestSuitePage.getCheckBoxButtonLocator().click();
        editTestSuitePage.getConfirmationOkButtonLocator().click();
        return testSuiteOverviewPage;
    }

    public void fillTestSuite(String testSuiteName, String testSuiteDescription) {
        editTestSuitePage.getDescriptionTestSuiteLocator().click();
        editTestSuitePage.getNameTestSuiteInputLocator().setValue(testSuiteName);
        editTestSuitePage.getDescriptionTestSuiteLocator().setValue(testSuiteDescription);
        editTestSuitePage.getSaveTestSuiteButtonLocator().click();
    }

    public SelenideElement getTestSuiteName() {
        return editTestSuitePage.getNameTestSuiteInputLocator();
    }

    public SelenideElement getTestSuiteDescription() {
        return editTestSuitePage.getDescriptionTestSuiteLocator();
    }
}

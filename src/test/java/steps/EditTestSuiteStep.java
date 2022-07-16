package steps;

import baseEntities.BaseStep;
import com.codeborne.selenide.SelenideElement;
import pages.TestSuiteOverviewPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;

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
        File image = new File("src/test/resources/screen1.jpg");
        editTestSuitePage.getButtonAttachmentLocator().uploadFile(image);
        editTestSuitePage.getSaveTestSuiteButtonLocator().click();
    }


    public void testConfirmation(){
    editTestSuitePage.getDialogTitleLocator();
        }



    public SelenideElement getTestSuiteName() {
        return editTestSuitePage.getNameTestSuiteInputLocator();
    }

    public SelenideElement getTestSuiteDescription() {
        return editTestSuitePage.getDescriptionTestSuiteLocator();
    }



}

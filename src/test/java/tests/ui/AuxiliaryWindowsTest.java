package tests.ui;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
@Epic("Diploma UI tests")
@Feature("Auxiliary windows tests")
public class AuxiliaryWindowsTest extends BaseTest {

    @Description("dialog window function delete  test")
    @Story("Delete test suit ")
    @Test(description = "dialog window delete test ")
    public void dialogWindowDeleteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("First");
        projectOverviewStep.selectSuite();
        testSuitesStep.addTestSuite();
        addTestSuiteStep.createTestSuite("newsuite", "test");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.deleteTestSuite("newsuite");
        editTestSuiteStep.testConfirmation();

    }

    @Description("Popup validation")
    @Story("Popup exists")
    @Test(description = "popup test")
    public void popupTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.popupText();

    }

    @Description("Upload picture ")
    @Story("Upload file")
    @Test(description ="upload test")
    public void uploadTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("aefae");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.uploadFile("First Suite", "uploading...")
                .getUpdateMessageLocator()
                .shouldHave(text("Successfully updated the test suite."));
        navigationStep.navigateToDashboardFromTestSuiteOverviewPage();
    }



}

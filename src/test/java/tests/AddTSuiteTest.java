package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;

public class AddTSuiteTest extends BaseTest {




    @Test
    public void createTestSuiteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("First");
        projectOverviewStep.selectSuite();
        testSuitesStep.addTestSuite();
        addTestSuiteStep.createTestSuite("First Suite", "test purposes")
                .getMessageLocator()
                .isDisplayed();
        navigationStep.navigateToDashboardFromTestSuiteOverviewPage();

    }

    @Test(dependsOnMethods = "createTestSuiteTest")
    public void readTestSuiteAfterCreateTest() {
        dashboardStep.openProject("First");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.getTestSuiteName()
                .shouldHave(value("First Suite"));
        editTestSuiteStep.getTestSuiteDescription()
                .shouldHave(text("test purposes"));
    }

    @Test
    public void updateTestSuiteTest() {
        dashboardStep.openProject("First");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.editTestSuite("Second Suite", "qegegqegqeg")
                .getUpdateMessageLocator()
                .shouldHave(text("Successfully updated the test suite."));
        navigationStep.navigateToDashboardFromTestSuiteOverviewPage();
    }

    @Test(dependsOnMethods = "updateTestSuiteTest")
    public void readTestSuiteAfterUpdateTest() {
        dashboardStep.openProject("First");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("Second Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.getTestSuiteName()
                .shouldHave(value("Second Suite"));
        editTestSuiteStep.getTestSuiteDescription()
                .shouldHave(text("qegegqegqeg"));
        navigationStep.navigateToDashboardFromEditTestSuitePage();
    }

    @Test(dependsOnMethods = "readTestSuiteAfterUpdateTest")
    public void deleteTestSuiteTest() {
        dashboardStep.openProject("First");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("Second Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.deleteTestSuite("Second Suite")
                .getDeleteMessageLocator()
                .shouldHave(text("Successfully deleted the test suite."));
    }
}

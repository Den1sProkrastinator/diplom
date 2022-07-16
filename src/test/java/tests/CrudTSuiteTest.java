package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;

public class CrudTSuiteTest extends BaseTest {



    @Description("create functionality")
    @Test
    public void createTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("aefae");
        projectOverviewStep.selectSuite();
        testSuitesStep.addTestSuite();
        addTestSuiteStep.createTestSuite("First Suite", "test purposes")
                .getMessageLocator()
                .isDisplayed();
        navigationStep.navigateToDashboardFromTestSuiteOverviewPage();

    }
    @Description("read functionality")
    @Test(dependsOnMethods = "createTest")

    public void readTest() {
        dashboardStep.openProject("aefae");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.getTestSuiteName()
                .shouldHave(value("First Suite"));
        editTestSuiteStep.getTestSuiteDescription()
                .shouldHave(text("test purposes"));
    }
    @Description("update functionality")
    @Test
    public void updateTest() {
        dashboardStep.openProject("aefae");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.editTestSuite("Second Suite", "qegegqegqeg")
                .getUpdateMessageLocator()
                .shouldHave(text("Successfully updated the test suite."));
        navigationStep.navigateToDashboardFromTestSuiteOverviewPage();
    }


    @Description("delete functionality")
    @Test(dependsOnMethods = "readAfterUpdateTest")
    public void deleteTest() {
        dashboardStep.openProject("aefae");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("Second Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.deleteTestSuite("Second Suite")
                .getDeleteMessageLocator()
                .shouldHave(text("Successfully deleted the test suite."));
    }





    @Test(dependsOnMethods = "updateTest")
    public void readAfterUpdateTest() {
        dashboardStep.openProject("aefae");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("Second Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.getTestSuiteName()
                .shouldHave(value("Second Suite"));
        editTestSuiteStep.getTestSuiteDescription()
                .shouldHave(text("qegegqegqeg"));
        navigationStep.navigateToDashboardFromEditTestSuitePage();
    }







}

package tests.ui;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;
@Epic("Diploma UI tests")
@Feature("Crud  tests")
public class CrudTSuiteTest extends BaseTest {
    @Description("create functionality")
    @Test(description = "create test")
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
    @Test(description = "read test")
    public void readTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("aefae");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.getTestSuiteName()
                .shouldHave(value("First Suite"));
        editTestSuiteStep.getTestSuiteDescription()
                .shouldHave(text("aefafaefaef"));
    }

    @Description("update functionality and upload picture")
    @Test(description = "update test")
    public void updateTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
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
    @Test(description = "delete test")
    public void deleteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("aefae");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("Second Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.deleteTestSuite("Second Suite")
                .getDeleteMessageLocator()
                .shouldHave(text("Successfully deleted the test suite."));
    }

    @Test(description = "")
    public void readAfterUpdateTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
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

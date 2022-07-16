package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class AuxiliaryWindowsTest extends BaseTest {



    @Description("dialog window function (delete)  test")
    @Test
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
    @Test
    public void PopupTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.popupText();

    }



}

package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;

public class AddProjectTest extends BaseTest {
    @Test
    public void addProjectTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.successAddProject();
        addprojectStep.createProject("First", "for test", false,
                        "Single", false)
                .getTabByName("test")
                .isDisplayed();
        navigationStep.navigateToDashboardFromProjectOverviewPage();
    }





}

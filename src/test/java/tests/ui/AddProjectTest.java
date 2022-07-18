package tests.ui;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
@Epic("Diploma UI tests")
@Feature("Add project test")
public class AddProjectTest extends BaseTest {

    @Description("Create project")
    @Test(description = "Add project test")
    @Story("Create project")
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

package steps;

import baseEntities.BaseStep;
import pages.AddProjectPage;
import lombok.Getter;
import pages.ProjectOverviewPage;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

@Getter
public class DashboardStep extends BaseStep {
    public AddProjectPage successAddProject() {
        addProject();
        return addProjectsPage;
    }

    public ProjectOverviewPage openProject(String projectName) {
        open("/");

        dashPage.openProjectByName(projectName).click();
        return new ProjectOverviewPage();
    }

    private void addProject() {
        dashPage.getAddProjectButton().click();
    }

    public void popupText(){
        actions()
                .moveToElement(dashPage.getIconHeaderTwitter())
                .pause(10000)

                .build();
        dashPage.getIconTwitterText().isDisplayed();

    }


}

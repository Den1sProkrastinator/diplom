package steps;

import baseEntities.BaseStep;
import addpages.AddProjectPage;
import pages.ProjectOverviewPage;

import static com.codeborne.selenide.Selenide.open;


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
}

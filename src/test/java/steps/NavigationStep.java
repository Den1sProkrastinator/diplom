package steps;

import baseEntities.BaseStep;
import pages.ProjectsPage;

public class NavigationStep extends BaseStep {



    public ProjectsPage navigateToProjectsPage() {
        projectsPage.openPageByUrl();
        return projectsPage;
    }
}

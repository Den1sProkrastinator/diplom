package steps;

import baseEntities.BaseStep;

import pages.ProjectOverviewPage;


public class AddProjectStep extends BaseStep {

    public ProjectOverviewPage createProject
            (String projectName, String announcement, boolean announcementCheckBoxButton,
             String suiteMode, boolean projectCompletedCheckBoxButton) {
        fillProject(projectName, announcement, announcementCheckBoxButton,
                suiteMode, projectCompletedCheckBoxButton);
        return projectOverviewPage;
    }

    private void fillProject(String projectName, String announcement, boolean announcementCheckBoxButton,
                             String suiteMode, boolean projectCompletedCheckBoxButton) {

    addProjectsPage.getNameInputLocator().setValue(projectName);
        addProjectsPage.getAnnouncementInputLocator().setValue(announcement);
        if (announcementCheckBoxButton) {
            addProjectsPage.getAnnouncementCheckBoxLocator().click();
        }
        switch (suiteMode) {
            case ("Single"):
              addProjectsPage.getSingleSuiteModeRadioButtonLocator().click();
            case ("Single with  baseline support"):
                addProjectsPage.getBaselineSuiteModeRadioButtonLocator().click();
            case ("Multiple"):
                addProjectsPage.getMultiSuiteModeRadioButtonLocator().click();
        }
        if (projectCompletedCheckBoxButton) {
            addProjectsPage.getProjectCompletedCheckBoxButtonLocator().click();
        }
        addProjectsPage.getAddProjectButtonLocator().click();
    }
}

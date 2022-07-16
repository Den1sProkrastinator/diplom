package steps;

import baseEntities.BaseStep;
import pages.DashboardPage;

public class NavigationStep extends BaseStep {
    public DashboardPage navigateToDashboardFromTestSuiteOverviewPage() {
        testSuiteOverviewPage.getReturnToDashboardButtonLocator().click();
        return dashPage;
    }

    public DashboardPage navigateToDashboardFromEditTestSuitePage() {
        editTestSuitePage.getReturnToDashboardPageButtonLocator().click();
        return dashPage;
    }

    public DashboardPage navigateToDashboardFromProjectOverviewPage() {
        projectOverviewPage.getReturnToDashboardButtonLocator().click();
        return dashPage;
    }
}

package baseEntities;
import pages.*;


public class BaseStep {
    protected LoginPage loginPage = new LoginPage();
    protected DashboardPage dashPage = new DashboardPage();

    protected AddProjectPage addProjectsPage = new AddProjectPage();
    protected ProjectOverviewPage projectOverviewPage = new ProjectOverviewPage();

    protected TestSuitesPage testSuitesPage  = new TestSuitesPage();

    protected AddTestSuitePage addTestSuitePage= new AddTestSuitePage();

    protected TestSuiteOverviewPage testSuiteOverviewPage= new TestSuiteOverviewPage();

    protected EditTestSuitePage editTestSuitePage =new EditTestSuitePage();

}

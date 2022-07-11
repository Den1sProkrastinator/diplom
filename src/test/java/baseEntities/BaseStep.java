package baseEntities;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProjectsPage;


public class BaseStep {
    protected LoginPage loginPage = new LoginPage();
    protected DashboardPage dashPage = new DashboardPage();

    protected ProjectsPage projectsPage = new ProjectsPage();

}

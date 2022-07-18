package baseEntities;

import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;


import steps.*;



public class BaseTest {

    protected LoginStep loginStep = new LoginStep();
    protected NavigationStep navigationStep= new NavigationStep();
    protected DashboardStep dashboardStep = new DashboardStep();
    protected AddProjectStep addprojectStep = new AddProjectStep();
    protected ProjectOverviewStep projectOverviewStep = new ProjectOverviewStep();

    protected TestSuitesStep testSuitesStep = new TestSuitesStep();
    protected AddTestSuiteStep addTestSuiteStep = new AddTestSuiteStep();
    protected TestSuiteOverviewStep testSuiteOverviewStep = new TestSuiteOverviewStep();
    protected EditTestSuiteStep editTestSuiteStep  = new EditTestSuiteStep();

    @BeforeMethod
    public void setup() {

        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserPosition = "10x10";
        Configuration.browserSize = "1920x1080";
        Configuration.fastSetValue = false;

    }


    @AfterMethod
    public void tearDown(){
        closeWebDriver();
    }

}

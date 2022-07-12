package baseEntities;

import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;


import org.testng.annotations.BeforeSuite;
import steps.*;



public class BaseTest {

    public LoginStep loginStep;
    public NavigationStep navigationStep;


    @BeforeMethod
    public void setup() {

        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.browserName();




        loginStep = new LoginStep();
        navigationStep = new NavigationStep();

    }









    @AfterMethod
    public void tearDown(){
        closeWebDriver();
    }

}

package baseEntities;

import core.ReadProperties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import steps.LoginStep;
import steps.NavigationStep;



public class BaseTest {

    public LoginStep loginStep;
    public NavigationStep navigationStep;

    @BeforeMethod
    public void setup(){
        open(ReadProperties.getUrl());
        
        loginStep = new LoginStep();
        navigationStep = new NavigationStep();
    }

    @AfterMethod
    public void tearDown(){
        closeWebDriver();
    }

}

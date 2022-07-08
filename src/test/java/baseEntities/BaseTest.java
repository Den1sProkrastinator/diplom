package baseEntities;

import core.ReadProperties;
import io.cucumber.java.Before;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import steps.LoginStep;

public class BaseTest {

    public LoginStep loginStep;

    @BeforeMethod
    public void setup(){
        open(ReadProperties.getUrl());
        
        loginStep = new LoginStep();
    }

    @AfterMethod
    public void tearDown(){
        closeWebDriver();
    }

}

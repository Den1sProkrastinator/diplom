package tests;
import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.*;
import com.codeborne.selenide.SelenideElement;
import core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;


public class LoginTest extends BaseTest {



    @Test

    public void successLoginTest(){

        loginStep.successLogin(ReadProperties.username(),ReadProperties.password())
                .getPageIdentifier()
                .shouldBe(Condition.exist);



    }

    @Test()
    public void fakeEmailTest() {
        loginStep.improperLogin("Nikita", ReadProperties.password())
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }

    @Test()
    public void fakePassTest() {
        loginStep.improperLogin(ReadProperties.username(), "deathdeathdeath")
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }

}

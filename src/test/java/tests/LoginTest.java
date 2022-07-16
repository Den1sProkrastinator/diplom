package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import core.ReadProperties;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;


public class LoginTest extends BaseTest {


    @Description("login with reliable data")
    @Test

    public void successLoginTest(){

        loginStep.successLogin(ReadProperties.username(),ReadProperties.password())
                .getPageIdentifier()
                .shouldBe(Condition.exist);



    }
    @Description("login with fake email")
    @Test()
    public void fakeEmailTest() {
        loginStep.improperLogin("Nikita", ReadProperties.password())
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }
    @Description("login with fake password")
    @Test()
    public void fakePassTest() {
        loginStep.improperLogin(ReadProperties.username(), "deathdeathdeath")
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }





    @Description("boundary login pass")
    @Test
    public void boundaryTest() {

        loginStep.boundaries251().getErrorTextLocator().shouldHave(text("Field Email/User is too long (250 characters at most)."));
        loginStep.boundaries250().getErrorTextLocator().shouldHave(text("Email/Login or Password is incorrect. Please try again."));
        loginStep.boundaries249().getErrorTextLocator().shouldHave(text("Email/Login or Password is incorrect. Please try again."));


    }









    }



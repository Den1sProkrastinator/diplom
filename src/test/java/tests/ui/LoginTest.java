package tests.ui;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import core.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

@Epic("Diploma UI tests")
@Feature("Login  test")
public class LoginTest extends BaseTest {


    @Description("login with reliable data")
    @Test(description = "success login test")
    public void successLoginTest(){

        loginStep.successLogin(ReadProperties.username(),ReadProperties.password())
                .getPageIdentifier()
                .shouldBe(Condition.exist);

    }
    @Description("login with fake email")
    @Story("Negative test")
    @Test(description = "fake email test")
    public void fakeEmailTest() {
        loginStep.improperLogin("Nikita", ReadProperties.password())
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }

    @Description("login with empty data")
    @Story("Negative test")
    @Test(description = "empty email test")
    public void emptyEmailTest() {
        loginStep.improperLogin("", ReadProperties.password())
                .getEmptyTextLocator()
                .shouldHave(text("dssdggsdsgD"));

    }

    @Description("login with fake password")
    @Story("Negative test")
    @Test(description = "fake pass test")
    public void fakePassTest() {
        loginStep.improperLogin(ReadProperties.username(), "deathdeathdeath")
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }
    @Description("boundary login pass")
    @Story("Boundary test")
    @Test(description = "boundary test")
    public void boundaryTest() {

        loginStep.boundaries251().getErrorTextLocator().shouldHave(text("Field Email/User is too long (250 characters at most)."));
        loginStep.boundaries250().getErrorTextLocator().shouldHave(text("Email/Login or Password is incorrect. Please try again."));
        loginStep.boundaries249().getErrorTextLocator().shouldHave(text("Email/Login or Password is incorrect. Please try again."));

    }

    }



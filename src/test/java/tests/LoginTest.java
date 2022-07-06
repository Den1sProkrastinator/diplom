package tests;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;


public class LoginTest {


    @Test

    public void LoginTest(){


        open(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage();
       loginPage.userName.setValue(ReadProperties.username());
        loginPage.passWord.setValue(ReadProperties.password());
        loginPage.buttonEnter.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All projects"));


    }


}

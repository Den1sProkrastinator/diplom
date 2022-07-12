package tests;
import baseEntities.BaseTest;
import com.codeborne.selenide.SelenideElement;
import core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;



public class LoginTest extends BaseTest {



    @Test

    public void successLoginTest(){

        loginStep.successLogin(ReadProperties.username(),ReadProperties.password()).isPageOpened();



    }



}

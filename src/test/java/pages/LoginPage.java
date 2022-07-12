package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public  class LoginPage  {


    public SelenideElement userName = $(byName("name"));
    public SelenideElement passWord = $("#password");
    public SelenideElement buttonEnter = $("#button_primary");

    public SelenideElement errorTextLocator = $(byClassName("error-text"));



    public SelenideElement getErrorTextElement() { return $(errorTextLocator);}
    public SelenideElement getEmailInput() {
        return $(userName);
    }
    public SelenideElement getPswInput() {
        return $(passWord);
    }
    public SelenideElement getLogInButton() {
        return $(buttonEnter);
    }
















}

package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public  class LoginPage  {


    public SelenideElement userName = $(byName("name"));
    public SelenideElement passWord = $("#password");
    public SelenideElement buttonEnter = $("#button_primary");
















}

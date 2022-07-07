package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    public SelenideElement userName = $(By.id("name"));
    public SelenideElement passWord = $("#password");
    public SelenideElement buttonEnter = $("#button_primary");

}

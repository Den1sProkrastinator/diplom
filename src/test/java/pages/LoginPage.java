package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public  class LoginPage extends BasePage {

    private final SelenideElement pageIdentifier = $(".logo-loginpage");
    private final SelenideElement userName = $(byName("name"));
    private final SelenideElement passWord = $("#password");
    private final SelenideElement buttonEnter = $("#button_primary");
    private final SelenideElement errorTextLocator = $(byClassName("error-text"));

    private SelenideElement errorLocator = $x("//div[text()='Field Email/User is too long (250 characters at most).']");

    public SelenideElement getErrorTextLocator() {
        return errorTextLocator;
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }



















}

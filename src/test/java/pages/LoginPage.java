package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
@Getter
public  class LoginPage extends BasePage {



    private final SelenideElement pageIdentifier = $(".logo-loginpage");
    private final SelenideElement userName = $(byName("name"));
    private final SelenideElement passWord = $("#password");
    private final SelenideElement buttonEnter = $("#button_primary");
    private final SelenideElement errorTextLocator = $(byClassName("error-text"));



    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }



















}

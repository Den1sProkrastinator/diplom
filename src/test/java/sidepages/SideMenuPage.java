package sidepages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class SideMenuPage extends BasePage {

    private final SelenideElement SideBarLocator = $(byId("sidebar"));


    @Override
    protected SelenideElement getPageIdentifier() {
        return  SideBarLocator;
    }
}

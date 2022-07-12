package baseEntities;


import com.codeborne.selenide.SelenideElement;
import core.ReadProperties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    protected abstract SelenideElement getPageIdentifier();

    public boolean isPageOpened() {
        return $(getPageIdentifier()).isDisplayed();
    }




    public void openPageByUrl(String pagePath) {
        open(ReadProperties.getUrl() + pagePath);
    }
}

package sidepages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class TopMenuPage extends BasePage {



    private final SelenideElement TopMenuLocator= $(byClassName("top-panel"));


    @Override
    protected SelenideElement getPageIdentifier() {
        return TopMenuLocator;
    }
}

package baseEntities;


import com.codeborne.selenide.SelenideElement;
import core.ReadProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    protected abstract SelenideElement getPageIdentifier();


}

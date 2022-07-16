package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
@Getter
public class TestSuiteOverviewPage extends BasePage {

    private SelenideElement pageIdentifier = $(byXpath(("//a[@href='index.php?/suites/view/28']")));
    private SelenideElement editButtonLocator =$(byXpath(("//a[contains(@class,'content-header-button')]/span[@class='button-text' and text()='Edit']")));
    private SelenideElement updateMessageLocator = $(byXpath(("//div[contains(text(),'Successfully updated the test suite.')]")));
    private SelenideElement deleteMessageLocator = $(byXpath(("//div[contains(text(),'Successfully deleted the test suite.')]")));
    private SelenideElement returnToDashboardButtonLocator = $(byXpath(("//a[@id='navigation-dashboard-top']")));

    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }


}

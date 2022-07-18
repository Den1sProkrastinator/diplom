package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class TestSuitesPage extends BasePage {

    private SelenideElement pageIdentifier = $(byXpath("//div[contains(text(),'Test Suites & Cases')]"));
    private SelenideElement addTestSuiteButtonLocator = $(byXpath("//a[@id='navigation-suites-add']"));

    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement OpenTestSuiteByNameLocator(String testSuiteName) {

        String openTestSuiteByNameLocator = "//a[text()='First']";
        return $(byXpath(openTestSuiteByNameLocator.replace("First",testSuiteName)));
    }
}

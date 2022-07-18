package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


@Getter
public class ProjectOverviewPage extends BasePage {

    private final SelenideElement pageIdentifier = $(".chart-line");
    private final SelenideElement testSuitesAndCasesButtonLocator = $(byXpath(("//a[@id='navigation-suites']")));
    private final SelenideElement milestonesButtonLocator =$(byXpath(("//a[@id='navigation-milestones']")));
    private final SelenideElement messageLocator = $(byXpath(("//div[contains(text(),'Successfully added the new test suite.')]")));
    private final SelenideElement returnToDashboardButtonLocator = $("#navigation-dashboard");

    public SelenideElement getTabByName(String tabName) {
        String tabLocator = "//li/a[. = 'First']";
        return $(byXpath((tabLocator.replace("First", tabName))));
    }
    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }
}

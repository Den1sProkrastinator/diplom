package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter

public class DashboardPage extends BasePage {

    private final SelenideElement pageIdentifier
            = $(byXpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]"));

    private final SelenideElement addProjectButton = $(byClassName("sidebar-button"));
    private SelenideElement iconHeaderTwitter = $x("//div[@class='icon-header-twitter')]");
    private SelenideElement iconTwitterText = $x("//div[@class='tooltip']");

    @Override
    public SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement openProjectByName(String projectName) {
        String openProjectByName = "//a[text()='First']";
        return $(byXpath(openProjectByName.replace("First", projectName)));
    }


}

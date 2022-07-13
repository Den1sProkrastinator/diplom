package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter

public class DashboardPage extends BasePage {


    private final static String pagePath = "/index.php?/dashboard";


    private final SelenideElement pageIdentifier
            = $(byXpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]"));

    private final SelenideElement addProjectButton = $(byClassName("sidebar-button"));



    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    @Override
    public SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }


    public SelenideElement openProjectByName(String projectName) {
        String openProjectByName = "//a[text()='First']";
        return $(byXpath(openProjectByName.replace("First", projectName)));
    }


}

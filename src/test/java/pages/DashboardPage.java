package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
public class DashboardPage extends BasePage {


    private final static String pagePath = "/index.php?/dashboard";



    public SelenideElement DashboardLocator
            = $(byXpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Dashboard')]"));



    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


    @Override
    protected SelenideElement getPageIdentifier() {
        return DashboardLocator;
    }

    public SelenideElement getDashboardLocator() {
        return $(DashboardLocator);
    }
}

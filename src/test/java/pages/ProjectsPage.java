package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";

    public SideMenuPage sideMenuPage;

    private SelenideElement ProjectPageLocator = $(byXpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Projects')]"));



    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return ProjectPageLocator;
    }


}

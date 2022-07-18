package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class EditTestSuitePage extends BasePage {

    private SelenideElement pageIdentifier = $(byXpath(("//div[contains(@class,'content-header-title')]")));
    private SelenideElement nameTestSuiteInputLocator = $(byXpath(("//input[@id='name']")));
    private SelenideElement descriptionTestSuiteLocator = $(byXpath(("//div[@id='description_display']")));
    private SelenideElement saveTestSuiteButtonLocator = $(byXpath(("//button[@id='accept']")));
    private SelenideElement cancelButtonLocator = $(byXpath(("//div//button[@id='accept']/following-sibling::a")));
    private SelenideElement dialogTitleLocator = $x("//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']");
    private SelenideElement deleteButtonLocator = $(byXpath(("//a[contains(text(),'Delete this test suite')]")));
    private SelenideElement dialogFormLocator = $(byXpath(("//div[@class='dialog-body']/p[text()='Really delete this test suite and all ']")));
    private SelenideElement checkBoxButtonLocator = $(byXpath(("//span[@class='dialog-confirm-busy']/following::input[@name='deleteCheckbox']")));
    private SelenideElement confirmationOkButtonLocator = $(byXpath(("//div[contains(@class,'delete-confirm-container')]/following::a[contains(text(),'OK')]")));
    private SelenideElement confirmationCancelButtonLocator = $(byXpath(("//a[contains(@class,'dialog-action-secondary')]/following-sibling::a[contains(text(),'Cancel')]")));
    private SelenideElement returnToDashboardPageButtonLocator = $("#navigation-dashboard-top");
    private SelenideElement buttonAttachmentLocator = $(byXpath(("//input[@type='file']")));

    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement DeleteTestSuiteButtonLocator(String testSuite) {
        return deleteButtonLocator;
    }


}

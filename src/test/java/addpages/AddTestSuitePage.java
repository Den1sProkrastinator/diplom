package addpages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class AddTestSuitePage extends BasePage {
    //locators
    private SelenideElement pageIdentifier = $x("//div[contains(text(),'Add Test Suite')]");
    private SelenideElement nameTestSuiteInputLocator = $x("//input[@id='name']");
    private SelenideElement descriptionTestSuiteInputLocator = $x("//div[@id='description_display']");
    private SelenideElement addTestSuiteButtonLocator = $x("//button[@id='accept']");
    private SelenideElement cancelButtonLocator = $x("//div//button[@id='accept']/following-sibling::a");
    private SelenideElement attachmentButtonLocator = $x("//div[@id='entityAttachmentListEmptyIcon']");
    private SelenideElement attachFileButtonLocator = $x("//div[@id='libraryAttachmentsAddItem']");

    //corpuscular methods
    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }


}

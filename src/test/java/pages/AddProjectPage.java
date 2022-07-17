package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
@Getter
public class AddProjectPage extends BasePage {

    private final SelenideElement pageIdentifier = $x("//div[contains(text(),'Add Project')]");
    private final SelenideElement nameInputLocator = $("input.form-control#name");
    private final SelenideElement announcementInputLocator = $("textarea#announcement");
    private final SelenideElement announcementCheckBoxLocator = $("input#show_announcement");
    private final SelenideElement singleSuiteModeRadioButtonLocator = $("input#suite_mode_single");
    private final SelenideElement baselineSuiteModeRadioButtonLocator = $("input#suite_mode_single_baseline");
    private final SelenideElement multiSuiteModeRadioButtonLocator = $("input#suite_mode_multi");
    private final SelenideElement projectCompletedCheckBoxButtonLocator = $("is_completed");
    private final SelenideElement addProjectButtonLocator = $("#accept");


    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

}

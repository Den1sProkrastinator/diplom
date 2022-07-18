package steps;

import baseEntities.BaseStep;
import core.ReadProperties;
import org.apache.commons.lang.RandomStringUtils;
import pages.DashboardPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginStep extends BaseStep {


    public DashboardPage successLogin(String user, String pass) {
        login(user, pass);

        return dashPage;

    }
    public LoginPage improperLogin(String fakeUser, String fakePass) {
        login(fakeUser, fakePass);

        return loginPage;
    }

private void login(String user, String pass){
    open(ReadProperties.getUrl());
    loginPage.getUserName().setValue(user);
    loginPage.getPassWord().setValue(pass);
    loginPage.getButtonEnter().click();

}

    public LoginPage boundaries251() {
        String random251 = RandomStringUtils.randomAlphabetic(251);
        login(random251, ReadProperties.password());

        return loginPage;

    }


    public LoginPage boundaries250() {
    String random250 = RandomStringUtils.randomAlphabetic(250);
    login(ReadProperties.username(), random250);
        return loginPage;}

    public LoginPage boundaries249() {


        String random249= RandomStringUtils.randomAlphabetic(249);
        login(random249, ReadProperties.password());
        return loginPage;


    }




}



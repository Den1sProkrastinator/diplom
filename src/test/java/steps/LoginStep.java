package steps;

import baseEntities.BaseStep;
import core.ReadProperties;
import pages.DashboardPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
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

    public LoginPage logout() {

        return loginPage;
    }


}



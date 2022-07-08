package steps;

import baseEntities.BaseStep;
import core.ReadProperties;
import pages.DashboardPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;

public class LoginStep extends BaseStep {


    public DashboardPage successLogin(String user, String pass) {
        login(user,pass);
        return dashPage;

    }



private void login(String user, String pass){

    loginPage.userName.setValue(ReadProperties.username());
    loginPage.passWord.setValue(ReadProperties.password());
    loginPage.buttonEnter.click();

}


}



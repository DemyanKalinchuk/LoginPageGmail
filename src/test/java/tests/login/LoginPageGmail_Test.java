package tests.login;

import org.testng.annotations.Test;
import pages.home.LoginPageGmail;
import tests.base.BaseTest;

public class LoginPageGmail_Test extends BaseTest {


    @Test
    public void checkThanUserCanLoginWithValidCreds() {
        open();
        loginPageGmail.clickSignInBtn();
        loginPageGmail.clickAndFillEmailField("nationdyoma24@gmail.com");
        loginPageGmail.clickAndFillPswdFiled("QWASZXedc123456");
        loginPageGmail.checkInputWithValidData();

    }

    @Test
    public void checkThatUserCannotLoginWithInvalidPasswordAndErrorMessageDisplayed() {
        open();
        loginPageGmail.clickSignInBtn();
        loginPageGmail.clickAndFillEmailField("nationdyoma24@gmail.com");
        loginPageGmail.clickAndFillPswdFiled("Q123456");
        loginPageGmail.checkPasswordErrorMessage();
    }

    @Test
    public void checkThatUserCannotLoginWithInvalidEmailAndErrorMessageDisplayed() {
        open();
        loginPageGmail.clickSignInBtn();
        loginPageGmail.clickAndFillEmailField("natisfgkjhdsbfgksdf24@gmail.com");
        loginPageGmail.checkLoginErrorMessage();
    }
}

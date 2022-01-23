package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class LoginPageGmail extends BasePage {

    public LoginPageGmail(WebDriver driver) {
        super(driver);
    }

    private By signInBtn = (By.xpath("//a[@data-action = 'sign in']"));
    private By passwordField = (By.name("password"));
    private By emailField = (By.id("identifierId"));
    private By passwordErrorMessage = By.xpath("//*[@name = 'identifierInput']/parent::div/div[1]//span");
    private By loginErrorMessage = By.xpath("//*[@type = 'password']/parent::div//span/parent::div");
    private By successfulGmailAccess = By.xpath("//*[@data-tooltip='Входящие']");

    String passwordErrorMessageString = "Неправильний пароль. Повторіть спробу або натисніть \"Забули пароль?\", щоб скинути його.";
    String loginErrorMessageString = "Не вдалося знайти ваш обліковий запис Google";
    String InputWithValidDataString = "Входящие";


    public void clickSignInBtn() {
        driver.findElement(signInBtn).click();
    }

    public void clickAndFillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email, Keys.ENTER);
    }

    public void checkPasswordErrorMessage() {
        String errorMessageText = driver.findElement(passwordErrorMessage).getText();
        Assert.assertEquals(errorMessageText, passwordErrorMessageString);
    }

    public void checkLoginErrorMessage() {
        String errorMessageText = driver.findElement(loginErrorMessage).getText();
        Assert.assertEquals(errorMessageText, loginErrorMessageString);
    }

    public void checkInputWithValidData(){

        String NameElementText = driver.findElement(successfulGmailAccess).getText();
        Assert.assertEquals(NameElementText, InputWithValidDataString);
    }

    public void clickAndFillPswdFiled(String password) {
        driver.findElement(passwordField).sendKeys(password, Keys.ENTER);
    }
}

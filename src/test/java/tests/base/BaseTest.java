package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import pages.base.BasePage;
import pages.home.LoginPageGmail;

import java.time.Duration;

public class BaseTest {

    private WebDriver driver = createDriver();
    private BasePage basePage = new BasePage(driver);
    protected LoginPageGmail loginPageGmail = new LoginPageGmail(driver);

    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("lang=en-GB");
        ChromeDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    @BeforeTest
    public void open() {
        basePage.show("https://www.google.com/intl/ru/gmail/about/");
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}



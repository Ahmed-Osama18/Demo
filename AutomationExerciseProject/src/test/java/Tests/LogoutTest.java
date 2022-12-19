package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountDeletedPage;
import pages.HomePage;
import pages.SignupFormPage;
import pages.SignupOrLoginPage;

import java.time.Duration;

public class LogoutTest {
    WebDriver driver;
    String URL = "https://automationexercise.com/";
    WebDriverWait webDriverWait;
    SignupOrLoginPage signupOrLoginPage;
    HomePage homePage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get(URL);

        homePage = new HomePage(driver);
        signupOrLoginPage = new SignupOrLoginPage(driver);

        Assert.assertEquals(homePage.getURL(), URL);
        homePage.loginOrSignUpLink().click();
        Assert.assertTrue(signupOrLoginPage.visibilityOfLogin());
        signupOrLoginPage.enterEmailLogin("ahmeds12@gmail.com");
        signupOrLoginPage.enterPasswordLogin("12345");
        signupOrLoginPage.ClickLoginButton();
        Assert.assertEquals(homePage.loggedAs(),"Logged in as " + "ahmed" );

    }

    @Test
    public void validateLogout() {
        homePage.logOut();
        Assert.assertEquals(homePage.getURL(),"https://automationexercise.com/login","User isn't in login page");
    }

    @AfterClass
    public void quitDriver()
    {
        homePage.quit();
    }
}

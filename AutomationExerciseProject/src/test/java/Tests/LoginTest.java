package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.Date;

public class LoginTest {
    WebDriver driver;
    String URL = "https://automationexercise.com/";
    String username = "ahmed";
    WebDriverWait webDriverWait;
    SignupOrLoginPage signupOrLoginPage;
    AccountDeletedPage accountDeletedPage;
    SignupFormPage signupFormPage;
    AccountCreatedPage accountCreatedPage;
    HomePage homePage;
    Date dateObj;
    String date;
    SignupTest signupTest;
    LogoutTest logoutTest;
    String email = "ahmedd12@gmail.com";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get(URL);

        homePage = new HomePage(driver);
        signupOrLoginPage = new SignupOrLoginPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
        signupFormPage = new SignupFormPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        signupTest = new SignupTest();
        logoutTest = new LogoutTest();


        homePage.loginOrSignUpLink().click();
        signupOrLoginPage.enterUsername(username);
        signupOrLoginPage.enterEmailSignup(email);
        signupOrLoginPage.ClickSignupButton();
        signupFormPage.clickOnMr();
        signupFormPage.enterPassword("12345");
        signupFormPage.selectDay();
        signupFormPage.selectMonth();
        signupFormPage.selectYear();
        signupFormPage.clickOnNewsletter();
        signupFormPage.clickOnReceiveOffers();
        signupFormPage.enterFirstName("ahmed");
        signupFormPage.enterLastName("osama");
        signupFormPage.enterCompany("vois");
        signupFormPage.enterAdress1("vois");
        signupFormPage.enterAdress2("vois");
        signupFormPage.enterCountry();
        signupFormPage.enterState("ssss");
        signupFormPage.enterCity("giza");
        signupFormPage.enterZIPCODE("12345");
        signupFormPage.enterMobile("01550000000");
        signupFormPage.clickOnCreateAccount();
        accountCreatedPage.clickOnContinue();
        homePage.logOut();

    }

    @Test
    public void validateLoginSuccess()
    {
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
        homePage.loginOrSignUpLink().click();
        Assert.assertTrue(signupOrLoginPage.visibilityOfLogin());
        signupOrLoginPage.enterEmailLogin(email);
        signupOrLoginPage.enterPasswordLogin("12345");
        signupOrLoginPage.ClickLoginButton();
        Assert.assertEquals(homePage.loggedAs(),"Logged in as " + "ahmed" );
        homePage.deleteAccount();
        Assert.assertTrue(accountDeletedPage.visibilityOfDeletedCreated());
    }

    @Test
    public void validateLoginFailed() {
        Assert.assertEquals(driver.getCurrentUrl(),URL);
        homePage.loginOrSignUpLink().click();
        Assert.assertTrue(signupOrLoginPage.visibilityOfLogin());
        signupOrLoginPage.enterEmailLogin("ahmeds12@gmail.com");
        signupOrLoginPage.enterPasswordLogin("123");
        signupOrLoginPage.ClickLoginButton();
        Assert.assertTrue(signupOrLoginPage.verifyLoginErrorMessage(),"No Error Msg");
    }

    @AfterClass
    public void quitDriver()
    {
        homePage.quit();
    }
}


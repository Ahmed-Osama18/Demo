package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class SignupTest {

    WebDriver driver;
    String URL = "https://automationexercise.com/";
    String username = "ahmed";
    WebDriverWait webDriverWait;
    SignupOrLoginPage signupOrLoginPage;
    SignupFormPage signupFormPage;
    HomePage homePage;
    AccountCreatedPage accountCreatedPage;
    AccountDeletedPage accountDeletedPage;
    Date dateObj;
    String date;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get(URL);
        Assert.assertEquals(driver.getCurrentUrl(),URL);

        homePage = new HomePage(driver);
        signupOrLoginPage = new SignupOrLoginPage(driver);
        signupFormPage = new SignupFormPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);

        dateObj = new Date();
        date = dateObj.toString().replaceAll(" ","").replaceAll(":","");
    }


    @Test
    public void validateSignupSuccess()
    {
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(driver.getCurrentUrl(),URL);
        homePage.loginOrSignUpLink().click();
        Assert.assertTrue(signupOrLoginPage.visibilityOfSignUp());
        signupOrLoginPage.enterUsername(username);
        signupOrLoginPage.enterEmailSignup(date + "@gmail.com");
        signupOrLoginPage.ClickSignupButton();

        Assert.assertEquals(signupFormPage.visibilityOfPageTitle(),"ENTER ACCOUNT INFORMATION");

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
        Assert.assertTrue(accountCreatedPage.visibilityOfAccountCreated(),"(AccountCreated) Not findable");
        accountCreatedPage.clickOnContinue();
        Assert.assertEquals(homePage.loggedAs(),"Logged in as " + username );
        homePage.deleteAccount();
        Assert.assertTrue(accountDeletedPage.visibilityOfDeletedCreated());
        accountDeletedPage.clickOnContinue();
        softAssert.assertAll();
    }

    @Test
    public void validateSignupErrorMessage() {
        Assert.assertEquals(driver.getCurrentUrl(), URL);
        homePage.loginOrSignUpLink().click();
        Assert.assertTrue(signupOrLoginPage.visibilityOfSignUp());
        signupOrLoginPage.enterUsername(username);
        signupOrLoginPage.enterEmailSignup("ahmeds2@gmail.com");
        signupOrLoginPage.ClickSignupButton();
        Assert.assertEquals(signupOrLoginPage.verifyEmailErrorMessage(),"Email Address already exist!");
    }

    @AfterMethod
    public void backToURL()
    {
        homePage.goToURL();
    }

    @AfterClass
    public void quitDriver()
    {
        homePage.quit();
    }
}

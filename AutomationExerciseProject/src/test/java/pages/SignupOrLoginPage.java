package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupOrLoginPage {
    By SIGNUP_TITLE = By.className("signup-form");
    By LOGIN_TITLE = By.className("login-form");
    By USERNAME = By.xpath("//input[@data-qa=\"signup-name\"]");

    By EMAIL_LOGIN = By.xpath("//input[@data-qa=\"login-email\"]");
    By PASSWORD_LOGIN = By.xpath("//input[@data-qa=\"login-password\"]");
    By LOGIN_BTN = By.xpath("//button[@data-qa=\"login-button\"]");
    By EMAIL_SIGNUP = By.xpath("//input[@data-qa=\"signup-email\"]");
    By SIGNUP_BTN = By.xpath("//button[@data-qa=\"signup-button\"]");
    By ERROR_LOGIN_MESSAGE = By.xpath("//form[@action=\"/login\"]");
    By ERROR_EMAIL_MESSAGE = By.xpath("//form[@action=\"/signup\"]/p");
    WebDriver driver;
    WebDriverWait webDriverWait;

    public SignupOrLoginPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public Boolean visibilityOfSignUp()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUP_TITLE));
        Boolean signupTitle = driver.findElement(SIGNUP_TITLE).getText().contains("Signup");
        return signupTitle;
    }

    public Boolean visibilityOfLogin()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_TITLE));
        Boolean loginTitle = driver.findElement(LOGIN_TITLE).getText().contains("Login");
        return loginTitle;
    }

    public void enterUsername(String username)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(USERNAME));
        driver.findElement(USERNAME).sendKeys(username);

    }

    public void enterEmailSignup(String email)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(EMAIL_SIGNUP));
        driver.findElement(EMAIL_SIGNUP).sendKeys(email);
    }

    public void ClickSignupButton()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(SIGNUP_BTN));
        driver.findElement(SIGNUP_BTN).click();
    }

    public void enterEmailLogin(String email)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(EMAIL_LOGIN));
        driver.findElement(EMAIL_LOGIN).sendKeys(email);
    }

    public void enterPasswordLogin(String password)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(PASSWORD_LOGIN));
        driver.findElement(PASSWORD_LOGIN).sendKeys(password);
    }

    public void ClickLoginButton()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN));
        driver.findElement(LOGIN_BTN).click();
    }

    public Boolean verifyLoginErrorMessage(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_LOGIN_MESSAGE));
        Boolean Error = driver.findElement(ERROR_LOGIN_MESSAGE).getText().contains("incorrect");
        return Error;
    }

    public String verifyEmailErrorMessage(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_EMAIL_MESSAGE));
        String Error = driver.findElement(ERROR_EMAIL_MESSAGE).getText();
        return Error;
    }

}

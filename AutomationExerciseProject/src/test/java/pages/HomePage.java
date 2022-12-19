package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.StyledEditorKit;
import java.net.URL;
import java.time.Duration;

public class HomePage {
    String URL = "https://automationexercise.com/";
    WebDriver driver;
    WebDriverWait webDriverWait;
    By LOGIN_BTN = By.xpath("//a[@href=\"/login\"]");
    By LOGGED_AS = By.xpath("//i[contains(@class,'fa-user')]//parent::a");
    By DELETED_ACC = By.xpath("//a[@href=\"/delete_account\"]");
    By LOGOUT = By.xpath("//a[@href=\"/logout\"]");
    By PRODUCTS = By.xpath("//a[@href=\"/products\"]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public String getURL()
    {
        String URL = driver.getCurrentUrl();
        return URL;
    }

    public void goToURL()
    {
        driver.get(URL);
    }

    public void quit()
    {
        driver.quit();
    }

    public WebElement loginOrSignUpLink()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN));
        WebElement loginorsignup = driver.findElement(LOGIN_BTN);
        return loginorsignup;
    }

    public WebElement products()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(PRODUCTS));
        WebElement products = driver.findElement(PRODUCTS);
        return products;
    }

    public String loggedAs()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LOGGED_AS));
        String islogged = driver.findElement(LOGGED_AS).getText();
        return islogged;
    }

    public void deleteAccount()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(DELETED_ACC));
        driver.findElement(DELETED_ACC).click();
    }

    public void logOut()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT));
        driver.findElement(LOGOUT).click();
    }
}

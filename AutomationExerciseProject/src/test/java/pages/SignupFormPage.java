package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupFormPage {

    By PAGE_TITLE = By.xpath("//h2[@class=\"title text-center\"]/b");
    By TITLE_MR = By.xpath("//label[@for=\"id_gender1\"]");
    By TITLE_MRS = By.xpath("//label[@for=\"id_gender2\"]");
    By PASSWORD = By.id("password");
    By DAY = By.id("days");
    By MONTH = By.id("months");
    By YEAR = By.id("years");
    By NEWS = By.id("newsletter");
    By OFFERS = By.id("optin");
    By FIRST_NAME = By.id("first_name");
    By LAST_NAME = By.id("last_name");
    By COMPANY = By.id("company");
    By ADDRESS1 = By.id("address1");
    By ADDRESS2 = By.id("address2");
    By COUNTRY = By.id("country");
    By STATE = By.id("state");
    By CITY = By.id("city");
    By ZIPCODE = By.id("zipcode");
    By MOBILE = By.id("mobile_number");
    By CREATE_BTN = By.xpath("//button[@data-qa=\"create-account\"]");


    WebDriver driver;
    WebDriverWait webDriverWait;

    public SignupFormPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public String visibilityOfPageTitle()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
        String isDisplayed = driver.findElement(PAGE_TITLE).getText();
        return isDisplayed;
    }

    public void clickOnMr()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(TITLE_MR));
        driver.findElement(TITLE_MR).click();
    }

    public void clickOnMrs()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(TITLE_MRS));
        driver.findElement(TITLE_MRS).click();
    }

    public void enterPassword(String password)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(PASSWORD));
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void selectDay()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(DAY));
        Select select = new Select(driver.findElement(DAY));
        select.selectByValue("1");

    }
    public void selectMonth()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(MONTH));
        Select select = new Select(driver.findElement(MONTH));
        select.selectByValue("1");

    }
    public void selectYear()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(YEAR));
        Select select = new Select(driver.findElement(YEAR));
        select.selectByValue("1999");
    }

    public void clickOnNewsletter()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(NEWS));
        driver.findElement(NEWS).click();
    }

    public void clickOnReceiveOffers()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(OFFERS));
        driver.findElement(OFFERS).click();
    }

    public void enterFirstName(String firstname)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(FIRST_NAME));
        driver.findElement(FIRST_NAME).sendKeys(firstname);
    }
    public void enterLastName(String lastname)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(LAST_NAME));
        driver.findElement(LAST_NAME).sendKeys(lastname);
    }
    public void enterCompany(String company)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(COMPANY));
        driver.findElement(COMPANY).sendKeys(company);
    }
    public void enterAdress1(String address1)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(ADDRESS1));
        driver.findElement(ADDRESS1).sendKeys(address1);
    }
    public void enterAdress2(String address2)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(ADDRESS2));
        driver.findElement(ADDRESS2).sendKeys(address2);
    }
    public void enterCountry()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(COUNTRY));
        Select select = new Select(driver.findElement(COUNTRY));
        select.selectByValue("India");
    }
    public void enterState(String state)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(STATE));
        driver.findElement(STATE).sendKeys(state);
    }
    public void enterCity(String city)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(CITY));
        driver.findElement(CITY).sendKeys(city);
    }
    public void enterZIPCODE(String zipcode)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(ZIPCODE));
        driver.findElement(ZIPCODE).sendKeys(zipcode);
    }
    public void enterMobile(String mobile)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(MOBILE));
        driver.findElement(MOBILE).sendKeys(mobile);
    }

    public void clickOnCreateAccount()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(CREATE_BTN));
        driver.findElement(CREATE_BTN).click();
    }



}

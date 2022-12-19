package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreatedPage {
    By PAGETITLE =By.xpath("//h2[@data-qa=\"account-created\"]");
    By CONTINUE = By.xpath("//a[@data-qa=\"continue-button\"]");

    WebDriver driver;
    WebDriverWait webDriverWait;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public boolean visibilityOfAccountCreated()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PAGETITLE));
        boolean created = driver.findElement(PAGETITLE).getText().contains("CREATED");
        return created;
    }

    public void clickOnContinue()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE));
        driver.findElement(CONTINUE).click();
    }


}

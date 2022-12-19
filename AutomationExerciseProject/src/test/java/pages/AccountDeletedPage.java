package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountDeletedPage {

    WebDriver driver;
    WebDriverWait webDriverWait;
    By PAGETITLE =By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By CONTINUE = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public boolean visibilityOfDeletedCreated()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PAGETITLE));
        boolean deleted = driver.findElement(PAGETITLE).getText().contains("DELETED");
        return deleted;
    }

    public void clickOnContinue()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE));
        driver.findElement(CONTINUE).click();
    }
}

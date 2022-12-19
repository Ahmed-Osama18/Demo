package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait webDriverWait;

    By FIRST_PRODUCT_NAME = By.xpath("//a[@href=\"/product_details/1\"]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public String getProductNameInCartPage(int index)
    {
        return driver.findElement(By.xpath("//a[@href=\"/product_details/"+index+"\"]")).getText();
    }

    public String getProductPriceInCartPage(int index)
    {
        return driver.findElement(By.xpath("//tr[@id=\"product-"+index+"\"]/td[@class=\"cart_price\"]/p")).getText();

    }

    public String getProductQuantityInCartPage(int index)
    {
        return driver.findElement(By.xpath("//tr[@id=\"product-"+index+"\"]/td[@class=\"cart_quantity\"]/button")).getText();

    }

    public String getProductTotalPriceInCartPage(int index)
    {
        return driver.findElement(By.xpath("//tr[@id=\"product-"+index+"\"]/td[@class=\"cart_total\"]/p")).getText();

    }
}

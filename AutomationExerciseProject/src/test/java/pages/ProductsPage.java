package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    By ALL_PRODUCTS = By.xpath("//h2[@class=\"title text-center\"]");
    By SEARCHED_PRODUCTS = By.xpath("//h2[@class=\"title text-center\"]");

    By SEARCH_BAR = By.id("search_product");
    By SEARCH_CLICK = By.id("submit_search");
    By PRODUCTS = By.xpath("//div[@class='productinfo text-center']//p");
    By FIRSTPRODUCT = By.xpath("//a[@data-product-id=\"1\"]");
    By CONTINUE_SHOPPING = By.xpath("//button[@data-dismiss=\"modal\"]");
    By SECOUNDPRODUCT = By.xpath("//a[@data-product-id=\"2\"]");
    By VIEWCART = By.xpath("//a[@href=\"/view_cart\"]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public String validateAllProducts(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ALL_PRODUCTS));
        return driver.findElement(ALL_PRODUCTS).getText();
    }

    public String validateSearchedProducts(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SEARCHED_PRODUCTS));
        return driver.findElement(SEARCHED_PRODUCTS).getText();
    }

    public void searchBar(String item){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(SEARCH_BAR));
        driver.findElement(SEARCH_BAR).sendKeys(item);
        driver.findElement(SEARCH_CLICK).click();
    }

    public List<WebElement> products(){
        return driver.findElements(PRODUCTS);
    }

    public void hoverOnFirstProduct()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(FIRSTPRODUCT));
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(FIRSTPRODUCT)).perform();
    }

    public void addFirstProductToCart()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(FIRSTPRODUCT));
        driver.findElement(FIRSTPRODUCT).click();
    }

    public void continueShopping()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(CONTINUE_SHOPPING));
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public void hoverOnSecoundProduct()
    {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SECOUNDPRODUCT));
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(SECOUNDPRODUCT)).perform();
    }

    public void addSecoundProductToCart()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(SECOUNDPRODUCT));
        driver.findElement(SECOUNDPRODUCT).click();
    }

    public void clickOnViewCart()
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(VIEWCART));
        driver.findElement(VIEWCART).click();
    }

    public WebElement getProductName(int index)
    {
       return driver.findElement(By.xpath("//a[@data-product-id="+index+"]//parent::div//p"));

    }

    public WebElement getProductPrice(int index)
    {
        return driver.findElement(By.xpath("//a[@data-product-id="+index+"]//parent::div//h2"));

    }

}

package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProductsPage;
import pages.HomePage;

import java.time.Duration;

public class SearchTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    HomePage homePage;
    ProductsPage productsPage;
    String URL = "https://automationexercise.com/";
    String title = "men";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get(URL);

        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void validateSearchProductsResult() {
        Assert.assertEquals(driver.getCurrentUrl(), URL);
        homePage.products().click();
        Assert.assertEquals(productsPage.validateAllProducts(), "ALL PRODUCTS");
        productsPage.searchBar(title);
        Assert.assertEquals(productsPage.validateSearchedProducts(), "SEARCHED PRODUCTS");

        System.out.println("Number of results: "+ productsPage.products().size());

        SoftAssert softAssert = new SoftAssert();
        System.out.println("Results are: ");
        for (int i = 0; i < productsPage.products().size(); i++)
        {
            String product_title = productsPage.products().get(i).getText();
            System.out.println("           [" + productsPage.products().get(i).getText() + "]");
            softAssert.assertEquals(product_title.toLowerCase().contains(title),true,"This product doesn't contain "+title);
        }
        softAssert.assertAll();
    }

    @AfterClass
    public void quitDriver()
    {
        homePage.quit();
    }
}

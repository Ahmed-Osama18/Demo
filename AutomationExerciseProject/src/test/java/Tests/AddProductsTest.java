package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

import javax.swing.*;
import java.time.Duration;

public class AddProductsTest {
    String URL = "https://automationexercise.com/";
    WebDriver driver;
    WebDriverWait webDriverWait;
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;
    String first_product_name;
    int first_product_price_in_productpage=0;
    int first_qty=0;
    int first_product_counter=0;
    int first_product_total_expected=0;
    int first_total_product_price_actual=0;
    int first_product_price_in_cartpage=0;

    String second_product_name;
    int second_product_price_in_productpage=0;
    int second_total_product_price_actual=0;
    int second_qty=0;
    int second_product_counter=0;
    int second_product_total_expected=0;
    int second_product_price_in_cartpage=0;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get(URL);
        homePage = new HomePage(driver);

        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void validateSearchProductsResult() {
        first_product_name = productsPage.getProductName(1).getText();
        second_product_name = productsPage.getProductName(2).getText();

        String price= productsPage.getProductPrice(1).getText();
        first_product_price_in_productpage = Integer.parseInt(price.replaceAll("[^0-9]",""));
        price =productsPage.getProductPrice(2).getText();
        second_product_price_in_productpage = Integer.parseInt(price.replaceAll("[^0-9]",""));


        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(driver.getCurrentUrl(), URL);
        homePage.products().click();

        productsPage.hoverOnFirstProduct();
        productsPage.addFirstProductToCart();
        first_product_counter++;
        System.out.println(first_product_name + " costs: " + first_product_price_in_productpage + " added to cart");
        productsPage.continueShopping();

        productsPage.hoverOnSecoundProduct();
        productsPage.addSecoundProductToCart();
        second_product_counter++;
        productsPage.continueShopping();

        productsPage.hoverOnSecoundProduct();
        productsPage.addSecoundProductToCart();
        second_product_counter++;

        System.out.println(second_product_name + " costs: " + second_product_price_in_productpage + " added to cart");
        productsPage.continueShopping();

        productsPage.clickOnViewCart();

        price = cartPage.getProductPriceInCartPage(1);
        first_product_price_in_cartpage = Integer.parseInt(price.replaceAll("[^0-9]",""));
        price = cartPage.getProductPriceInCartPage(2);
        second_product_price_in_cartpage = Integer.parseInt(price.replaceAll("[^0-9]",""));

        softAssert.assertEquals(cartPage.getProductNameInCartPage(1),first_product_name,"added product not the same one in cart");
        softAssert.assertEquals(cartPage.getProductNameInCartPage(2),second_product_name,"added product not the same one in cart");

        softAssert.assertEquals(first_product_price_in_cartpage,first_product_price_in_productpage);
        softAssert.assertEquals(second_product_price_in_cartpage,second_product_price_in_productpage);

        System.out.println("First item quantity: " + cartPage.getProductQuantityInCartPage(1));
        System.out.println("Second item quantity: " + cartPage.getProductQuantityInCartPage(2));
        softAssert.assertEquals(Integer.parseInt(cartPage.getProductQuantityInCartPage(1)),first_product_counter);
        softAssert.assertEquals(Integer.parseInt(cartPage.getProductQuantityInCartPage(2)),second_product_counter);


        first_qty = Integer.parseInt(cartPage.getProductQuantityInCartPage(1));
        second_qty = Integer.parseInt(cartPage.getProductQuantityInCartPage(2));

        first_product_total_expected = (first_qty * first_product_price_in_cartpage);
        second_product_total_expected = (second_qty * second_product_price_in_cartpage);

        price = cartPage.getProductTotalPriceInCartPage(1);
        first_total_product_price_actual = Integer.parseInt(price.replaceAll("[^0-9]",""));
        System.out.println("first total expected " + first_product_total_expected+" first total actual " + first_product_total_expected);
        price = cartPage.getProductTotalPriceInCartPage(2);
        second_total_product_price_actual = Integer.parseInt(price.replaceAll("[^0-9]",""));
        System.out.println("second total expected " + second_product_total_expected+" second total actual " + second_product_total_expected);

        softAssert.assertEquals(first_total_product_price_actual, first_product_total_expected);
        softAssert.assertEquals(second_total_product_price_actual, second_product_total_expected);

        softAssert.assertAll();
    }

    @AfterClass
    public void quitDriver()
    {
        homePage.quit();
    }
}

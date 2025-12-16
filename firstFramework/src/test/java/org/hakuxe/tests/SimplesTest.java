package org.hakuxe.tests;

import pages.CartPage;
import pages.CheckoutPage;
import pages.DashboardPage;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.components.HeaderComponent;
import pages.components.ToastComponent;

import java.time.Duration;
import java.util.List;

public class SimplesTest {

    static WebDriver driver = null;

    @AfterTest
    public void finish() {
        driver.quit();
    }

    @Test
    public void simpleTest() throws InterruptedException {

        String user = "xapaco9852@bipochub.com";
        String pass = "Test@12345678";
        String productName = "ZARA COAT 3";

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);

        HeaderComponent headerComponent = new HeaderComponent(driver);
        ToastComponent toastComponent = new ToastComponent(driver);

        driver.get("https://rahulshettyacademy.com/client/#/auth/login");

        DashboardPage dashboardPage = loginPage.loginWithUserAndPassword(user, pass);

        List<WebElement> products = dashboardPage.getProducts();
        dashboardPage.addToCart(productName);

        CartPage cartPage = headerComponent.goToCartPage();

        List<WebElement> cartProducts = cartPage.getCartProducts();
        boolean isInCart = cartPage.checkIfProductIsInCart(productName);

        Assert.assertTrue(isInCart);


        CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
        checkoutPage.selectCountry("Brazil");


        checkoutPage.placeOrder();

        String placedOrderMessage = toastComponent.getToastMessage();

        Assert.assertEquals(placedOrderMessage.trim(), "Order Placed Successfully");


    }
}

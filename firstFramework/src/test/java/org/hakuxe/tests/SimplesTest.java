package org.hakuxe.tests;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.DashboardPage;
import pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.components.HeaderComponent;
import pages.components.ToastComponent;


import java.util.List;

public class SimplesTest extends BaseTest {


    @Test
    public void simpleTest() {

        String user = "xapaco9852@bipochub.com";
        String pass = "Test@12345678";
        String productName = "ZARA COAT 3";
        

        LoginPage loginPage = new LoginPage(driver);
        HeaderComponent headerComponent = new HeaderComponent(driver);
        ToastComponent toastComponent = new ToastComponent(driver);

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

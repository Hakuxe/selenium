package org.hakuxe.tests;

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://rahulshettyacademy.com/client/#/auth/login");

        loginPage.loginWithUserAndPassword(user, pass);



        By card = By.cssSelector(".card-body");

        wait.until(ExpectedConditions.visibilityOfElementLocated(card));
        List<WebElement> products = driver.findElements(card);


        for (WebElement el : products) {
            String text = el.findElement(By.tagName("h5")).getText();

            if (text.equalsIgnoreCase(productName)) {
                el.findElement(By.cssSelector("button>i.fa-shopping-cart")).click();
            }
        }

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();

        Thread.sleep(5000);

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

        boolean isInCart = cartProducts.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));

        Assert.assertTrue(isInCart);


        driver.findElement(By.cssSelector("div.subtotal button")).click();
        driver.findElement(By.cssSelector("div.user__name div.user__address input")).sendKeys("Brazil");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.ta-results button")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.action__submit")));
        driver.findElement(By.cssSelector("section.ta-results button")).click();

        new Actions(driver)
                .scrollToElement(driver.findElement(By.cssSelector("a.action__submit")))
                .perform();

        driver.findElement(By.cssSelector("a.action__submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        String placedOrderMessage = driver.findElement(By.id("toast-container")).getText();

        Assert.assertEquals(placedOrderMessage.trim(), "Order Placed Successfully");


    }
}

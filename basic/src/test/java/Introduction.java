import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Introduction {


    public static void main(String[] args) {

        // config sem usar o Selenium Manager
        //System.getProperty("webdriver.chrome.driver", Localização do chromedriver.exe)


        // https://rahulshettyacademy.com/locatorspractice/
        // user: rahulshettyacademy
        // password: rahulshettyacademy


        String dynamicPassword;

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(4)));


        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


        // find element
        driver.findElement(By.id("inputUsername")).sendKeys("hello");
        driver.findElement(By.name("inputPassword")).sendKeys("hello");
        driver.findElement(By.className("submit")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        ;

        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9843834343");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();


        dynamicPassword = getPassword(driver);


        driver.findElement(By.xpath("//div[@class = 'forgot-pwd-btn-conainer']/button[1]")).click();
        driver.findElement(By.id("inputUsername")).sendKeys("rahulshettyacademy");
        driver.findElement(By.name("inputPassword")).sendKeys(dynamicPassword);
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String expected = "You are successfully logged in.";
        Assert.assertEquals(driver.findElement(By.cssSelector(".App p")).getText(), expected);


        //fechar o browser
        driver.quit();
    }

    public static String getPassword(WebDriver driver) {
        String dynamicPassword = driver.findElement(By.cssSelector("form p.infoMsg")).getText();
        return dynamicPassword.split("'")[1];
    }
}

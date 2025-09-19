import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

public class Introduction {

    public static void main(String[] args) {

        // config sem usar o Selenium Manager
        //System.getProperty("webdriver.chrome.driver", Localização do chromedriver.exe)


        // https://rahulshettyacademy.com/locatorspractice/
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(4)));


        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


        // find element
        driver.findElement(By.id("inputUsername")).sendKeys("hello");
        driver.findElement(By.name("inputPassword")).sendKeys("hello");
        driver.findElement(By.className("submit")).click();


        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());;






        //fechar o browser
        driver.quit();
    }
}

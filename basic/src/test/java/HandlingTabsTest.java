import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingTabsTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));      // WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com//loginpagePractise/");

        driver.findElement(By.cssSelector("a.blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parentWindow = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.im-para.red a")));
        String text = driver.findElement(By.cssSelector("p.im-para.red")).getText();

        Arrays.asList(text.split(" ")).forEach(item -> {
            if(item.contains("@")){
                System.out.println(item);
                return;
            }
           
        });

        String email = driver.findElement(By.cssSelector("p.im-para.red a")).getText();

        System.out.println(email);

        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("username")).sendKeys(email);

        driver.quit();
    }

    
}

package challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class IframeChallenge {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        driver.quit();
    }
}

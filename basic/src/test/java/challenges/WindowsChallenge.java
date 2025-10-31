package challenges;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class WindowsChallenge {
    public static void main(String[] args) {
         ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:/chrome-versions/114.0.5734.0/chrome.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    

        driver.findElement(By.cssSelector("a[href='/windows']")).click();
        driver.findElement(By.cssSelector("#content a")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        By tagH3 = By.tagName("h3");

        driver.switchTo().window(childWindow);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(tagH3));
        String textChildWindow = driver.findElement(tagH3).getText();
    
        driver.switchTo().window(parentWindow);
        String textParentWindow = driver.findElement(tagH3).getText();

        System.out.println(textChildWindow);
        System.out.println(textParentWindow);

        Assert.assertEquals(textChildWindow, "New Window");
        Assert.assertEquals(textParentWindow, "Opening a new window");

    

        driver.quit();
    }
}

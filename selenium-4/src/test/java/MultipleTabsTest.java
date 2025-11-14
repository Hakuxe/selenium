import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class MultipleTabsTest {

    @Test
    public void handlingMultipleTabs() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parentWindowId = it.next();
        String childWindowId = it.next();

        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com");
        String firstCourseName = driver.findElement(By.xpath("(//button[text() = 'Enroll Now'])[1]/../../h3")).getText();

        driver.switchTo().window(parentWindowId);
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(firstCourseName);



        driver.quit();
    }

    @Test
    public void handlingWithoutTheFeatureMultipleTabs() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // get course name
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.get("https://rahulshettyacademy.com");
        String firstCourseName = driver.findElement(By.xpath("(//button[text() = 'Enroll Now'])[1]/../../h3")).getText();

        driver.navigate().back();
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(firstCourseName);


        driver.quit();

    }

}

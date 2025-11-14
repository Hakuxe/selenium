import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class PartialScreenshotTest {

    @Test
    public void captureElementScreenshot() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement inputName = driver.findElement(By.cssSelector("[name='name']"));
        inputName.sendKeys("Leonard");


        // take a screenshot of the input with the name "Leonard" in it
        File screenshotInput = inputName.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotInput, new File("./target/screenshots/inputName.png"));

        driver.quit();
    }
}

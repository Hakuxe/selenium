package challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AutocompleteTest {

    @Test
    public void countRows() {

        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String expectedCountry = "United Kingdom (UK)";

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys("United");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//div[text()='United Kingdom (UK)']")));
        WebElement option = driver.findElement(By.xpath("//li//div[text()='%s']".formatted(expectedCountry)));

        actions.moveToElement(option).click().perform();

        WebElement el = driver.findElement(By.id("autocomplete"));
        String selectedText = el.getAttribute("value");

        Assert.assertEquals(selectedText, expectedCountry);


        driver.quit();

    }

}

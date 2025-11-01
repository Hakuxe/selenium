package challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TablesTest {

    @Test
    public void countRows(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> allRows =  driver.findElements(By.cssSelector("#product.table-display tr"));

        int  totalOfRows = allRows.size();
        int  totalOfCols = driver.findElements(By.cssSelector("#product.table-display th")).size();

        Assert.assertEquals(totalOfRows, 11);
        Assert.assertEquals(totalOfCols, 3);

        allRows.get(2).findElements(By.tagName("td")).forEach(item -> System.out.println(item.getText()));


        driver.quit();

    }

}

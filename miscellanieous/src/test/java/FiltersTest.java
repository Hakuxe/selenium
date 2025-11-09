import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.List;


public class FiltersTest {

    @Test
    public void handleFilter() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String searchElement = "ch";

        driver.findElement(By.id("search-field")).sendKeys(searchElement);

        List<WebElement> names = driver.findElements(By.xpath("//tr/td[1]"));


        // generic approach
        SoftAssert softAssert = new SoftAssert();

        names.forEach(name ->
                softAssert.assertTrue(
                        name.getText().toUpperCase().contains(searchElement.toUpperCase()),
                        String.format("'%s' doesn't contain text '%s' ", name.getText(), searchElement)
                )
        );

        System.out.println(names.size());
        softAssert.assertAll();


        // Approach without softAssert
        List<WebElement> filteredList = names.stream().filter(webElement ->
                webElement.getText().toUpperCase().contains(searchElement.toUpperCase())
        ).toList();

        Assert.assertEquals(filteredList.size(), names.size());


        driver.quit();
    }

}

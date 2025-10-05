package challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SelectChallenge {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        // Autocomplete - autosuggestive
        String country = "india";
        driver.findElement(By.xpath("//div[@id='header']//input[@id='autosuggest']")).sendKeys(country);
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
        List<WebElement> optionsCss = driver.findElements(By.cssSelector("li.ui-menu-item>a"));


        options.forEach(element -> {
            if (country.equalsIgnoreCase(element.getText())) {
                element.click();
            }
        });



        String inputValue = driver.findElement(By.xpath("//div[@id='header']//input[@id='autosuggest']")).getAttribute("value");
        Assert.assertEquals(inputValue, "India");


        driver.quit();

    }
}

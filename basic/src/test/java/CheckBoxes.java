import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CheckBoxes {

    public static void main(String[] args) {

        WebDriver driver=  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        boolean isFriendsAndFamilyChecked = driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected();
        boolean isSeniorCitizenChecked = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();



        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='discount-checkbox']//input[@type='checkbox']"));

        for(WebElement el : checkboxes){
            System.out.println(el.isSelected());
        }

        Assert.assertTrue(isFriendsAndFamilyChecked);
        Assert.assertFalse(isSeniorCitizenChecked);


         driver.quit();
    }
}

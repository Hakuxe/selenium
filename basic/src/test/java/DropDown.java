import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        /*


        // Static dropdowns = class Select
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdownStatic = new Select(staticDropdown);

        // select by index
        dropdownStatic.selectByIndex(3);
        System.out.println(dropdownStatic.getFirstSelectedOption().getText());

        // by text
        dropdownStatic.selectByVisibleText("AED");
        System.out.println(dropdownStatic.getFirstSelectedOption().getText());

        // by value
        dropdownStatic.selectByValue("INR");
        System.out.println(dropdownStatic.getFirstSelectedOption().getText());


         */


        // Dynamic Dropdown

        driver.findElement(By.cssSelector("#marketCityPair_1 #ctl00_mainContent_ddl_originStation1_CTXT")).click();

//        Select dynamicDropDown = new Select(driver.findElement(By.cssSelector("#marketCityPair_1 #ctl00_mainContent_ddl_originStation1")));
//        dynamicDropDown.selectByVisibleText("Delhi (DEL)");
        driver.findElement(By.cssSelector(".left1 a[value='DEL']")).click();
        driver.findElement(By.cssSelector(".right1 a[value='DEL']")).click();



        driver.quit();
    }
}

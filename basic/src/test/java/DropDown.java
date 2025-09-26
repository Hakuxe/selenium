import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


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





        // Dynamic Dropdown
        driver.findElement(By.cssSelector("#marketCityPair_1 #ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();




        // Autocomplete - autosuggestive
        String country = "india";
        driver.findElement(By.xpath("//div[@id='header']//input[@id='autosuggest']")).sendKeys(country);
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
        List<WebElement> optionsCss = driver.findElements(By.cssSelector("li.ui-menu-item>a"));


        options.forEach( element ->{
            if(country.equalsIgnoreCase(element.getText())){
                element.click();
            }
        });

     /*   for(WebElement option: optionsCss){
            if(country.equalsIgnoreCase(option.getText())){
                System.out.println(option.getText());
            }
        }*/

        String inputValue = driver.findElement(By.xpath("//div[@id='header']//input[@id='autosuggest']")).getAttribute("value");
        Assert.assertEquals(inputValue, "India");








        driver.quit();
    }
}

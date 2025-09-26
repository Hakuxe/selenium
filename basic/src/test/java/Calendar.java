import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        // Dynamic Dropdown
        driver.findElement(By.cssSelector("#marketCityPair_1 #ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();



        driver.findElement(By.cssSelector(".ui-state-active")).click();

        driver.quit();
    }
}

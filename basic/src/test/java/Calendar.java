import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // Dynamic Dropdown
        //driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        driver.findElement(By.cssSelector("#marketCityPair_1 #ctl00_mainContent_ddl_originStation1_CTXT")).click();
//
//        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='DEL']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
//
//        driver.findElement(By.cssSelector(".ui-state-active")).click();

        // new challenge

        String monthNumber = "6";
        String date = "15";
        String year = "2027";


        driver.get(" https://rahulshettyacademy.com/seleniumPractise/#/offers");


        driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[contains(text(),'" + year + "')]")).click();

        WebElement month = driver.findElements(By.cssSelector("button.react-calendar__year-view__months__month"))
                .get(Integer.parseInt(monthNumber) - 1);
        month.click();

        driver.findElement(By.xpath("//abbr[contains(text(),'" + date + "')]")).click();


        // assert actualMonth
        String actualMonth = driver.findElement(By.cssSelector("input.react-date-picker__inputGroup__month"))
                .getDomAttribute("value");
        String actualDate = driver.findElement(By.cssSelector("input.react-date-picker__inputGroup__day"))
                .getDomAttribute("value");
        String actualYear = driver.findElement(By.cssSelector("input.react-date-picker__inputGroup__year"))
                .getDomAttribute("value");

        Assert.assertEquals(actualDate, date);
        Assert.assertEquals(actualMonth, monthNumber);
        Assert.assertEquals(actualYear, year);


        Thread.sleep(3000);


        driver.quit();
    }
}

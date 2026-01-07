import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ConsoleErrorTest {

    private ChromeDriver driver = null;

    @BeforeTest
    public void init(){
        driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

    @Test
    public void getConsoleError(){
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector("p>a[href='/angularAppdemo/products']")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector("button.add-to-cart")).click();
        driver.findElement(By.cssSelector("a[href='/angularAppdemo/cart']")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");



        //Get logs from the browser
        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);

        // get each log into a list
        List<LogEntry> logs = entries.getAll();

        System.out.println("Logs: ");
        // output logs in the console
        for (LogEntry entry:  logs){
            Date date = new Date(entry.getTimestamp());
            Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            System.out.println(entry.getMessage());
            System.out.println(entry.getLevel() );
            System.out.println(format.format(date));

        }

    }
}

package challenges;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SynchroniationChallenge {

    // rahulshettyacademy
    // "learning"

    public static void main(String[] args) {
        final String user = "rahulshettyacademy";
        final String pass = "learning";
        String[] itens = { "IPHONE X", "SAMSUNG NOTE 8" };

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com//loginpagePractise/");

        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);

        driver.findElement(By.cssSelector("input[value='user']")).click();

        // alert
        driver.findElement(By.id("okayBtn")).click();

        Select select = new Select(driver.findElement(By.cssSelector("select.form-control")));
        select.selectByVisibleText("Consultant");

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card.h-100")));

        addItensByName(driver, itens);
        //  addAllItensOnScreen(driver);

        
        Assert.assertTrue(driver.findElement(By.cssSelector("a.nav-link.btn")).getText().contains("Checkout ( 2 )"));

    
        driver.quit();
    }

    public static void addAllItensOnScreen(WebDriver driver) {
         List<WebElement> productsOnScreen = driver.findElements(By.cssSelector(".card.h-100"));

         for (int i = 0; i < productsOnScreen.size(); i++) {
             productsOnScreen.get(i).findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
            
        }
    }

    public static void addItensByName(WebDriver driver, String[] itens) {
        List<String> itensNeeded = Arrays.asList(itens);
        List<WebElement> productsOnScreen = driver.findElements(By.cssSelector(".card.h-100"));
    
        for (int i = 0; i < itensNeeded.size(); i++) {
            String productName = productsOnScreen.get(i).findElement(By.cssSelector("h4.card-title a")).getText();
            if (itensNeeded.contains(productName.toUpperCase())) {
                productsOnScreen.get(i).findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
            }
        }
    }

    public static void sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com//loginpagePractise/");


        WebElement labelUsername = driver.findElement(By.cssSelector("[for=\"username\"]"));
        By inputUsername = RelativeLocator.with(By.tagName("input")).below(labelUsername);

        WebElement inputPassword = driver.findElement(By.id("password"));
        By labelPassword  = RelativeLocator.with(By.tagName("label")).above(inputPassword);


        // Achar o radio que está a esquerda do span com texto  User
        By radioAdmin = RelativeLocator.with(By.tagName("input")).toLeftOf(By.xpath("//span[text()= ' User']"));


        // Achar o texto que está a direita do elemento com id terms
        By textTerms = RelativeLocator.with(By.tagName("a")).toRightOf(By.id("terms"));



        driver.findElement(inputUsername).sendKeys("hello");
        driver.findElement(radioAdmin).click();
        System.out.println( driver.findElement(labelPassword).getText());
        System.out.println( driver.findElement(textTerms).getText());


        driver.quit();
    }
}

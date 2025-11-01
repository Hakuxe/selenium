import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class IframesTest {
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));


        Actions actions = new Actions(driver);    

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source, target).perform();

        // sair do iframe
        driver.switchTo().defaultContent();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        driver.quit();
    }
}

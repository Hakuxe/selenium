import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;

public class FluentWaitStudy {

    public static void main(String[] args) {

        // Fluent wait: Permite monitorar um elemento por mudanças

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start button")).click();

        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(1))
                        .ignoring(ElementNotInteractableException.class);


        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));

        wait.until(d -> {
            By message = By.cssSelector("#finish h4");
            WebElement element = d.findElement(message);

            if (element.isDisplayed() && element.isEnabled()) {
                System.out.println("hello" + element.getText());
            }


            return true;
        });


        driver.quit();
    }

}

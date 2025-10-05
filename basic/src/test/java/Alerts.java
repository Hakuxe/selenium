import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alerts {

    @Test
    public void handlingAlerts(){
        String alertMessage = "";
        String expectedMessage = "Hello , share this practice page and share your knowledge";
        String expectedMessage2 = "Hello , Are you sure you want to confirm?";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("alertbtn")).click();


        // mudar o contexto para o alert
        alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(alertMessage, expectedMessage);

        // Cancelar
        driver.findElement(By.id("confirmbtn")).click();
        alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(alertMessage, expectedMessage2);





        driver.quit();
    }

}

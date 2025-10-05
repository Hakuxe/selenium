import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CssChange {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        // pega o estilo do elemento
        String elementCssStyle = driver.findElement(By.id("Div1")).getDomAttribute("style");

        // elemento css : display: block; opacity: 0.5;
        // elemento css enabled: display: block; opacity: 1;
        if(elementCssStyle != null && elementCssStyle.contains("opacity: 1")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }



        driver.quit();
    }
}

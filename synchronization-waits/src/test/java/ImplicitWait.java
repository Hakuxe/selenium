import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImplicitWait {

    public static void main(String[] args) {
        // Implicit Wait: você define uma espera de x segundos antes do selenium lançar um erro


        // Explicit wait; Geralmente usado em específico para um elemento (usar se o sistema não for uma tartaruga)

        // Fluent wait:

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");


        String[] itemsNeeded = {"cucumber", "brocolli"};
        addItens(driver, itemsNeeded);

        driver.findElement(By.cssSelector("a.cart-icon")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();


        // explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());



        driver.quit();
    }

    public static void addItens(WebDriver driver, String[] itemsNeeded){
        List<String> itemsNeededList = Arrays.asList(itemsNeeded);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int counter = 0;

        for (int i = 0; i < products.size(); i++) {

            String name = products.get(i).getText().split("-")[0].trim();

            counter++;

            if (itemsNeededList.contains(name.toLowerCase())) {
                driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();

                if (counter > itemsNeededList.size()) {
                    break;
                }
            }
        }
    }

}

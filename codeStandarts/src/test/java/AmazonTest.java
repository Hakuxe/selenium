import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AmazonTest {

    // Criar um código genérico para adicionar vários itens num carrinho de compras
        // A lista de itens(itemsNeeded) pode mudar a qualquer momento

    @Test
    public void addProductsToCart() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");


        // Saves more memory them using a list
        String[] itemsNeeded = {"cucumber", "brocolli"};
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


        driver.quit();
    }


}

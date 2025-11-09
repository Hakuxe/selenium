import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PaginationTest {


    @Test
    public void handlePagination() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");


        driver.findElement(By.xpath("//th[1]")).click();


        String myProduct = "Pineapple";

        List<WebElement> productNames;
        List<WebElement> filteredList;
        List<String> prices = new ArrayList<>();

        Map<String, String> productMap = Map.of();

        do {
            productNames = driver.findElements(By.xpath("//tr/td[1]"));
            filteredList = productNames.stream()
                    .filter(webElement -> webElement.getText().contains(myProduct)).toList();

            if (!filteredList.isEmpty()) {
                prices = filteredList.stream()
                        .map(el -> el.findElement(By.xpath("parent::tr//td[2]")).getText()).toList();

                productMap = filteredList.stream()
                        .collect(Collectors.toMap(WebElement::getText, el -> el.findElement(By.xpath("parent::tr//td[2]")).getText()));

            }

            // avança próxima página
            driver.findElement(By.xpath("//a[@aria-label='Next']")).click();

        } while (filteredList.isEmpty());


        prices.forEach(System.out::println);
        productMap.forEach((name, price) -> System.out.printf("%s : $%s\n\n", name, price));

        Assert.assertEquals(prices.getFirst(), "44");


        driver.quit();
    }

}

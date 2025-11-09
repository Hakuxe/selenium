import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingTable {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");


        // click on column name
        driver.findElement(By.xpath("//th[1]")).click();

        // capture all elements
        List<WebElement> firstColumn = driver.findElements(By.xpath("//tr//td[1]"));

        // get the text from all the elements
        List<String> originalList = firstColumn.stream().map(WebElement::getText).toList();

        // create a sorted list with the text
        List<String> sortedList = originalList.stream().sorted().toList();

        // compare the sorted list with the list of web elements
        Assert.assertEquals(sortedList, originalList);


        List<String> prices = firstColumn.stream()
                .filter(webElement -> webElement.getText().contains("Beans"))
                .map(webElement -> {
                    String price = webElement.findElement(By.xpath("following-sibling::td[1]")).getText();
                    return webElement.findElement(By.xpath("parent::tr/td[2]")).getText();
                }).toList();

        Map<String, String> pricesMap = firstColumn.stream()
                .filter(webElement -> webElement.getText().contains("Beans"))
                .collect(Collectors.toMap(WebElement::getText, webElement -> webElement.findElement(By.xpath("parent::tr/td[2]")).getText()));


        prices.forEach(System.out::println);
        pricesMap.forEach((name, price) -> System.out.printf("%s : $%s\n\n", name, price));

        driver.quit();

    }
}

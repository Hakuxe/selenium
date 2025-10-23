package challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CountAllLinksInPage {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // get all links
        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());
        System.out.printf("Links: %s\n", driver.findElements(By.tagName("a")).size());

        // get all links inside the footer
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        System.out.printf("Links no footer: %s\n", footer.findElements(By.tagName("a")).size());

        // get all links inside discount coupons sections
        WebElement ul = footer.findElement(By.tagName("ul"));
        System.out.printf("Links discount coupons: %s\n", ul.findElements(By.tagName("a")).size());

        //Abrir todos os links
        List<WebElement> links = ul.findElements(By.tagName("a"));
        Actions actions = new Actions(driver);

        links.forEach(link -> {
            // abrir em outra aba (MACETE)
            actions.keyDown(Keys.CONTROL).click(link).perform();
        });

        Set<String> tabs =  driver.getWindowHandles();
        Iterator<String> it = tabs.iterator();

        it.forEachRemaining( item -> {
            System.out.printf("%s\n", driver.switchTo().window(item).getTitle());
        });


        System.out.printf("Tabs opened: %s", driver.getWindowHandles().size());



        driver.quit();
    }
}

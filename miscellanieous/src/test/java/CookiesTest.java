import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class CookiesTest {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);


        driver.manage().deleteAllCookies(); // deletar todos os cookies
        driver.manage().deleteCookieNamed("cookie name"); //Deletar um cookie específico


        driver.get("https://expired.badssl.com/");

        System.out.println(driver.getTitle());


        driver.quit();
    }

}

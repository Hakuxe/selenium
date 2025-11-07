import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class HttpsCertificate {

    public static void main(String[] args) {

        // Definir comportamentos para o chrome do selenium
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); // aceitar página http waring: Your connection is not private

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://expired.badssl.com/");

        System.out.println(driver.getTitle());


        driver.quit();
    }
}

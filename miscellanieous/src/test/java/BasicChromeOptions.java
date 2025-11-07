import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class BasicChromeOptions {

    public static void main(String[] args) {

        // Definir comportamentos para o chrome do selenium
        ChromeOptions options = new ChromeOptions();


        options.addArguments("start-maximized"); // Iniciar máximizado
        options.setAcceptInsecureCerts(true); // aceitar página http waring: Your connection is not private
        options.setBinary("/path/to/other/chrome/binary"); // caminho do executável do chrome

        // Bloquear pop-ups do chrome
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://expired.badssl.com/");

        System.out.println(driver.getTitle());


        driver.quit();
    }

}

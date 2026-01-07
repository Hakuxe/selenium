package network;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v142.network.Network;

import java.util.Arrays;
import java.util.Optional;

public class BlockNetWorkRequestTest {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
        DevTools devTools = driver.getDevTools();

        devTools.createSession();
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        // bloquear qualquer request que tenha css ou webp no nome
        devTools.send(Network.setBlockedURLs(Arrays.asList("*css", "*webp")));

        driver.get("https://rahulshettyacademy.com/client/#/auth/login");


        driver.findElement(By.id("userEmail")).sendKeys("xapaco9852@bipochub.com");
        driver.findElement(By.id("userPassword")).sendKeys("Test@12345678");


        //driver.quit();
    }
}

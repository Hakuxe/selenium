import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v142.emulation.Emulation;

import java.util.Optional;

public class BasicChromeDevToolsTest {

    public static void main(String[] args) {

        // Webdriver não suporta o dev tools
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();

        // criando uam sessão para controlar o chrome dev tools
        devTools.createSession();

        // mandar comandos para o chrome dev tools
        // https://chromedevtools.github.io/devtools-protocol/
        devTools.send(Emulation.setDeviceMetricsOverride(
                384,
                854,
                50,
                true,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty())
        );


        driver.manage().window().maximize();


        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector("button.hover\\:text-accent-foreground")).click();
        driver.findElement(By.cssSelector("a.gap-2:nth-child(3)")).click();

        String url = driver.getCurrentUrl();

        System.out.println(url);


        driver.quit();
    }

}

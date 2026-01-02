import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v142.emulation.Emulation;

public class GeoLocationTest {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> geo = new HashMap<>();
        geo.put("latitude", 40);
        geo.put("longitude", 3);
        geo.put("accuracy", 1);

        //driver.executeCdpCommand("Emulation.setGeolocationOverride", geo);
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(40),
                Optional.of(3),
                Optional.of(1),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);

        String title = driver.findElement(By.cssSelector("h1.default-ltr-iqcdef-cache-4b5q1b")).getText();

        System.out.println(title);

        driver.quit();
    }
}

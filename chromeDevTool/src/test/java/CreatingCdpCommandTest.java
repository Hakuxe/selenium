import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;

import java.util.*;

public class CreatingCdpCommandTest {

    public static void main(String[] args) {

        // Webdriver não suporta o dev tools
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        driver.manage().window().maximize();

        devTools.createSession();

    /*  Manualmente

        Map<String, Object> deviceMetrics = new HashMap();
        deviceMetrics.put("width",  384);
        deviceMetrics.put("height",854);
        deviceMetrics.put("deviceScaleFactor",  50);
        deviceMetrics.put("mobile",true);

        // Name of the method and the params
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

    */

        // usando função
        devTools.send(mySetDeviceMetricsOverride(384, 854, 50, true));



        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector("button.hover\\:text-accent-foreground")).click();
        driver.findElement(By.cssSelector("a.gap-2:nth-child(3)")).click();

        String url = driver.getCurrentUrl();

        System.out.println(url);




        driver.quit();
    }

    public static Command<Void> mySetDeviceMetricsOverride(Integer width, Integer height, Number deviceScaleFactor, Boolean mobile) {

        Map<String, Object> params = new HashMap<>();
        params.put("width", width);
        params.put("height", height);
        params.put("deviceScaleFactor", deviceScaleFactor);
        params.put("mobile", mobile);


        return new Command<>("Emulation.setDeviceMetricsOverride", params);
    }



}

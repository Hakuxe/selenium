package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import org.testng.annotations.*;

public class BaseTest {

    private Properties properties;

    protected WebDriver driver = null;


    public void createDriver() {

        properties = new Properties();
        InputStream file = null;

        try {
            file = Files.newInputStream(Paths.get("globalProperties.properties"));
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String browser = properties.getProperty("browser");
        String timeout = properties.getProperty("timeout");

        if (browser.equalsIgnoreCase("CHROME")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            System.out.println("NO firefox");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(timeout)));
        driver.manage().window().maximize();
    }

    @BeforeMethod(alwaysRun = true)
    public void launchApplication(){
        createDriver();
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }

    @AfterTest(alwaysRun = true)
    public void finish() {
        driver.quit();
    }

}

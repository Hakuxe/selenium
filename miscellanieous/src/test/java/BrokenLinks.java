import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException, URISyntaxException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        SoftAssert softAssert = new SoftAssert();

        String url = "";

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("#gf-BIG li>a"));

        for (WebElement link: links){

            url = link.getDomAttribute("href");

            System.out.println(url);

            if(url.length() < 2){
                continue;
            }

            HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();

            System.out.println(responseCode);

            //Armazena todas as falhas
            softAssert.assertTrue(responseCode < 400,"link: " +link.getText() +" is broken with code:" + responseCode );

        }

        // verifica se algum dos testes falhou
        softAssert.assertAll();


        driver.quit();
    }

}

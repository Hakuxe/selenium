import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v142.fetch.Fetch;
import org.openqa.selenium.devtools.v142.fetch.model.RequestId;
import org.openqa.selenium.devtools.v142.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v142.network.Network;
import org.openqa.selenium.devtools.v142.network.model.ErrorReason;
import org.openqa.selenium.devtools.v142.network.model.Request;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FailNetworkRequestTest {

    public static void main(String[] args) {
        String user = "xapaco9852@bipochub.com";
        String pass = "Test@12345678";

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        //qualquer request que tenha *auth/login
        // para o resto pega o que tiver com o optional.empty
        List<RequestPattern> patterns = Arrays.asList( new RequestPattern(
                Optional.of("*auth/login"),
                Optional.empty(),
                Optional.empty()));

        // Só vai interceptar request que estejam no padrão
        devTools.send(Fetch.enable(
                Optional.of(patterns),
                Optional.empty()
        ));

        devTools.addListener(Fetch.requestPaused(), request ->{
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.ACCESSDENIED));

        });



        driver.get("https://rahulshettyacademy.com/client/#/auth/login");


        driver.findElement(By.id("userEmail")).sendKeys(user);
        driver.findElement(By.id("userPassword")).sendKeys(pass);
        driver.findElement(By.id("login")).click();




        driver.quit();


    }
}

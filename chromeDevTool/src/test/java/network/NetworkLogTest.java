package network;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v142.network.Network;
import org.openqa.selenium.devtools.v142.network.model.Request;
import org.openqa.selenium.devtools.v142.network.model.Response;

import java.util.Optional;

public class NetworkLogTest {

    public static void main(String[] args) {
        String user = "xapaco9852@bipochub.com";
        String pass = "Test@12345678";


        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // enabling network
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        // watching all requests being made
        devTools.addListener(Network.requestWillBeSent() , request -> {

            Request req =  request.getRequest();
//            System.out.println(req.getUrl());
//            System.out.println(req.getMethod());


        });

        // watching all responses received
        devTools.addListener(Network.responseReceived() , response -> {

           Response res =  response.getResponse();
           if(res.getUrl().contains("/api/ecom/auth/login")){
               System.out.println(res.getStatus());
               System.out.println(res.getStatusText());
               System.out.println(res.getConnectionId());
           }

        });


        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.findElement(By.id("userEmail")).sendKeys(user);
        driver.findElement(By.id("userPassword")).sendKeys(pass);
        driver.findElement(By.id("login")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.quit();
    }

}

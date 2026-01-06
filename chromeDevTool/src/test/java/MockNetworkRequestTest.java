import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v142.fetch.Fetch;
import org.openqa.selenium.devtools.v142.fetch.model.RequestId;
import org.openqa.selenium.devtools.v142.network.model.Request;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class MockNetworkRequestTest {

    // https://chromedevtools.github.io/devtools-protocol/tot/Fetch/

    public static void main(String[] args) {
        String user = "xapaco9852@bipochub.com";
        String pass = "Test@12345678";

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Wait<WebDriver>  wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // enabling network
        devTools.send(Fetch.enable(
                Optional.empty(),
                Optional.empty()
        ));


        // changing the data being sent to the request to cause a login error
//        devTools.addListener(Fetch.requestPaused(), request -> {
//            RequestId requestId = request.getRequestId();
//            String url = request.getRequest().getUrl();
//            Request req = request.getRequest();
//
//            if (url.contains("/api/ecom/auth/login")) {
//
//                String body = """
//                    {
//                        "userEmail":"afdfa@gmail.com",
//                        "userPassword":"dfdf"
//                    }
//                """;
//
//
//                devTools.send(Fetch.continueRequest(
//                        requestId,
//                        Optional.of(url),
//                        Optional.of(req.getMethod()),
//                        Optional.of(Base64.getEncoder().encodeToString(body.getBytes())),
//                        Optional.empty(),
//                        Optional.empty()
//                ));
//
//            } else {
//                devTools.send(Fetch.continueRequest(
//                        requestId,
//                        Optional.empty(),
//                        Optional.empty(),
//                        Optional.empty(),
//                        Optional.empty(),
//                        Optional.empty()
//                ));
//            }
//
//        });


        // Mocking request to get all product to return only one product
        devTools.addListener(Fetch.requestPaused(), request -> {
            String url = request.getRequest().getUrl();
            RequestId requestId = request.getRequestId();
            Request req = request.getRequest();

            String body = """
                {
                   "data":[
                      {
                         "_id":"68a961459320a140fe1ca57a",
                         "productName":"ZARA COAT 3",
                         "productCategory":"electronics",
                         "productSubCategory":"mobiles",
                         "productPrice":11500,
                         "productDescription":"Apple phone",
                         "productImage":"https://rahulshettyacademy.com/api/ecom/uploads/productImage_1650649434146.jpeg",
                         "productRating":"0",
                         "productTotalOrders":"0",
                         "productStatus":true,
                         "productFor":"women",
                         "productAddedBy":"admin",
                         "__v":0
                      }
                   ],
                   "count":3,
                   "message":"All Products fetched Successfully"
                }
            """;

            if (url.contains("/api/ecom/product/get-all-products")) {

                devTools.send(Fetch.fulfillRequest(
                        requestId,
                        200,
                        Optional.empty(),
                        Optional.empty(),
                        Optional.of(Base64.getEncoder().encodeToString(body.getBytes())),
                        Optional.empty()


                ));

            } else {
                devTools.send(Fetch.continueRequest(
                        requestId,
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()
                ));
            }
        });


        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.findElement(By.id("userEmail")).sendKeys(user);
        driver.findElement(By.id("userPassword")).sendKeys(pass);
        driver.findElement(By.id("login")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[routerlink='/dashboard/cart']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.card")));

        List<WebElement> products = driver.findElements(By.cssSelector("div.card"));

        System.out.println(products.size());


        driver.quit();

    }

}

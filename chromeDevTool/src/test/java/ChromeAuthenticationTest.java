
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.net.URI;
import java.util.function.Predicate;

public class ChromeAuthenticationTest {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));

        // handle a chrome popup asking for user and password
        // similar to teknisa test link
        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
        driver.register(uriPredicate, UsernameAndPassword.of("foo", "bar"));

        driver.get("http://httpbin.org/basic-auth/foo/bar");


        //driver.quit();

    }
}

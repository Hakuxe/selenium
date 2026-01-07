package network;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v142.network.Network;

import java.util.Optional;

public class ChangeNetworkSpeedTest {

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

        // use method Network.emulateNetworkConditionsByRule



        driver.quit();

    }

}

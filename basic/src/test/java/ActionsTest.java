import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;



public class ActionsTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br");
        Actions actions = new Actions(driver);

        //Elements
        WebElement linkAccountList = driver.findElement(By.cssSelector("#nav-link-accountList a"));
        WebElement inputSearch = driver.findElement(By.id("twotabsearchtextbox"));


        // A class Actions permite criar interação de dispositivos de entrada(mouse, teclado) no browser através do selenium 
        // Move o "mouse" para o elemento 
        actions.moveToElement(linkAccountList).build();
        
        // inserir texto maiúsculo via teclado
        actions.moveToElement(inputSearch).click().keyDown(Keys.SHIFT).sendKeys("hello").perform();

        //Drag and drop
        driver.get("https://testautomationcentral.com/demo/drag_and_drop.html");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source, target).perform();;





        sleep();
        
        driver.quit();
    }


     public static void sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

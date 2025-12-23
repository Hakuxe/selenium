package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HtmlReportDemoTest {

    protected ExtentReports extent;


    @BeforeTest
    public void configHtmlReport(){
        // onde vai ficar os arquivos
        String path = System.getProperty("user.dir") + "/target/reports/index.html";

        // configs do report
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        //reporter.config().setReportName("Web automation results");
        reporter.config().setDocumentTitle("Test Results");

        // O próprio html report
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }


    @Test
    public void initialDemo(){
        // Monitorar o teste
        ExtentTest test = extent.createTest("initialDemo");

        // anota no arquivo se falhar o teste
        test.fail("Result do not match");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com");

        String title = driver.getTitle();


        Assert.assertEquals(title, "Rahul Shetty Academy | Master AI & Automation Testing2");
        driver.quit();




        // salvar as alterações e gerar o arquivo
        extent.flush();
    }
}

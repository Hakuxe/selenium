import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {


    @Test
    @Parameters({"URL"})
    public void handlingParameters(String url){
        System.out.printf("\ngo to %s\n", url);
        System.out.println("Running smoke tests....");

    }



}

import org.testng.Assert;
import org.testng.annotations.Test;

public class FakeApiTests {


    @Test
    public void runApiTests(){
        System.out.println("Running api tests.....");

    }

    @Test
    public void runIntegrationApiTest(){
        System.out.println("Running integration api tests.....");

    }

    @Test(testName = "should fail")
    public void runDbTest(){
        System.out.println("Running database api tests.....");

        Assert.fail();

    }
}

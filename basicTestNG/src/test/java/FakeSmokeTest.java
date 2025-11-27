import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FakeSmokeTest {


    @BeforeTest
    public void beforeTheTestStarts(){
        System.out.println("First thing to be executed");
    }

    @AfterTest
    public void afterTheTest(){
        System.out.println("Last thing to be executed");
    }


    @Test
    public void runSmokeTests(){
        System.out.println("Running smoke tests....");

    }

    @Test
    public void runMobileTest(){
        System.out.println("Running smoke mobile tests....");

    }

    @Test
    public void runTabletTest(){
        System.out.println("Running smoke tablet tests....");

    }


}

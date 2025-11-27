import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataProviderTest {


    // Log in with 3 different users
    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];

        data[0][0] = "First username";
        data[0][1] = "First password";

        data[1][0] = "Second username";
        data[1][1] = "Second password";

        data[2][0] = "Third username";
        data[2][1] = "Third password";

        return data;
    }


    @Test(dataProvider = "getData")
    public void handlingDataProviders(String username, String password) {
        System.out.println("Running smoke tests....");
        System.out.println(username + " " + password);

    }


}

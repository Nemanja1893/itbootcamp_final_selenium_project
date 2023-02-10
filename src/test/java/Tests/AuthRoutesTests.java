package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{

    @Test(priority = 10)
    @Description("Test #1: Forbids visits to home url if not authenticated")
    public void homePage(){
        driver.navigate().to(baseUrl + "/home");

    }
}

package Tests;


import Flows.SignUpFlow;
import com.relevantcodes.extentreports.LogStatus;
import org.bson.assertions.Assertions;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.FixMethodOrder;

public class SignUpTest extends BaseTest {

    @Test
    public void registerToBuyMe_Test_01() throws Exception {
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        /*By myAccount = By.cssSelector(".nav-bar.buttons.nav-bar-box.nav-bar-left");
        Assert.assertTrue("Check if this appears", true);*/
    }

    @After
    public void afterTest() {
        extent.endTest(myTests);
    }

}

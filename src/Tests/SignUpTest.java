package Tests;


import Flows.SignUpFlow;
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
    }

    @After
    public void afterTest() {
        takeScreenShot(ImagePath + "\\" + System.currentTimeMillis());
        extent.flush();
    }

}

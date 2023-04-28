package Tests;


import Flows.SignUpFlow;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.bson.assertions.Assertions;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.FixMethodOrder;


public class SignUpTest extends BaseTest {

    @Test
    public void registerToBuyMe_Test_01() throws Exception {
        extentLogger = extentReport.createTest("Test_01 - Register To Buy Me");
        homeFlow.moveToLogin();
        try {
            signUpFlow.signUpBuyMeFlow();
            extentLogger.log(Status.PASS, ("Element was found!"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath)).build());
        } catch (NoSuchElementException e) {
            extentLogger.log(Status.FAIL, ("Element was not found!"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath)).build());
        }
    }

    @After
    public void afterTest() {
        extentReport.flush();
    }

}

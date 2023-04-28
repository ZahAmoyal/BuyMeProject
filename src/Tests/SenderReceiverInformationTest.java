package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class SenderReceiverInformationTest extends BaseTest {


    @Test
    public void senderGift_05() throws Exception {
        extentLogger = extentReport.createTest("SenderGift_05");
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        homeFlow.searchGift();
        chooseGiftFlow.pickBusinessFromList();
        try {
            senderReceeiverInformationFlow.senderGift();
            extentLogger.log(Status.PASS,("Test passed!"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath)).build());
        }catch (NoSuchElementException e){
            extentLogger.log(Status.FAIL,("Test failed!"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath)).build());
        }
    }

    @After
    public void afterTest() {
        extentReport.flush();
    }
}

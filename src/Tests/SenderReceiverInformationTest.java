package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static java.lang.System.currentTimeMillis;


public class SenderReceiverInformationTest extends BaseTest {


    @Test
    public void senderGift_05() throws Exception {
        extentLogger = extentReport.createTest("Test_05");
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        homeFlow.searchGift();
        chooseGiftFlow.pickBusinessFromList();
        senderReceeiverInformationFlow.senderGift();
        try {
            senderReceeiverInformationFlow.checkSenderReceiverInformationFlow();
            extentLogger.log(Status.PASS,("Test pass"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(getClass().getTypeName()), String.valueOf(currentTimeMillis())).build());
        }catch (NoSuchElementException e){
            extentLogger.log(Status.FAIL,(e.getMessage()), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(getClass().getTypeName()), String.valueOf(currentTimeMillis())).build());
        }
    }

    @After
    public void afterTest() {
        extentReport.flush();
    }
}

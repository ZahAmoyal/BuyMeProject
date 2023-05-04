package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.After;
import org.junit.Test;
import static java.lang.System.currentTimeMillis;

public class SenderReceiverInformationTest extends BaseTest {

    @Test
    public void senderGift_05() throws Exception {
        extentLogger = extentReport.createTest("Test_05");
        homeFlow.closePopUps();
        homeFlow.moveToLogin();
        loginFlow.loginBuyMe();
        homeFlow.searchGift();
        chooseGiftFlow.pickBusinessFromList();
        senderReceeiverInformationFlow.senderGift();
        try {
            senderReceeiverInformationFlow.assertSenderReceiverInformationFlow();
            extentLogger.log(Status.PASS, ("Test pass"),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(String.valueOf(currentTimeMillis()))).build());
        } catch (AssertionError exception) {
            extentLogger.log(Status.FAIL, (exception.getMessage()), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(String.valueOf(currentTimeMillis()))).build());
        }
    }

    @After
    public void afterTest(){
        extentReport.flush();
    }
}
package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static java.lang.System.currentTimeMillis;


public class HomeTest extends BaseTest{


    @Test
    public void searchGiftHome_02() throws Exception {
        extentLogger = extentReport.createTest("Test_02");
        homeFlow.closePopUps();
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        Thread.sleep(1000);
        homeFlow.searchGift();
        try {
            homeFlow.checkLoginFlow();
            extentLogger.log(Status.PASS, ("Test pass"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(getClass().getTypeName()), String.valueOf(currentTimeMillis())).build());
        } catch (AssertionError e) {
            extentLogger.log(Status.FAIL, (e.getLocalizedMessage()), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(getClass().getTypeName()), String.valueOf(currentTimeMillis())).build());
        }
    }
    @After
    public void afterTest() {
        extentReport.flush();
    }
}

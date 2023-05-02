package Tests;

import Flows.ChooseGiftFlow;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static java.lang.System.currentTimeMillis;


public class ChooseGiftTest extends BaseTest {

    @Test
    public void choose_A_Gift_04() throws Exception {
        extentLogger = extentReport.createTest("choose_A_Gift_04");
        homeFlow.closePopUps();
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        //loginFlow.loginBuyMe();
        homeFlow.searchGift();
        //chooseGiftFlow.pickBusinessFromList();
        try {
            chooseGiftFlow.pickBusinessFromList();
            extentLogger.log(Status.PASS, ("Element was found!"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(getClass().getTypeName()), String.valueOf(currentTimeMillis())).build());
        }catch (AssertionError e){
            extentLogger.log(Status.FAIL, (e.getLocalizedMessage()), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(getClass().getTypeName()), String.valueOf(currentTimeMillis())).build());
        }
    }

    @After
    public void afterTest() {
        extentReport.flush();
    }
}

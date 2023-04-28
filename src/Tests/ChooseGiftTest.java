package Tests;

import Flows.ChooseGiftFlow;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class ChooseGiftTest extends BaseTest {

    @Test
    public void choose_A_Gift_04() throws Exception {
        extentLogger = extentReport.createTest("choose_A_Gift_04");
        homeFlow.moveToLogin();
       signUpFlow.signUpBuyMeFlow();
        //loginFlow.loginBuyMe();
        homeFlow.searchGift();
        try {
            chooseGiftFlow.pickBusinessFromList();
            extentLogger.log(Status.PASS,("Element was found!"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath)).build());
        }catch (NoSuchElementException e){
            extentLogger.log(Status.FAIL,("Element was not found!"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath)).build());
        }
    }

    @After
    public void afterTest() {
        extentReport.flush();
    }
}

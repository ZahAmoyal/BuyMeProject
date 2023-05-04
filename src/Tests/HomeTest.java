package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.lang.System.currentTimeMillis;


public class HomeTest extends BaseTest{


    @Test
    public void searchGiftHome_02() throws Exception {
        extentLogger = extentReport.createTest("Test_02");
        homeFlow.closePopUps();
        homeFlow.moveToLogin();
        loginFlow.loginBuyMe();
        homeFlow.searchGift();
        try {
            homeFlow.checkLoginFlow();
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

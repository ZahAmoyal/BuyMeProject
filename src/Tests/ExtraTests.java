package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class ExtraTests extends BaseTest {

    @Before
    public void uploadExtraTest() {
        extentLogger = extentReport.createTest("ExtraTest_06");
    }

    @Test
    public void extraTest_06() throws Exception {
        homeFlow.closePopUps();
        homeFlow.moveToLogin();
        //signUpFlow.signUpBuyMeFlow();
        loginFlow.loginBuyMe();
        homeFlow.searchGift();
        chooseGiftFlow.pickBusinessFromList();
        senderReceeiverInformationFlow.senderGift();
        Extra_01_CheckOrder();
        Extra_02_CheckColor();
        Extra_03_CheckErrorMessage();
        Extra_04_FooterScreenshot();
        Extra_05_LoadingPrintSize();
    }


    @After
    public void afterTest(){
        extentReport.flush();
    }


    public void Extra_01_CheckOrder() {
        try {
            extraFlow.extraFlow_PreviewBlessing();
            extentLogger.createNode("Extra_01 - Order check").pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("picture1")).build());
        } catch (AssertionError | Exception exception) {
            extentLogger.createNode(exception.getMessage()).fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("picture1")).build());
        }
    }

    public void Extra_02_CheckColor() {
        try {
            extraFlow.assertColor();
            extentLogger.createNode("Extra_02 - Check color").pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("picture2")).build());
        } catch (AssertionError | Exception exception) {
            extentLogger.createNode(exception.getMessage()).fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("picture2")).build());

        }
    }

    public void Extra_03_CheckErrorMessage() {
        try {
            extraFlow.logOutAndAssertErrorMessage();
            homeFlow.moveToLogin();
            loginFlow.extraErrorFields();
            extentLogger.createNode("Extra_03_CheckErrorMessage").pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("picture3")).build());
            Thread.sleep(1000);
        } catch (AssertionError | Exception exception) {
            extentLogger.createNode(exception.getMessage()).fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("picture3")).build());
        }
    }

    public void Extra_04_FooterScreenshot() {
        try {
            chooseGiftFlow.screenExtra();
            extentLogger.createNode("Extra_04_FooterScreenshot").pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("Picture4")).build());
        } catch (AssertionError | Exception exception) {
            extentLogger.createNode(exception.getMessage()).fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("Picture4")).build());
        }
    }


    public void Extra_05_LoadingPrintSize(){
        try {
            homeFlow.extra_Loading();
            extentLogger.createNode("Extra_05_LoadingPrintSize").pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("Picture5")).build());
        } catch (AssertionError | Exception exception) {
            extentLogger.createNode(exception.getMessage()).fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("Picture5")).build());
        }
    }
}


package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.jsoup.nodes.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.lang.System.currentTimeMillis;


public class ExtrasTests extends BaseTest {

    @Before
    public void uploadExtraTest() {
        extentLogger = extentReport.createTest("ExtraTest_06");

    }

    @Test
    public void extraTest_06() throws Exception {
        homeFlow.closePopUps();
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        homeFlow.searchGift();
        chooseGiftFlow.pickBusinessFromList();
        senderReceeiverInformationFlow.senderGift();
        Extra_01_OrderCheck();
        Extra_02_CheckColor();
        Extra_03_CheckErrorMessage();
        Extra_04_FooterScreenshot();
        //Extra_05_LoadingPrintSize();
    }


    @After
    public void afterTest() throws IOException {
        extentReport.flush();
        Desktop.getDesktop().browse(new File("src/Data/Extent-Report-BuyMe-Project.html").toURI());

    }


    public void Extra_01_OrderCheck() {
        try {
            extraFlow.extraFlow_PreviewBlessing();
            extentLogger.createNode("Extra_01 - Order check").pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath,getClass().getTypeName()), String.valueOf(currentTimeMillis())).build());
        } catch (AssertionError | Exception exception) {
            extentLogger.createNode(exception.getMessage()).fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath,getClass().getTypeName()),String.valueOf(currentTimeMillis())).build());
        }
    }

    public void Extra_02_CheckColor() {
        try {
            extraFlow.assertColor();
            extentLogger.createNode("Extra_02 - Check color").pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath,getClass().getSimpleName()), String.valueOf(currentTimeMillis())).build());
        } catch (AssertionError | Exception exception) {
            extentLogger.createNode(exception.getMessage()).fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath, getClass().getSimpleName()),String.valueOf(currentTimeMillis())).build());

        }
    }

    public void Extra_03_CheckErrorMessage() {
        try {
            extraFlow.logOutAndAssertErrorMessage();
            homeFlow.moveToLogin();
            loginFlow.extraErrorFields();
            extentLogger.createNode("Extra_03 - Check Error Message").pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath,getClass().getName()), String.valueOf(currentTimeMillis())).build());
        } catch (AssertionError | Exception exception) {
            extentLogger.createNode(exception.getMessage()).fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath,getClass().getName()),String.valueOf(currentTimeMillis())).build());
        }
    }

    public void Extra_04_FooterScreenshot() {
        try {

            extentLogger.createNode("Extra_04 - Footer screenshot").pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath, getClass().getName()), String.valueOf(currentTimeMillis())).build());
        } catch (AssertionError | Exception exception) {
            extentLogger.createNode(exception.getMessage()).fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath,getClass().getName()),String.valueOf(currentTimeMillis())).build());
        }
    }


    public void Extra_05_LoadingPrintSize() {
        try {
            //extentLogger = extentReport.createTest("Extra_04 - Footer screenshot");
            homeFlow.extra_Loading();
            extentLogger.createNode("Extra_05 - Loading Print Size").pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath,getClass().getCanonicalName()), String.valueOf(currentTimeMillis())).build());
        } catch (AssertionError | Exception exception) {
            extentLogger.createNode(exception.getMessage()).fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath,getClass().getCanonicalName()),String.valueOf(currentTimeMillis())).build());
        }
    }
}





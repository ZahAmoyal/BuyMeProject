
package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;


public class ExtrasTests extends BaseTest {

    @Test
    public void extraTest_06() throws Exception {
        extentLogger = extentReport.createTest("ExtraTest_06");
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        homeFlow.searchGift();
        chooseGiftFlow.pickBusinessFromList();
        senderReceeiverInformationFlow.senderGift();
        extraFlow.extraFlow_PreviewBlessing();
        extraFlow.assertColor();
        extraFlow.logOutAndAssertErrorMessage();
        homeFlow.moveToLogin();
        loginFlow.extraErrorFields();
        chooseGiftFlow.screenExtra();
        extentLogger.log(Status.PASS,("Result"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath)).build());
    }

    @After
    public void afterTest() {
        extentReport.flush();
    }
}


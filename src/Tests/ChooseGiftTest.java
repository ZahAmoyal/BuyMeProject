package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.After;
import org.junit.Test;
import static java.lang.System.currentTimeMillis;


public class ChooseGiftTest extends BaseTest {

    @Test
    public void choose_A_Gift_04() throws Exception {
        extentLogger = extentReport.createTest("Choose_A_Gift_04");
        homeFlow.closePopUps();
        homeFlow.moveToLogin();
        loginFlow.loginBuyMe();
        homeFlow.searchGift();
        try {
            chooseGiftFlow.pickBusinessFromList();
            extentLogger.log(Status.PASS, ("Test pass!"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(getClass().getTypeName()), String.valueOf(currentTimeMillis())).build());
        }catch (AssertionError e){
            extentLogger.log(Status.FAIL, (e.getLocalizedMessage()), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(getClass().getTypeName()), String.valueOf(currentTimeMillis())).build());
        }
    }

    @After
    public void afterTest(){
        extentReport.flush();
    }
}

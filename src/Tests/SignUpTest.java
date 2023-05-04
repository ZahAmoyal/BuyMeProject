package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.*;
import static java.lang.System.currentTimeMillis;


public class SignUpTest extends BaseTest {

    @Test
    public void registerToBuyMe_Test_01() throws Exception {
        extentLogger = extentReport.createTest("Test_01 - Register To Buy Me");
        homeFlow.closePopUps();
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        try {
            signUpFlow.assertSignUpFlow();
            extentLogger.log(Status.PASS, ("Test pass"),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(String.valueOf(currentTimeMillis()))).build());
        }catch (AssertionError exception){
            extentLogger.log(Status.FAIL, (exception.getMessage()), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(String.valueOf(currentTimeMillis()))).build());
        }
    }

    @After
    public void afterTest(){
        extentReport.flush();
    }

}

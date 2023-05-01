package Tests;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.lang.System.currentTimeMillis;

public class SignUpTest extends BaseTest {

//    @Before
//    public void beforeTest(){
//
//        driver.get("https://buyme.co.il/");
//    }

    @Test
    public void registerToBuyMe_Test_01() throws Exception {
        extentLogger = extentReport.createTest("Test_01 - Register To Buy Me");
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        try {
            signUpFlow.checkSignUpFlow();
            extentLogger.log(Status.PASS, ("Test Pass!")+ MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath,getClass().getTypeName()), String.valueOf(currentTimeMillis())).build());
        }catch (AssertionError exception){
            extentLogger.log(Status.FAIL, (exception.getMessage()), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath, getClass().getCanonicalName()), String.valueOf(currentTimeMillis())).build());
        }
    }

    @After
    public void afterTest() throws IOException {
        extentReport.flush();
        Desktop.getDesktop().browse(new File("src/Data/Extent-Report-BuyMe-Project.html").toURI());
    }

}

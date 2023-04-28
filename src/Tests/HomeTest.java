package Tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class HomeTest extends BaseTest{


    @Test
    public void searchGift_03() throws Exception {
        extentLogger = extentReport.createTest("SearchGift_03");
        //homeFlow.moveToLogin();
        loginFlow.loginBuyMe();
        try {
            homeFlow.searchGift();
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

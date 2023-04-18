/*
package Tests;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseTest {

    public LoginTest() {
        super(driver);
    }

    @Before
    public void setUp() {
        driver.get("https://buyme.co.il/");
        driver.manage().window().maximize();
    }

    @Test
    public void loginToBuyMe_Test_02() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.FAIL, "Log from threadId: " + Thread.currentThread().getId());
        takeScreenShot(ImagePath + "\\" + System.currentTimeMillis());
        LoginPage.loginBuyMe();

    }
    @After
    public void afterTest() {
        extent.endTest(myTests);
    }


}

 */

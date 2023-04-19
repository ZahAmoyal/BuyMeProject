package Tests;

import PageObjects.ExtraPage;
import PageObjects.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HomeTest extends BaseTest{

static HomePage HomePage;

    public HomeTest() {
        super(driver);
    }

    @Test
    public void chooseGift_02() throws Exception {
        //LoginPage.loginBuyMe();
        Thread.sleep(1000);
        ifDis();
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Log from threadId: " + Thread.currentThread().getId());
        HomePage.searchGift();
    }

    @After
    public void afterTest() {
        extent.endTest(myTests);
    }
}
//ChooseAnAmount();
//SelectAnArea();
//categorySelection();
//HomePage.clickSubmit();


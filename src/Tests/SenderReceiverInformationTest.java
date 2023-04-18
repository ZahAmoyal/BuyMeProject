package Tests;

import Flows.HomeFlow;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import static PageObjects.HomePage.options;


public class SenderReceiverInformationTest extends BaseTest {
    public SenderReceiverInformationTest() {
        super(driver);
    }

    @Before
    public void setUp() {
        driver.get("https://buyme.co.il");
        driver.manage().window().maximize();
    }

    @Test
    public void senderReceiver_04() throws Exception {
        //HomeTest.checkCategory();
        //LoginFlow.loginFlow();
        //choosing_A_gift();
        //choosing_A_gift_from_a_list();
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Log from threadId: " + Thread.currentThread().getId()); //HomeFlow.flowHome();
        HomePage.searchGift();
        ChooseGiftPage.chooseGift();
    }
    @After
    public void afterTest() {
        extent.endTest(myTests);
    }

}

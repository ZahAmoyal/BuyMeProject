package Tests;

import Flows.ChooseGiftFlow;
import Flows.HomeFlow;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static PageObjects.ChooseGiftPage.*;
import static PageObjects.SenderReceiverInformationPage.senderGift;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ChooseGiftTest extends BaseTest {

    public ChooseGiftTest() {
        super(driver);
    }

    @Before
    public void setUp() {
        driver.get("https://buyme.co.il");
        driver.manage().window().maximize();
    }

    @Test
    public void choose_A_Gift_03() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Log from threadId: " + Thread.currentThread().getId());
        ChooseGiftFlow.chooseGiftFlow();
        SenderReceiverInformationPage.senderGift();
    }
    @After
    public void afterTest() {
        extent.endTest(myTests);
    }
}

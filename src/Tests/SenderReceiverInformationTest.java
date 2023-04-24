package Tests;

import org.junit.After;
import org.junit.Test;

public class SenderReceiverInformationTest extends BaseTest{
    @Test
    public void senderGift() throws Exception {
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        homeFlow.searchGift();
        chooseGiftFlow.pick_a_Buisness();
        senderReceeiverInformationFlow.senderGift();
    }
    @After
    public void afterTest() {
        extent.endTest(myTests);
    }
}

package Tests;

import org.junit.After;
import org.junit.Test;

public class SenderReceiverInformationTest extends BaseTest {
    @Test
    public void senderGift_05() throws Exception {
        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        homeFlow.searchGift();
        chooseGiftFlow.pickBusinessFromList();
        senderReceeiverInformationFlow.senderGift();
    }

    @After
    public void afterTest() {
        extent.flush();
    }
}

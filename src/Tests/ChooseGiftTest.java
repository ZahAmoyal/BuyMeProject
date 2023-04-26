package Tests;

import Flows.ChooseGiftFlow;
import org.junit.After;
import org.junit.Test;


public class ChooseGiftTest extends BaseTest {


    @Test
    public void choose_A_Gift_03() throws Exception {

        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        homeFlow.searchGift();
        chooseGiftFlow.pickBusinessFromList();
    }
    @After
    public void afterTest() {
        extent.flush();
    }
}

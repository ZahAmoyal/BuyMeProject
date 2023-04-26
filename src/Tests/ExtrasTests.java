
package Tests;

import org.junit.After;
import org.junit.Test;



public class ExtrasTests extends BaseTest {


    @Test
    public void extraTest_06() throws Exception {

        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        homeFlow.searchGift();
        chooseGiftFlow.pickBusinessFromList();
        senderReceeiverInformationFlow.senderGift();
        extraFlow.extraFlow();
    }

    @After
    public void afterTest() {
        extent.flush();
    }
}


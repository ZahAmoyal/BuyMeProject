package Tests;

import org.junit.After;
import org.junit.Test;

public class HomeTest extends BaseTest{
    @Test
    public void searchGiftHome_02() throws Exception {

        homeFlow.moveToLogin();
        signUpFlow.signUpBuyMeFlow();
        homeFlow.searchGift();
    }
    @After
    public void afterTest() {
        extent.flush();
    }
}

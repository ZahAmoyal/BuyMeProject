package Flows;

import PageObjects.ChooseGiftPage;
import PageObjects.SenderReceiverInformationPage;
import Tests.BaseTest;

public class ChooseGiftFlow {
    public static void chooseGiftFlow() throws Exception {
        HomeFlow.flowHome();
        BaseTest.assertURL();
        ChooseGiftPage.pick_a_Buisness();
    }
}

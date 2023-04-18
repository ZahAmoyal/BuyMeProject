package Flows;

import PageObjects.ChooseGiftPage;
import PageObjects.SenderReceiverInformationPage;

public class ChooseGiftFlow {
    public static void chooseGiftFlow() throws Exception {
        HomeFlow.flowHome();
        ChooseGiftPage.chooseGift();
    }
}

package Flows;

import PageObjects.*;
import Tests.*;

public class SenderReceeiverInformationFlow {

    public static void senderReceeiverInformationFlow() throws Exception {
        ChooseGiftFlow.chooseGiftFlow();
        SenderReceiverInformationPage.senderGift();

    }
}

package Flows;

import Tests.HomeTest;
import Tests.SenderReceiverInformationTest;

import static Tests.HomeTest.checkCategory;
import static Tests.LoginTest.loginToBuyMe_Test_01;
import static Tests.SenderReceiverInformationTest.chooseGift;


public class SenderReceeiverInformationFlow {

    public static void SenderReceeiverInformationFlow() throws Exception {
        loginToBuyMe_Test_01();
        checkCategory();
        chooseGift();
    }

}

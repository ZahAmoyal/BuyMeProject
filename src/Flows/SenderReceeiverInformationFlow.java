package Flows;

import PageObjects.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SenderReceeiverInformationFlow {

    SenderReceiverInformationPage senderReceiverInformationPage;


    public SenderReceeiverInformationFlow(WebDriver driver) {
        senderReceiverInformationPage = new SenderReceiverInformationPage(driver);
    }


    public void senderGift() throws Exception {
        senderReceiverInformationPage.isSelected_someOneElse();
        senderReceiverInformationPage.nameOfReceivesA_giftField();
        senderReceiverInformationPage.chooseEvent();
        senderReceiverInformationPage.writingNameOfSenderField();
        senderReceiverInformationPage.click_uploadPicture();
        senderReceiverInformationPage.click_submit();
        senderReceiverInformationPage.nowRadioButton_select();
        senderReceiverInformationPage.click_sms();
        senderReceiverInformationPage.phoneNumberField();
        senderReceiverInformationPage.writePhoneFieldSender();
        senderReceiverInformationPage.click_submitButton();
    }

    public void assertSenderReceiverInformationFlow() throws Exception {
        Assert.assertEquals(senderReceiverInformationPage.getCheckPage(),senderReceiverInformationPage.getAssertExpected());
    }

}

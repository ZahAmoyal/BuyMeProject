package Flows;

import PageObjects.*;
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
        //senderReceiverInformationPage.nameField();
        senderReceiverInformationPage.phoneField();
        senderReceiverInformationPage.click_submitButton();
        senderReceiverInformationPage.checkPage();
    }

}

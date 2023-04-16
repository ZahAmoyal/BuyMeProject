package Tests;

import Flows.SenderReceeiverInformationFlow;
import PageObjects.ChooseGiftPage;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static PageObjects.ChooseGiftPage.*;
import static Tests.LoginTest.loginToBuyMe_Test_01;

public class ChooseGiftTest extends BaseTest {

    public ChooseGiftTest() {
        super(driver);

    }

    @Before
    public void setUp() {
        driver.get("https://buyme.co.il");
        driver.manage().window().maximize();
    }


    @Test
    public void choose_A_Gift() throws Exception {
        SenderReceeiverInformationFlow.SenderReceeiverInformationFlow();
        isSelected_someOneElse();
        nameOfReceivesA_giftField();
        clickEvent();
        writingField();
        click_uploadPicture();
        Thread.sleep(3000);
        click_submit();
        nowRadioButton_select();
        click_sms();
        phoneNumberField();
        nameField();
        phoneField();
        click_submitButton();
    }
}

package Tests;

import PageObjects.ChooseGiftPage;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static PageObjects.ChooseGiftPage.*;

public class ChooseGiftTest extends BaseTest {

    public ChooseGiftTest() {
        super(driver);

    }

    @Before
    public void setUp() {
        driver.get("https://buyme.co.il/package/2712/30932");
        driver.manage().window().maximize();
    }


    @Test
    public void choose_A_Gift() throws Exception {
        //SenderReceiverInformationTest.chooseGift();
        isSelected_someOneElse();
        nameOfReceivesA_giftField();
        clickEvent();
        writingField();
        click_uploadPicture();
        click_submit();

    }


}

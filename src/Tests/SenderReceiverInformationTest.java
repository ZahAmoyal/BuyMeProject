package Tests;

import org.junit.Before;
import org.junit.Test;

//import static PageObjects.HomePage.options;


public class SenderReceiverInformationTest extends BaseTest {
    public Object loginToBuyMe_Test_01;

    public SenderReceiverInformationTest() {
        super(driver);
    }

    @Before
    public void setUp() {
        driver.get("https://buyme.co.il");
        driver.manage().window().maximize();
    }

    @Test
    public void chooseGift() throws Exception {
        HomeTest.checkCategory();
        choosing_A_gift();
        choosing_A_gift_from_a_list();
    }

}

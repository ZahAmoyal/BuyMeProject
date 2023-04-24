package Flows;

import PageObjects.ChooseGiftPage;
import org.openqa.selenium.WebDriver;

public class ChooseGiftFlow {

    ChooseGiftPage chooseGiftPage;

    public ChooseGiftFlow(WebDriver driver) {
        chooseGiftPage = new ChooseGiftPage(driver);
    }

    public void pick_a_Buisness() throws InterruptedException {
        chooseGiftPage.choosing_A_gift();
        chooseGiftPage.choosing_A_gift_from_a_list();
    }
}

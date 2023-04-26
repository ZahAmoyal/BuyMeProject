package Flows;

import PageObjects.ChooseGiftPage;
import org.openqa.selenium.WebDriver;

public class ChooseGiftFlow {

    ChooseGiftPage chooseGiftPage;

    public ChooseGiftFlow(WebDriver driver) {
        chooseGiftPage = new ChooseGiftPage(driver);
    }

    public void pickBusinessFromList() throws Exception {
        chooseGiftPage.assertURL();
        chooseGiftPage.pickFromBusinessList();
        chooseGiftPage.pickSubOption();
        chooseGiftPage.checkPage();
    }
}

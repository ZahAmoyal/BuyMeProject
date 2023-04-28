package Flows;

import PageObjects.ChooseGiftPage;
import org.openqa.selenium.WebDriver;

public class ChooseGiftFlow {

    ChooseGiftPage chooseGiftPage;

    public ChooseGiftFlow(WebDriver driver) {
        chooseGiftPage = new ChooseGiftPage(driver);
    }

    public boolean pickBusinessFromList() throws Exception {
        chooseGiftPage.assertURL();
        chooseGiftPage.pickFromBusinessList();
        chooseGiftPage.pickSubOption();
        return chooseGiftPage.checkPage();
    }

    public void screenExtra(){
        chooseGiftPage.scrollAndTakeScreenShot();
    }
}

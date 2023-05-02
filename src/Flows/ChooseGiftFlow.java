package Flows;

import PageObjects.ChooseGiftPage;
import org.junit.Assert;
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
    }
    public void assertChooseGiftFlow() throws Exception {
        Assert.assertEquals(chooseGiftPage.getTitle(),chooseGiftPage.getAssertExpected());
    }

   /* public void checkChooseGiftFlow() throws Exception {
        chooseGiftPage.checkPage();

    }*/

    public void screenExtra(){
        chooseGiftPage.scrollAndTakeScreenShot();
    }
}

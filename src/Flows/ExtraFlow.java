package Flows;

import PageObjects.ExtraPage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;

public class ExtraFlow {
    ExtraPage extraPage;

    public ExtraFlow(WebDriver driver) {
        extraPage = new ExtraPage(driver);
    }

    public void extraFlow() throws Exception {
        extraPage.clickOnThePreviewButton();
        extraPage.getTextToSend();
    }
}

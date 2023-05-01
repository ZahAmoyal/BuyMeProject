package Flows;

import PageObjects.ExtraPage;
import PageObjects.HomePage;
import Tests.BaseTest;
import org.openqa.selenium.WebDriver;

public class ExtraFlow {
    ExtraPage extraPage;

    public ExtraFlow(WebDriver driver) {
        extraPage = new ExtraPage(driver);
    }

    public void extraFlow_PreviewBlessing() throws Exception {
        extraPage.clickOnThePreviewButton();
        extraPage.assertionForBlessing();
        extraPage.clickClosePopUp();
    }

    public void assertColor() throws Exception {
        extraPage.getTextToSend();
    }


    public void logOutAndAssertErrorMessage(){
        extraPage.goHomePage();
        extraPage.clickMyAccount();
        extraPage.clickLogOut();
    }
}

package Flows;

import PageObjects.HomePage;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;

public class HomeFlow {

    HomePage homePage;

    public HomeFlow(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public void closePopUps(){
        homePage.ifDis();
        homePage.ifDisp();
    }
    public void moveToLogin(){
        homePage.clickLoginSignUpButton();
    }


    public void searchGift() throws Exception {
        do {
            homePage.chooseAnAmount();
            homePage.selectAnArea();
            homePage.categorySelection();
            homePage.clickSubmit();
        }while ((homePage.checkTitle())==true);
    }

    public void checkLoginFlow() throws Exception {
        homePage.checkPage();
    }

    public void extra_Loading() throws InterruptedException {
        homePage.loading();
    }


}

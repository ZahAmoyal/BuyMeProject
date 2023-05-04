package Flows;

import PageObjects.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomeFlow {

    HomePage homePage;

    public HomeFlow(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public void closePopUps(){
        homePage.ifDispopUpAppear_OnTheBigScreen();
        homePage.ifDisPopUpAppear_OnTheRightSideScreen();
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
       Assert.assertEquals(homePage.getSearchText(), homePage.getAssertExpected());
    }

    public void extra_Loading() throws InterruptedException {
        homePage.loading();
    }

}

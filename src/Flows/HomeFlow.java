package Flows;

import PageObjects.HomePage;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;

public class HomeFlow {

    HomePage homePage;

    public HomeFlow(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public void moveToLogin(){
        homePage.ifDis();
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


}

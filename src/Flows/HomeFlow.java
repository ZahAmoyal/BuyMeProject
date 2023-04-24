package Flows;

import PageObjects.HomePage;
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

    public void searchGift() throws InterruptedException {
        homePage.chooseAnAmount();
        homePage.SelectAnArea();
        homePage.categorySelection();
        homePage.clickSubmit();
    }
}

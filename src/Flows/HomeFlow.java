package Flows;
import PageObjects.BasePage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Tests.HomeTest;

import Tests.*;
import org.openqa.selenium.WebDriver;


public class HomeFlow extends BasePage {

    public HomeFlow(WebDriver driver) {
        super(driver);
    }

    public static void flowHome() throws Exception {
        //LoginPage.loginToBuyMe();
        HomePage.searchGift();
    }

}

package Tests;

import PageObjects.ExtraPage;
import PageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ExtrasTests extends BaseTest {

    //By excepted = By.ByCssSelector("")
    public ExtrasTests(WebDriver driver) {
        super(driver);
    }

    public static void extraTest_07(){
        LoginPage.click_RegisterButton();
        LoginPage.loginToBuyMe();
        ExtraPage.printLoadingDots();


    }


}

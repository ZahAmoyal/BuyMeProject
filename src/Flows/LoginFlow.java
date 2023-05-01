package Flows;
import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class LoginFlow {

    LoginPage loginPage;

    public LoginFlow(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }



    public void loginBuyMe() throws Exception {
        loginPage.emailField();
        loginPage.passwordField();
        loginPage.loginToBuyMe();
        //Thread.sleep(100000);
    }

    public void extraErrorFields() throws Exception {
        loginPage.loginToBuyMe();
        //loginPage.assertErrorMessage();
        loginPage.closePopUp();
    }
}


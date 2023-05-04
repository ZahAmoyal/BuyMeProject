package Flows;
import PageObjects.*;
import org.junit.Assert;
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
        Thread.sleep(30000);
    }

    public void extraErrorFields() throws Exception {
        loginPage.loginToBuyMe();
        AssertErrorMessageFields();
        loginPage.closePopUp();
    }
    public void AssertErrorMessageFields() throws Exception {
        Assert.assertEquals(loginPage.getErrorTextLogin(),loginPage.getAssertExpected());
    }
}


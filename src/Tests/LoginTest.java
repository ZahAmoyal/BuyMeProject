package Tests;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseTest {


    public LoginTest(WebDriver driver) {
        super(driver);
    }

    @Before
    public void setUp() {
        driver.get("https://buyme.co.il/");
        driver.manage().window().maximize();
    }

    @Test
    public void loginToBuyMe_Test_01() throws Exception {
        HomePage.clickLoginSignUpButton();
        LoginPage.emailField((readFromFile("email")));
        LoginPage.passwordField(readFromFile("password"));
        LoginPage.loginToBuyMe();
    }

}

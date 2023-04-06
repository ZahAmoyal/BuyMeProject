package Tests;

import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest {


    public static Object loginToBuyMe_Test_01;

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

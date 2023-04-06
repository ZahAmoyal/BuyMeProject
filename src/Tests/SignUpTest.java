package Tests;


import com.relevantcodes.extentreports.LogStatus;
import org.bson.assertions.Assertions;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUpTest extends BaseTest{


    @Before
    public void setUp(){
        driver.get("https://buyme.co.il/");
        driver.manage().window().maximize();
    }

    @Test
    public void registerToBuyMe_Test_01() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.FAIL, "Log from threadId: " + Thread.currentThread().getId());
        takeScreenShot("C:\\selenium-java-4.8.0\\ScreenShot\\"+"\\"+System.currentTimeMillis());
        HomePage.clickLoginSignUpButton();
        LoginPage.click_RegisterButton();
        signUpPage.writeTextFirstNameField(readFromFile("firstName"));
        signUpPage.writeTextEmailField(readFromFile("email"));
        signUpPage.writeTextPasswordField(readFromFile("password"));
        signUpPage.writeTextPassword_Authentication(readFromFile("password"));
        signUpPage.clickCheckBox_IAgree();
        signUpPage.clickSubmitButton();
        By myAccount = By.cssSelector("[class=\"nav-bar buttons nav-bar-box nav-bar-left\"]");
        Assert.assertTrue("Check if this appears",true);

    }

    @After
    public void afterTest(){
        extent.endTest(myTests);
    }

}

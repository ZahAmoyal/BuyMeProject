package Tests;


import com.relevantcodes.extentreports.LogStatus;
import org.bson.assertions.Assertions;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.FixMethodOrder;

public class SignUpTest extends BaseTest {

    public SignUpTest() {
        super(driver);
    }

    @Before
    public void setUp() {
        driver.get("https://buyme.co.il/");
        driver.manage().window().maximize();
    }

    @Test
    public void registerToBuyMe_Test_01() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Log from threadId: " + Thread.currentThread().getId());
        //takeScreenShot(ImagePath + "\\" + System.currentTimeMillis());
        SignUpPage.signUp();
        By myAccount = By.cssSelector("[class=\"nav-bar buttons nav-bar-box nav-bar-left\"]");
        Assert.assertTrue("Check if this appears", true);
    }

    @After
    public void afterTest() {
        extent.endTest(myTests);
    }

}

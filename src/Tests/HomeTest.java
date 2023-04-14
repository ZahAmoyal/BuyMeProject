package Tests;

import PageObjects.BasePage;
import PageObjects.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static PageObjects.HomePage.clickSubmit;


//import static Tests.LoginTest.loginToBuyMe_Test_01;

public class HomeTest extends BaseTest{

static HomePage HomePage;
    public HomeTest() {
        super(driver);

    }

    @Before
    public void setUp() {
        driver.get("https://buyme.co.il/");
        driver.manage().window().maximize();
    }
    @Test
    public static void checkCategory() throws Exception {
        //Thread.sleep(5000);
        //ifDis();
        ChooseAnAmount();
        //Thread.sleep(500);
        SelectAnArea();
        //Thread.sleep(500);
        categorySelection();
        //Thread.sleep(500);
        clickSubmit();
        //Thread.sleep(500);
    }

}

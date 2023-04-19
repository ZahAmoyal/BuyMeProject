package Tests;

import Flows.SenderReceeiverInformationFlow;
import PageObjects.ExtraPage;
import PageObjects.LoginPage;
import com.mongodb.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ExtrasTests extends BaseTest {

    public ExtrasTests() {
        super(driver);
    }

    /*@Before
    public void setUp() {
        driver.get("https://buyme.co.il");
        driver.manage().window().maximize();
    }*/

    @Test
    public void extraTest_07() throws Exception {
        SenderReceeiverInformationFlow.senderReceeiverInformationFlow();
        ExtraPage.clickOnThePreviewButton();
        ExtraPage.clickOnTheBackButton();


    }

    @After
    public void afterTest() {
        extent.endTest(myTests);
    }
}

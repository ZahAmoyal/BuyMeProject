package Tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

//import static PageObjects.HomePage.options;
import static PageObjects.HomePage.clickArea;
import static PageObjects.HomePage.clickSubmit;
import static Tests.BaseTest.driver;


public class SenderReceiverInformationTest extends BaseTest {
    public static Object loginToBuyMe_Test_01;


    By radioButton = By.cssSelector("[class=\"buttons\"]");
    By selected = By.cssSelector("[class=\"ember-view button button-forSomeone selected\"]");
    By nameOfThePrezent = By.cssSelector("[type=\"text\"]");
    By eizeeroa = By.cssSelector("[class=\"selected-name\"]");
    By bracha = By.cssSelector("[data-parsley-group=\"voucher-greeting\"]");
    By uploadPicture = By.cssSelector("[class=\"media-circle-btn.ember-view.bm-media-upload\"]");
    By submit = By.cssSelector("[gtm=\"המשך\"]");


    By now = By.cssSelector("[class=\"ember-view button button-now selected\"]");
    By email = By.cssSelector("[gtm=\"method-email\"]");
    By emailField = By.cssSelector("[id=\"email\"]");
    By nameOfTheGift = By.cssSelector("[placeholder=\"שם שולח המתנה\"]");
    By nextSubmit = By.cssSelector("[gtm=\"המשך לתשלום\"]");
    By tezoga = By.cssSelector("[gtm=\"תצוגה של המתנה\"]");


    By requairdField = By.cssSelector("[class=\"greeting bottom-md\"]");
    By requaridName = By.cssSelector("[class=\"recipient-sender bottom-md\"]");

    @Before
    public void setUp() {
        driver.get("https://buyme.co.il");
        driver.manage().window().maximize();
    }

    @Test
    public void insert () throws Exception {
        Thread.sleep(5000);
        ifDis();
        options();
        Thread.sleep(500);
        options1();
        Thread.sleep(500);
        options2();
        Thread.sleep(500);
        clickSubmit();
        Thread.sleep(500);
        options3();
        Thread.sleep(500);
        options4();
    }

}

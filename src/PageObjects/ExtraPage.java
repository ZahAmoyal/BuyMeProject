package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;


public class ExtraPage extends BasePage {

    //constructor
    public ExtraPage(WebDriver driver) {
        super(driver);
    }

    By preview = By.cssSelector("button[gtm=\"תצוגה של המתנה\"]");
    By senderAndReceiverName =By.cssSelector(".recipient-sender.bottom-md");
    By blessing = By.cssSelector(".greeting.bottom-md");
    By footer = By.cssSelector("div.buttons");
    By closePopUp = By.cssSelector("div[aria-label='לסגור חלון פופ אפ']");
    By backButton = By.cssSelector("svg[id='chevron-right']");
    By homePageButton = By.cssSelector("img[alt=\"לוגו BUY-ME\"]");
    By howSendText = By.cssSelector("div.step.active div.label.bottom-xs");
    By myAccountDropDown = By.cssSelector(".ember-view.dropdown.solid");
    By logOutButton = By.cssSelector("a[class=\"dropdown-item\"]");


    public void clickMyAccount() {
        click(myAccountDropDown);
    }
    public void clickLogOut(){
        click(logOutButton);
    }

    // A function for closing the login popup
    public void clickClosePopUp(){
        click(closePopUp);
    }


    //
    public void logOut(){
        clickMyAccount();
        clickLogOut();
    }


    public void clickOnTheBackButton() throws InterruptedException {
        Thread.sleep(2000);
        click(closePopUp);
        click(backButton);
        waitVisibility(backButton);
        click(backButton);
        waitVisibility(backButton);
        click(backButton);
        goHomePage();
    }
    // A function for clicking on the homepage button
    public void goHomePage() {
        click(homePageButton);
    }

    // A function for pressing the "view present" button, asserting the results and closing the popup
    public void clickOnThePreviewButton() throws Exception {
        click(preview);
       // Thread.sleep(1000);
    }

    // A function for pressing the back button, then taking the element's color and asserts it using a string value for the xml config file
    public void getTextToSend() throws Exception {
        click(backButton);
        String colorString = driver.findElement(howSendText).getCssValue("color");
        String colorValue = Color.fromString(colorString).asHex();
        Assert.assertEquals(readFromFile("colorOfText"),colorValue);

    }
    // A function for asserting the receiver's and sender's names and the blessing's content
    public void assertionForBlessing() throws Exception {
        Assert.assertTrue(getText(senderAndReceiverName).contains(readFromFile("Sender")));
        Assert.assertTrue(getText(senderAndReceiverName).contains(readFromFile("Receiver")));
        Assert.assertEquals(getText(blessing),(readFromFile("Blessing")));
    }

}

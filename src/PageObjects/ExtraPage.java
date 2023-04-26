package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;


public class ExtraPage extends BasePage {

    //constructor
    public ExtraPage(WebDriver driver) {
        super(driver);
    }

    private By preview = By.cssSelector("button[gtm=\"תצוגה של המתנה\"]");
    private By footer = By.cssSelector("div.buttons");
    private By closePopUp = By.cssSelector("div[aria-label='לסגור חלון פופ אפ']");
    private By backButton = By.cssSelector("svg[id='chevron-right']");
    private By homePageButton = By.cssSelector("img[alt=\"לוגו BUY-ME\"]");
    private By errorText = By.cssSelector("ul[id=\"parsley-id-37\"]");
    private By howSendText = By.cssSelector("div.step.active div.label.bottom-xs");


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

    public void goHomePage() {
        click(homePageButton);
    }


    public void clickOnThePreviewButton() throws InterruptedException {
        click(preview);
        Thread.sleep(2000);
        click(closePopUp);
    }

    public void scrollDownAndTakePicture_Extra_ChooseGiftScreen() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
    }

    public void getTextError() {
        getText(errorText);
    }


    public void getTextToSend() throws Exception {
        click(backButton);
        String colorString = driver.findElement(howSendText).getCssValue("color");
        String colorValue = Color.fromString(colorString).asHex();
        System.out.println(colorValue);
        Assert.assertEquals(readFromFile("colorOfText"),colorValue);
    }

}

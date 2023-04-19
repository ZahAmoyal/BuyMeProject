package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;


public class ExtraPage extends BasePage {


    public ExtraPage(WebDriver driver) {
        super(driver);
    }
    //static WebElement loadingDots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div"));
    //static WebElement loadingDots = driver.findElement(By.cssSelector("div.spinner"));
    static By preview = By.cssSelector("button[gtm=\"תצוגה של המתנה\"]");
    //static By preview = By.cssSelector("button.ember-view.bm-btn.no-reverse.text.lr.with-icon");
    static WebElement footer = driver.findElement(By.cssSelector("div.buttons"));
    //static WebElement t = driver.findElement(By.tagName("h1"));
    static By closePopUp = By.cssSelector("div[aria-label='לסגור חלון פופ אפ']");
    static By backButton = By.cssSelector("svg[id='chevron-right']");
    static By homePageButton = By.cssSelector("img[alt=\"לוגו BUY-ME\"]");
    static By myAccountDropDown = By.cssSelector(".ember-view.dropdown.solid");
    static By logOutButton =By.cssSelector("a[class=\"dropdown-item\"]");

    public static void clickOnTheBackButton() throws InterruptedException {
        Thread.sleep(2000);
        click(closePopUp);
        click(backButton);
        waitVisibility(backButton);
        click(backButton);
        waitVisibility(backButton);
        click(backButton);
        goHomePage();
        logOut();
    }
    public static void goHomePage(){
        click(homePageButton);
    }
    public static void logOut(){
        click(myAccountDropDown);
        click(logOutButton);
    }




    public static void clickOnThePreviewButton() throws InterruptedException {
        //waitVisibility(preview);
        click(preview);
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",preview);

    }
    public static void scrollDownAndTakePicture(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",footer);
    }

    /*public static void errorComparison(){
        clickOnThePreviewButton();
    }*/
    /*public static void colorElement(){
        String colorOfElement = Color.fromString(t.getCssValue("color")).asHex();
        System.out.println(colorOfElement);
    }
*/



}

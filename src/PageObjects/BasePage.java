package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {


    public WebDriver driver;
    public WebDriverWait wait;
    String readFromFilePath = "src/Data/XML.xml";

    //Resetting the page
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    //Click Method
    public void click(By elementLocation) {
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
    }

    // write Text
    public void writeText(By elementLocation, String text) {
        waitVisibility(elementLocation);
        WebElement field = driver.findElement(elementLocation);
        field.clear();
        field.sendKeys(text);
    }

    // Is selected
    public void selected(By elementLocation) {
        waitVisibility(elementLocation);
        if (!driver.findElement(elementLocation).isSelected()) {
            click(elementLocation);
        }
    }

    // Is displayed
    public boolean displayed(By elementLocation) {
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).isDisplayed();
    }

    //Get Text
    public String getText(By elementLocation) {
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).getText();
    }

    // A function for waiting for an element's visibility
    public void waitVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
    }

    //Read from file
    public String readFromFile(String KeyData) throws Exception {
        File xmlFile = new File(readFromFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(KeyData).item(0).getTextContent();
    }

    // A function that receives 2 random numbers - a low and a high ones - and returns a number between them
    public int randomNum(int origin, int num) {
        Random rand = new Random();
        return rand.nextInt(origin, num);
    }

    // A function that takes the page's URL and prints it (reminder: add to the report)
    public void assertURL() throws Exception {
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(checkUrl(actualURL, readFromFile("siteURL")));
    }

    // A function that checks whether the URLs are equal
    public boolean checkUrl(String expectedUrl, String actualUrl) {
        if (expectedUrl.equals(actualUrl))
            return false;
        return true;
    }

    public WebElement selectFromDropDown(WebElement industries, int num) throws InterruptedException {
        List<WebElement> dropDown = industries.findElements(By.tagName("li"));
        Thread.sleep(1000);
        String numValue = dropDown.get(randomNum(num, dropDown.size())).getAttribute("id");
        WebElement choose = industries.findElement(By.cssSelector("li[id=\"" + (numValue) + "\"]"));
        return choose;
    }

    String generateRandomEmailAddress (){
        String emailAddress = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        while (emailAddress.length() < 7) {
            int character = (int) (Math.random() * 26);
            emailAddress += alphabet.substring(character, character + 1);
            emailAddress += Integer.valueOf((int) (Math.random() * 99)).toString();
        }
        emailAddress += "@gmail.com";
        return emailAddress;
    }
    public String getAssertExpected(String string) throws Exception {
        return readFromFile(string);
    }

}



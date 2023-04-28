package PageObjects;

import Tests.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.mongodb.assertions.Assertions;
import org.junit.Assert;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;
import java.util.Random;

import static Tests.BaseTest.*;
import static org.junit.Assert.*;


public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    String readFromFilePath = "src/Data/Config2.xml";
//איתחול הדף
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
// פונקצייה שמחכה לאלמנט
    public void waitVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();

            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
    }


    public void selectByIndex(By elementLocation, int index) {
        waitVisibility(elementLocation);
        click(elementLocation);
        WebElement combo = driver.findElement(elementLocation);
        Select selectIndex = new Select(combo);
        selectIndex.selectByIndex(index);
    }

    public void selectByText(By elementLocation, String text) {
        waitVisibility(elementLocation);
        WebElement combo = driver.findElement(elementLocation);
        Select selectText = new Select(combo);
        selectText.selectByValue(text);
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
    // פונקצייה המקבלת אלמנט וטקסט , ממירה את האלמנט לטקסט ועושה השווה בעזרת Assert
    public boolean checkElementStatus(By by, String expected) {
        boolean check = true;
        try {
            assertEquals(expected, getText(by));
        } catch (NoSuchElementException e) {
            check = false;
        }
        return check;
    }
    // פונקציה שגוללת את הדף לאלמנט הרצוי
    public void moveElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }

    // פונקצייה שמקבלת 2 מספרים - תחתון ועליון ומביאה מספר בניהם
    public int randomNum(int origin, int num) {
        Random rand = new Random();
        return rand.nextInt(origin, num);
    }

// פונקצייה שלך - םונקצייה שלוקחת את URL של אותו דף ומדפיסה אותו (חייב להוסיף לדו"ח)
    public void assertURL() throws Exception {
        String actualURL = driver.getCurrentUrl();
        Assert.assertFalse(checkUrl(actualURL, readFromFile("siteURL")));
        System.out.println("Current URL is: " + actualURL);
    }
// פונקצייה שבודקת את ש2 הURL שווים
    public boolean checkUrl(String expectedUrl, String actualUrl) {
        if (expectedUrl.equals(actualUrl))
            return true;
        return false;
    }
}



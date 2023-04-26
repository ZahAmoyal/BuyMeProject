package PageObjects;

import Data.ExtentReportSingleton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import freemarker.template.utility.Constants;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.*;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    String readFromFilePath = "src/Data/Config2.xml";
    static ExtentReports extent = ExtentReportSingleton.getReporter();
    static ExtentTest test = extent.createTest("Web Automation Project", "BuyMe Website - Sanity test");
    public static final String TIMENOW = String.valueOf(System.currentTimeMillis());

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

    public void waitVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void checkElementStatus(By by, String expected) {
        try {
            assertEquals (expected, getText(by));
            test.pass("Element was found!");
        } catch (NoSuchElementException e) {
            test.fail("Element was not found!", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver,TIMENOW)).build());
        }
    }


    // פונקצייה שמקבלת מספר ומחזירה ערך רנדומלי מ0 עד למספר
    public int randomNum(int origin, int num) {
        Random rand = new Random();
        return rand.nextInt(origin, num);
    }


    public void assertURL() throws Exception {
        String actualURL = driver.getCurrentUrl();
        Assert.assertFalse(checkUrl(actualURL, readFromFile("siteURL")));
        System.out.println("Current URL is: " + actualURL);
    }

    public boolean checkUrl(String expectedUrl, String actualUrl) {
        if (expectedUrl.equals(actualUrl))
            return true;
        return false;
    }

    // This is a method which takes screenshots whenever an element is not found, and it is added to our extent report.
    private static String takeScreenShot(WebDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }
}



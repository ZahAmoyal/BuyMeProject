package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    String readFromFilePath = "src/Data/Config2.xml";


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
        if(! driver.findElement(elementLocation).isSelected()){
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

}



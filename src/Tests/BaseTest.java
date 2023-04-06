package Tests;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.bson.assertions.Assertions;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.BasePage;
import PageObjects.SignUpPage;
import PageObjects.LoginPage;
import PageObjects.HomePage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static PageObjects.BasePage.click;
import static PageObjects.HomePage.*;
import static org.jsoup.select.Selector.select;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.Keys.ENTER;


public abstract class BaseTest {
    public static WebDriver driver = null;
    static String reportFilePath = "C:\\selenium-java-4.8.0\\date\\Project1.html";
    static String chromeD = "C:\\selenium-java-4.8.0\\chromedriver_win32/chromedriver.exe";
    static String ImagePath = "C:\\selenium-java-4.8.0\\ScreenShot";
    static ExtentReports extent;
    static ExtentTest myTests;
    static BasePage basePage;
    static PageObjects.LoginPage LoginPage;
    static SignUpPage signUpPage;
    static LoginTest loginTest;
    static SignUpTest signUpTest;
    static PageObjects.HomePage HomePage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", chromeD);
        extent = new ExtentReports(reportFilePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        myTests = extent.startTest("ExtentFinalProject");

        basePage = new BasePage(driver);
        signUpPage = new SignUpPage(driver);
        LoginPage = new LoginPage(driver);
        HomePage = new HomePage(driver);
    }


    // Take screenshot
    static String takeScreenShot(String ImagePath) {
        TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagePath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagePath + ".png";
    }


    //Read from file
    public static String readFromFile(String KeyData) throws Exception {
        File xmlFile = new File("C://selenium-java-4.8.0//date/config2.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(KeyData).item(0).getTextContent();
    }


    @AfterClass
    public static void closeDriver() throws InterruptedException {
        Thread.sleep(20000);
        driver.close();
        driver.quit();
        extent.flush();
    }

    public static int randomNum(int num) {
        Random rand = new Random();
        int int_random = rand.nextInt(num);
        return int_random;
    }

    //List
    public static void options() throws InterruptedException {
        clickSum();
        Thread.sleep(500);
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        List<WebElement> option = industries.findElements(tagName("li"));
        //randomNum(option.size());
        int num = (randomNum(option.size())+1);
        //for (int i=0;i<option.size();i++)
        //System.out.println(option.get(randomNum(option.size())).getText() + " " + randomNum(option.size()));
        //Thread.sleep(500);
        //WebElement choose =industries.findElement(By.partialLinkText(option.get(randomNum(option.size())).getText()));
        //choose.click();
        WebElement choose = industries.findElement(By.cssSelector("[uaindex=\"" + (num) + "\"]"));
        choose.click();
    }

    public static void options1() throws InterruptedException {
        clickArea();
        Thread.sleep(500);
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        List<WebElement> option = industries.findElements(tagName("li"));
        //randomNum(option.size());
        int num = (randomNum(option.size())+2);
        //for (int i=0;i<option.size();i++)
        //System.out.println(option.get(randomNum(option.size())).getText() + " " + randomNum(option.size()));
        //WebElement choose = industries.findElement(By.partialLinkText(option.get(randomNum(option.size())).getText()));
        WebElement choose = industries.findElement(By.cssSelector("[uaindex=\"" + (num) + "\"]"));
        choose.click();
    }


    public static void options2() throws InterruptedException {
        clickCategory();
        Thread.sleep(500);
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.search.with-icon.empty.md.no-label.with-search"));
        List<WebElement> option = industries.findElements(tagName("li"));
        //randomNum(option.size());
        int num = (randomNum(option.size())+2);
        //for (int i=0;i<option.size();i++)
        //System.out.println(option.get(randomNum(option.size())).getText() + " " + randomNum(option.size()));
        //WebElement choose = industries.findElement(By.partialLinkText(option.get(randomNum(option.size())).getText()));
        WebElement choose = industries.findElement(By.cssSelector("[uaindex=\"" + (num) + "\"]"));
        choose.click();
    }

    public static void options3() throws InterruptedException {

        Thread.sleep(750);
        WebElement industries = driver.findElement(By.cssSelector("ul.grid.bm-product-cards"));
        List<WebElement> zah = industries.findElements(By.cssSelector("div.ember-view.bm-product-card-link.mx-4.lr-6.sm-12"));
        //System.out.println(zah.size());
        //for (int i = 0; i < zah.size(); i++) {

        //  System.out.println(zah.get(i).getText());
        // }
        //String name =zah.get(randomNum(zah.size())).getText();
        WebElement choose = industries.findElement(By.partialLinkText(zah.get(randomNum(zah.size())).getText()));
        choose.click();
    }

    public static void ifDis() {
        By popUp = By.cssSelector("[style=\"fill: rgb(0, 0, 0);\"]");
        if (signUpPage.displayed(popUp)) {
            click(popUp);
        }
    }

    public static void options4() throws InterruptedException {
        Thread.sleep(750);
        WebElement industries = driver.findElement(By.cssSelector("div.inner"));
        //List<WebElement> zah1 = industries.findElements(By.cssSelector("img.ember-view"));
        //List<WebElement> zah1 = industries.findElements(By.cssSelector("li.ember-view.bm-gift-card-link"));
          List<WebElement> zah1 = industries.findElements(By.cssSelector("div.bottom.bm-subtitle-1"));
        //System.out.println(zah.size());
       // for (int i = 0; i < zah1.size(); i++) {
        //System.out.println(zah1.get(i).getText());
        //}
        int num = randomNum(zah1.size());
        //System.out.println(zah1.get(num).getText());
        //System.out.println(name);
        WebElement choose = industries.findElement(By.partialLinkText((zah1.get(num).getText())));

        System.out.println(choose.getText());
        Thread.sleep(1000);
       // boolean dis= choose.findElement(By.cssSelector("input[placeholder='הכנס סכום']")).isDisplayed();//label.ember-view.bm-field.bm-input.empty.blur.with-icon.md.no-label"));
        if (choose.findElement(By.cssSelector("input[placeholder='הכנס סכום']")).isDisplayed()) {
            choose.findElement(By.cssSelector("input[placeholder='הכנס סכום']")).sendKeys("500");
            WebElement submit = zah1.get(num).findElement(By.cssSelector("div[class='bottom bm-subtitle-1'] button"));
            submit.click();
       }
        else {
            Thread.sleep(1000);
            choose.click();
            //WebElement submit = zah1.get(num).findElement(By.cssSelector("div[class='bottom bm-subtitle-1'] button"));
            //submit.click();
        }
    }



}

//randomNum(option.size());
//int num = randomNum(option.size());
//for (int i=0;i<option.size();i++)
//System.out.println(option.get(randomNum(option.size())).getText() + " " + randomNum(option.size()));
//WebElement choose = industries.findElement(By.cssSelector("[uaindex=\"" + (num + 2) + "\"]"));
//By choose ;

/*

    public static void choose(int num) {
        By combo;
        HomePage.clickSum();
        switch (num) {
            case 1:
                combo = By.cssSelector("li.ember-view.bm-select-option[value=\"+" + num + "+\"]");
                click(combo);
                //HomePage.select(combo);
                break;
            case 2:
                combo = By.cssSelector("li.ember-view.bm-select-option[value=\"2\"]");
                //HomePage.select(combo);
                click(combo);
                break;
            case 3:
                combo = By.cssSelector("li.ember-view.bm-select-option[value=\"3\"]");
                //HomePage.select(combo);
                click(combo);
                break;
            case 4:
                combo = By.cssSelector("li.ember-view.bm-select-option[value=\"4\"]");
                //HomePage.select(combo);
                click(combo);
                break;
            case 5:
                combo = By.cssSelector("li.ember-view.bm-select-option[value=\"5\"]");
                //HomePage.select(combo);
                click(combo);
                break;
            case 6:
                combo = By.cssSelector("li.ember-view.bm-select-option[value=\"6\"]");
                //HomePage.select(combo);
                click(combo);
                break;
        }

    }
}

 */


//הוספת תמונה של שגיאה
// myTests.log(LogStatus.INFO, "screen:" + myTests.addScreenCapture(takeScreenShot(imagePath + "\\" + System.currentTimeMillis())));















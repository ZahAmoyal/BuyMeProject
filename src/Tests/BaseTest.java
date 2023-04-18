package Tests;


import PageObjects.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import PageObjects.BasePage;
import PageObjects.HomePage;
import PageObjects.ChooseGiftPage;


public class BaseTest {
    public static WebDriver driver;
    static String reportFilePath = "C:\\project\\Project1.html";
    static String chromeD = "src/Data/chromedriver.exe";
    static String ImagePath = "C:\\project\\ScreenShot";
    static String readFromFilePath = "src/Data/Config2.xml";
    static ExtentReports extent;
    static ExtentTest myTests;
    static BasePage BasePage;
    static LoginPage LoginPage;
    static SignUpPage SignUpPage;
    static ChooseGiftPage ChooseGiftPage;


    static SenderReceiverInformationPage SenderReceiverInformationPage;
    static HomePage HomePage;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }


    @BeforeClass
    public static void setup() {
        extent = new ExtentReports(reportFilePath);
        myTests = extent.startTest("Sanity test - Buy Me");
        System.setProperty("webdriver.chrome.driver", chromeD);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);

        BasePage = new BasePage(driver);
        SignUpPage = new SignUpPage(driver);
        LoginPage = new LoginPage(driver);
        HomePage = new HomePage(driver);
        SenderReceiverInformationPage = new SenderReceiverInformationPage(driver);
//        ChooseGiftPage = new ChooseGiftPage(driver);

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
        File xmlFile = new File(readFromFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(KeyData).item(0).getTextContent();
    }


    @AfterClass
    public static void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
        extent.flush();
    }
    // פונקצייה שמקבלת מספר ומחזירה ערך רנדומלי מ0 עד למספר
    public static int randomNum(int num) {
        int int_random;
        do {
            Random rand = new Random();
            int_random = rand.nextInt(num);
        }
        while (int_random == 0 || int_random == num);
        return int_random;
    }

// פונקצייה לסגירת פופאפ שהיה (כרגע לא פעיל)
    public static void ifDis() {
        By popUp = By.cssSelector("[style=\"fill: rgb(0, 0, 0);\"]");
        if (SignUpPage.displayed(popUp)) {
            BasePage.click(popUp);
        }
    }


    /*
    public static void select_event() throws InterruptedException {
        clickEvent();
        Thread.sleep(500);
        WebElement industries = driver.findElement(By.cssSelector(".ember-view.bm-field.bm-select.show-options.with-icon.empty.md.with-label"));
        List<WebElement> events = industries.findElements(By.cssSelector("select[name=\"eventType\"]"));
        int num = (randomNum(events.size()));
        WebElement choose = industries.findElement(By.partialLinkText(events.get(randomNum(events.size())).getText()));
        choose.click();

    }

     */
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















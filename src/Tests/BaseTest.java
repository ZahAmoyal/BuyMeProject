package Tests;

import Flows.*;
import PageObjects.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import PageObjects.BasePage;
import PageObjects.HomePage;
import PageObjects.ChooseGiftPage;


public class BaseTest{

    static WebDriver driver;
    String reportFilePath = "C:\\project\\Project1.html";
    static String chromeD = "C:\\selenium-java-4.8.0\\chromedriver_win32\\chromedriver.exe";
    String ImagePath = "C:\\project\\ScreenShot";
    //static String readFromFilePath = "src/Data/Config2.xml";
    static ExtentReports extent;
    static ExtentTest myTests;
    LoginPage LoginPage;
    SignUpPage SignUpPage;
    ChooseGiftPage ChooseGiftPage;
    SenderReceiverInformationPage SenderReceiverInformationPage;
    HomePage HomePage;
    static ChooseGiftFlow chooseGiftFlow;
    static HomeFlow homeFlow;
    static LoginFlow loginFlow;
    static SenderReceeiverInformationFlow senderReceeiverInformationFlow;
    static SignUpFlow signUpFlow;


    @BeforeClass
    public static void setup() {
        extent = new ExtentReports("C:\\project\\Project1.html");
        myTests = extent.startTest("Sanity test - Buy Me");
        System.setProperty("webdriver.chrome.driver", chromeD);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://buyme.co.il/");

        chooseGiftFlow = new ChooseGiftFlow(driver);
        homeFlow =new HomeFlow(driver);
        loginFlow =new LoginFlow(driver);
        senderReceeiverInformationFlow = new SenderReceeiverInformationFlow(driver);
        signUpFlow =new SignUpFlow(driver);
    }

    // This is a method that takes screenshots whenever an element is not found, and it is added to our extent report.
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

    /*//Read from file
    public String readFromFile(String KeyData) throws Exception {
        File xmlFile = new File(readFromFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(KeyData).item(0).getTextContent();
    }*/


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

    public static void assertURL() {
        String siteURL = "https://buyme.co.il";
        String actualURL = driver.getCurrentUrl();
        //Assert.assertFalse(checkUrl(actualURL, siteURL));
        System.out.println("Current URL is: " + actualURL);
    }

    public static boolean checkUrl(String expectedUrl, String actualUrl) {
        if (expectedUrl.equals(actualUrl))
            return true;
        return false;
    }

    @AfterClass
    public static void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
        extent.flush();
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















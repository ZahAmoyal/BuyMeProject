package Tests;

import Flows.*;
import PageObjects.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;


public class BaseTest {


    static WebDriver driver;
    static String chromeD = "src/Data/chromedriver.exe";
    static String fireFoxD = "src/Data/fireFoxDriver.exe";
    //static String ImagePath = "C:\\Users\\AsusX514\\IdeaProjects\\BuyMeProject\\src\\";
    private static String ImagePath = "C:\\Users\\AsusX514\\IdeaProjects\\BuyMeProject\\src\\Data\\Pictures\\Extent-Report-BuyMe-Project\\";
    static ChooseGiftFlow chooseGiftFlow;
    static HomeFlow homeFlow;
    static LoginFlow loginFlow;
    static SenderReceeiverInformationFlow senderReceeiverInformationFlow;
    static SignUpFlow signUpFlow;
    static ExtraFlow extraFlow;
    static ExtentReports extentReport;
    static ExtentSparkReporter sparkReporter;
    static ExtentTest extentLogger;
    static ExtentReports extent;
    static ExtentSparkReporter htmlReporter;
//    static File fileCastPath = new File(new File(IPath).getAbsolutePath());
//    static String ImagePath = String.valueOf(fileCastPath);


    public static String getImagePath() {
        return ImagePath;
    }

    @BeforeClass
    public static void setup() throws Exception {
        getDriverInstance();
        resetFlows();
        getReporter();
        resetExtentReport();
        driver.get("https://buyme.co.il/");
    }

    public static void resetExtentReport() {
        extentReport = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "\\src\\Data\\Extent-Report-BuyMe-Project.html"));
        extentReport.attachReporter(sparkReporter);
    }

    @AfterClass
    public static void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
        extentReport.flush();
    }

    // ביצוע איתחול לכל הflows
    public static void resetFlows() {
        chooseGiftFlow = new ChooseGiftFlow(driver);
        homeFlow = new HomeFlow(driver);
        loginFlow = new LoginFlow(driver);
        senderReceeiverInformationFlow = new SenderReceeiverInformationFlow(driver);
        signUpFlow = new SignUpFlow(driver);
        extraFlow = new ExtraFlow(driver);
    }

    // This is a method that takes screenshots whenever an element is not found, and it is added to our extent report.
    // Take screenshot
    public static String takeScreenShot(String name) {
        Date date =new Date();
        TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File( getImagePath() + name +".png"); //date.toString().replace(":", "_")
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return getImagePath() + name+".png";
    }

    //A method to call the extent reporter which creates the report.
    public static synchronized ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports();
            htmlReporter = new ExtentSparkReporter("\\src\\Data\\Extent-Report-BuyMe-Project.html");
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public static WebDriver getDriverInstance() throws Exception {

        if (driver == null) {
            try {
                //String type=(basePage.readFromFile("browzer")).toLowerCase();
                String type = "chrome";
                if (type.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", chromeD);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("disable-popup-blocking");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driver.manage().window().maximize();

                } else if (type.equals("fireFox")) {
                    System.setProperty("webdriver.Firefox.driver", fireFoxD);
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driver.manage().window().maximize();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("Driver failed!");
            }
        }
        return driver;
    }

   /* public void generateEmail()
    {
        RandomStringUtils RandomStringUtils = null;
        setGeneratedString(RandomStringUtils.randomAlphabetic(8)+"@wallaballa.com");

    }
    public void setGeneratedString(String val)
    {
        this.generatedstring=val;
    }*/

}
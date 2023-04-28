package Tests;

import Flows.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    static WebDriver driver;
    //static String reportFilePath = "C:\\project\\Project1.html";
    static String chromeD = "C:\\selenium-java-4.8.0\\chromedriver_win32\\chromedriver.exe";
    public static String ImagePath = "C:\\project\\ScreenShot";
    //static ExtentReports extent = ExtentReportSingleton.getReporter();
    public static ExtentTest test;
    static ChooseGiftFlow chooseGiftFlow;
    static HomeFlow homeFlow;
    static LoginFlow loginFlow;
    static SenderReceeiverInformationFlow senderReceeiverInformationFlow;
    static SignUpFlow signUpFlow;
    static ExtraFlow extraFlow;
    static ExtentReports extentReport;
    static ExtentSparkReporter sparkReporter;
    static ExtentTest extentLogger;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", chromeD);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://buyme.co.il/");
        resetFlows();
        resetExtentReport();
    }

    public static void resetExtentReport() {
        extentReport = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "\\src\\Data\\Extent-Report-BuyMe-Project.html"));
        extentReport.attachReporter(sparkReporter);
    }

/*    @Before
    public void beforeClass() {*/


        @AfterClass
        public static void closeDriver () throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
            driver.quit();
            extentReport.flush();
        }

        public static void checkAssert(boolean result){
            if (result)
                extentLogger.log(Status.PASS, ("Element was found!"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath)).build());
            extentLogger.log(Status.FAIL, ("Element was found!"), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(ImagePath)).build());
        }
        // ביצוע איתחול לכל הflows
        public static void resetFlows () {
            chooseGiftFlow = new ChooseGiftFlow(driver);
            homeFlow = new HomeFlow(driver);
            loginFlow = new LoginFlow(driver);
            senderReceeiverInformationFlow = new SenderReceeiverInformationFlow(driver);
            signUpFlow = new SignUpFlow(driver);
            extraFlow = new ExtraFlow(driver);
        }

        // This is a method that takes screenshots whenever an element is not found, and it is added to our extent report.
        // Take screenshot
        public static String takeScreenShot (String ImagePath){
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
    }
}



}
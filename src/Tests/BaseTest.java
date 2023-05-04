package Tests;

import Flows.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;


public class BaseTest {

    static WebDriver driver;
    private static String imagePath = "C:\\Users\\AsusX514\\IdeaProjects\\BuyMeProject\\src\\Data\\Pictures\\Extent-Report-BuyMe-Project\\";
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
    private static String chromeD = "src/Data/chromedriver.exe";
    private static String fireFoxD = "src/Data/fireFoxDriver.exe";
    private static String readFromFilePath = "src/Data/XmlBaseTest.xml";



    public static String getImagePath() {
        return imagePath;
    }
    public static String getChromeD(){
        return chromeD;
    }
    public static String getFireFoxD(){
        return fireFoxD;
    }
    public static String getReadFromFilePath(){
        return readFromFilePath;
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
    public static void closeDriver() throws InterruptedException, IOException {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
        extentReport.flush();
        Desktop.getDesktop().browse(new File("src/Data/Extent-Report-BuyMe-Project.html").toURI());
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
        Date date = new Date();
        TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(getImagePath() + name + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return getImagePath() + name + ".png";
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

    //Read from file
    public static String readFromFile(String KeyData) throws Exception {
        File xmlFile = new File(getReadFromFilePath());
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(KeyData).item(0).getTextContent();
    }

    public static WebDriver getDriverInstance() throws Exception {
        if (driver == null) {
            String type=readFromFile("browzer").toLowerCase();
            try {
                if (type.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", getChromeD());
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("disable-popup-blocking");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driver.manage().window().maximize();

                } else if (type.equals("fireFox")) {
                    System.setProperty("webdriver.Firefox.driver", getFireFoxD());
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
}
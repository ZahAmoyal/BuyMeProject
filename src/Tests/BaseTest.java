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

import static PageObjects.ChooseGiftPage.clickEvent;
import static org.openqa.selenium.By.tagName;


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
        myTests = extent.startTest("ExtentFinalProject");
        System.setProperty("webdriver.chrome.driver", chromeD);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
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

    public static int randomNum(int num) {
        int int_random;
        do {
            Random rand = new Random();
            int_random = rand.nextInt(num);
        }
        while (int_random == 0 || int_random == num);
        return int_random;
    }

    //List
    public static void ChooseAnAmount() throws InterruptedException {
        HomePage.clickSum();
        Thread.sleep(500);
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        List<WebElement> sum = industries.findElements(tagName("li"));
        int num = (randomNum(sum.size()));
        WebElement choose = industries.findElement(By.cssSelector("[uaindex=\"" + (num) + "\"]"));
        choose.click();
    }

    public static void SelectAnArea() throws InterruptedException {
        HomePage.clickArea();
        Thread.sleep(500);
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        List<WebElement> area = industries.findElements(tagName("li"));
        int num = (randomNum(area.size()));
        WebElement choose = industries.findElement(By.cssSelector("[uaindex=\"" + (num) + "\"]"));
        choose.click();
    }


    public static void categorySelection() throws InterruptedException {
        HomePage.clickCategory();
        Thread.sleep(500);
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.search.with-icon.empty.md.no-label.with-search"));
        List<WebElement> category = industries.findElements(tagName("li"));
        int num = (randomNum(category.size()) + 1);
        WebElement choose = industries.findElement(By.cssSelector("[uaindex=\"" + (num) + "\"]"));
        choose.click();
    }

    public static void choosing_A_gift() throws InterruptedException {
        Thread.sleep(750);
        WebElement industries = driver.findElement(By.cssSelector("ul.grid.bm-product-cards"));
        List<WebElement> zah = industries.findElements(By.cssSelector("div.ember-view.bm-product-card-link.mx-4.lr-6.sm-12"));
        WebElement choose = industries.findElement(By.partialLinkText(zah.get(randomNum(zah.size())).getText()));
        choose.click();
    }

    public static void ifDis() {
        By popUp = By.cssSelector("[style=\"fill: rgb(0, 0, 0);\"]");
        if (SignUpPage.displayed(popUp)) {
            BasePage.click(popUp);
        }
    }

    public static void choosing_A_gift_from_a_list() throws InterruptedException {
        Thread.sleep(3000);
        //WebElement industries = driver.findElement(By.cssSelector("div.inner"));
        WebElement industries = driver.findElement(By.cssSelector(".grid.gifts-list"));
        List<WebElement> zah1 = industries.findElements(tagName("li"));
        //List<WebElement> zah1 = industries.findElements(By.cssSelector(".grid.gifts-list"));
        //List<WebElement> zah1 = industries.findElements(By.cssSelector("img.ember-view"));
        //List<WebElement> zah1 = industries.findElements(By.cssSelector("li.ember-view.bm-gift-card-link"));
        //List<WebElement> zah1 = industries.findElements(By.cssSelector("div.bottom.bm-subtitle-1"));
        //System.out.println(zah.size());

        // for (int i = 0; i < zah1.size(); i++) {
        //System.out.println(zah1.get(i).getText());
        //}
        System.out.println(zah1.size());
        int num = randomNum(zah1.size());
        //System.out.println(zah1.get(num).getText()+num);
        // WebElement choose = industries.findElement(By.partialLinkText((zah1.get(num).getText())));
        WebElement choose = industries.findElement(By.cssSelector("li.ember-view.bm-gift-card-link"));
        //System.out.println(choose.getText());
        // boolean dis= choose.findElement(By.cssSelector("input[placeholder='הכנס סכום']")).isDisplayed();//label.ember-view.bm-field.bm-input.empty.blur.with-icon.md.no-label"));
        //PageObjects.BasePage.waitVisibility((By) choose.findElement(By.cssSelector("input[placeholder='הכנס סכום']")));
        Thread.sleep(3000);
        if (choose.findElement(By.cssSelector("input[placeholder='הכנס סכום']")).isDisplayed()) {
            choose.findElement(By.cssSelector("input[placeholder='הכנס סכום']")).sendKeys("500");
            WebElement submit = choose.findElement(By.tagName("button"));//zah1.get(num).findElement(By.cssSelector("div[class='bottom bm-subtitle-1'] button"));
            submit.click();
        } else {
            Thread.sleep(1000);
            choose.click();
            //WebElement submit = zah1.get(num).findElement(By.cssSelector("div[class='bottom bm-subtitle-1'] button"));
            //submit.click();
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















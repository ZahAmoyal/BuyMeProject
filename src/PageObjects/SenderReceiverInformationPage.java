package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Tests.*;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static Tests.BaseTest.randomNum;
import static Tests.BaseTest.readFromFile;
import static org.openqa.selenium.By.tagName;

public class SenderReceiverInformationPage extends BasePage {
    //static String noResult = "לא נמצאו תוצאות";

    static String absolutePathToMyFile = "src/Data/image.jpeg";
    static File path = new File(new File(absolutePathToMyFile).getAbsolutePath());
    static String pathPicture = String.valueOf(path);


    public SenderReceiverInformationPage(WebDriver driver) {
        super(driver);
    }


        static By someOneElse = By.cssSelector(".ember-view.button.button-forSomeone.selected");
        static By nameOfReceivesA_gift = By.cssSelector("input[type=\"text\"]");
        static By event = By.cssSelector(".ember-view.bm-field.bm-select.with-icon.empty.md.with-label");
        static By uploadPicture = By.cssSelector("input[type='file']");
        static By writingField = By.cssSelector("[data-parsley-group=\"voucher-greeting\"]");
        static By submit = By.cssSelector("[type=\"submit\"]");


        static By nowRadioButton = By.cssSelector("div.ember-view.button.button-now.selected");
        static By sms = By.cssSelector("svg[gtm='method-sms']");
        static By phoneNumber = By.id("sms");
        static By name = By.cssSelector("[placeholder='שם שולח המתנה']");
        static By submitButton = By.cssSelector("[type='submit']");
        static By phoneNumberOfTheSender = By.cssSelector("input[placeholder='מספר נייד']");


        static By moreDetails = By.cssSelector("bm-body-1.text-link.theme");

        // פונקצייה לבדיקה האם מישהו אחר מסומן
        public static void isSelected_someOneElse() {
            selected(someOneElse);
        }
        // הזנה של שם פרטי בשדה
        public static void nameOfReceivesA_giftField() throws Exception {
            writeText(nameOfReceivesA_gift, (readFromFile("firstName")));
        }
        // רשימת אירועים - וכן בחירה של אירוע רנדומלי (עם שימוש בפונקציית הRand)
        public static void clickEvent() throws InterruptedException {
            click(event);
            Thread.sleep(500);
            WebElement industries = driver.findElement(By.cssSelector(".ember-view.bm-field.bm-select.show-options.with-icon.empty.md.with-label"));
            List<WebElement> events = industries.findElements(By.cssSelector(".ember-view.bm-select-option"));
            //for (WebElement element : events) {
            //   System.out.println(element.getText());
            //  }
            int num = (randomNum(events.size()));
            String value = events.get(num).getAttribute("value");
            Thread.sleep(500);
            WebElement ele = industries.findElement(By.cssSelector("li[value='" + value + "']"));
            ele.click();

        }
        // הזנת שם פרטי של מקבל המתנה שינוי
        public static void writingField() throws Exception {
            writeText(writingField, (readFromFile("firstName")));
        }
        // העלאת תמונה
        public static void click_uploadPicture() {
            driver.findElement(uploadPicture).sendKeys(pathPicture);
        }

        public static void click_submit() {
            click(submit);
        }

        public static void nowRadioButton_select() {
            selected(nowRadioButton);
        }

        public static void click_sms() {
            click(sms);
        }
        // הזנת מספר טלפון
        public static void phoneNumberField() throws Exception {
            writeText(phoneNumber, readFromFile("phoneNumber"));
        }
        // לבדוק
        public static void nameField() throws Exception {
            writeText(name, (readFromFile("firstName")));
        }
        //
        public static void phoneField() throws Exception {
            writeText(phoneNumberOfTheSender, readFromFile("phoneNumber"));
        }

        public static void click_submitButton() {
            click(submitButton);
        }

        public static void click_moreDetails() {
            click(moreDetails);
        }

        public static void senderGift() throws Exception {
            //isSelected_someOneElse();
            nameOfReceivesA_giftField();
            clickEvent();
            writingField();
            click_uploadPicture();
            Thread.sleep(3000);
            click_submit();
            nowRadioButton_select();
            click_sms();
            phoneNumberField();
            nameField();
            phoneField();
            click_submitButton();
        }
    }


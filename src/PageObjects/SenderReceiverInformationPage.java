package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.util.List;
import static Tests.BaseTest.randomNum;


public class SenderReceiverInformationPage extends BasePage {
    //static String noResult = "לא נמצאו תוצאות";

    String absolutePathToMyFile = "src/Data/image.jpeg";
    File path = new File(new File(absolutePathToMyFile).getAbsolutePath());
    String pathPicture = String.valueOf(path);


    public SenderReceiverInformationPage(WebDriver driver) {
        super(driver);
    }


    By someOneElseRadioButton = By.cssSelector(".ember-view.button.button-forSomeone.selected");
    By nameOfReceivesA_gift = By.cssSelector("input[type='text']");
    By events = By.cssSelector(".ember-view.bm-field.bm-select.with-icon.empty.md.with-label");
    By uploadPicture = By.cssSelector("input[type='file']");
    By nameOfSender = By.cssSelector("[data-parsley-group='voucher-greeting']");
    By submitButton = By.cssSelector("[type='submit']");
    By nowRadioButton = By.cssSelector("div.ember-view.button.button-now.selected");
    By sms = By.cssSelector("svg[gtm='method-sms']");
    By phoneNumber = By.id("sms");
    By name = By.cssSelector("[placeholder='שם שולח המתנה']");
    By continuePaymentButton = By.cssSelector("[type='submit']");
    By phoneNumberOfTheSender = By.cssSelector("input[placeholder='מספר נייד']");
    By moreDetails = By.cssSelector("bm-body-1.text-link.theme");

    // פונקצייה לבדיקה האם מישהו אחר מסומן
    public  void isSelected_someOneElse() {
        selected(someOneElseRadioButton);
    }
    // הזנה של שם פרטי בשדה
    public  void nameOfReceivesA_giftField() throws Exception {
        writeText(nameOfReceivesA_gift, (readFromFile("firstName")));
    }

    // רשימת אירועים - וכן בחירה של אירוע רנדומלי (עם שימוש בפונקציית הRand)
    public  void clickEvent() throws InterruptedException {
        click(events);
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
    public  void writingNameOfSenderField() throws Exception {
        writeText(nameOfSender, (readFromFile("firstName")));
    }
    // העלאת תמונה
    public  void click_uploadPicture() {
        driver.findElement(uploadPicture).sendKeys(pathPicture);
    }

    public  void click_submit() {
        click(continuePaymentButton);
    }

    public  void nowRadioButton_select() {
        selected(nowRadioButton);
    }

    public  void click_sms() {
        click(sms);
    }
    // הזנת מספר טלפון
    public  void phoneNumberField() throws Exception {
        writeText(phoneNumber, readFromFile("phoneNumber"));
    }
    // לבדוק
    public  void nameField() throws Exception {
        writeText(name, (readFromFile("firstName")));
    }
    //
    public  void phoneField() throws Exception {
        writeText(phoneNumberOfTheSender, readFromFile("phoneNumber"));
    }

    public void click_submitButton() {
        click(submitButton);
    }


    public void senderGift() throws Exception {
        //isSelected_someOneElse();
        nameOfReceivesA_giftField();
        clickEvent();
        writingNameOfSenderField();
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


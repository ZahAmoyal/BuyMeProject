package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.util.List;


public class SenderReceiverInformationPage extends BasePage {
    //static String noResult = "לא נמצאו תוצאות";

    String absolutePathToMyFile = "src/Data/image.jpeg";
    File path = new File(new File(absolutePathToMyFile).getAbsolutePath());
    String pathPicture = String.valueOf(path);

    //constructor
    public SenderReceiverInformationPage(WebDriver driver) {
        super(driver);
    }

    By checkPage = By.cssSelector("div.bottom-xs.bm-subtitle-1");
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


    public  void isSelected_someOneElse() {
        selected(someOneElseRadioButton);
    }

    public  void nameOfReceivesA_giftField() throws Exception {
        writeText(nameOfReceivesA_gift, (readFromFile("firstName")));
    }

// Select an event from the dropDown list
    public void chooseEvent() throws InterruptedException {
        click(events);
        Thread.sleep(500);
        WebElement events = driver.findElement(By.cssSelector(".ember-view.bm-field.bm-select.show-options.with-icon.empty.md.with-label"));
        List<WebElement> eventList = events.findElements(By.cssSelector(".ember-view.bm-select-option"));
        int num = (randomNum(1,eventList.size()));
        String value = eventList.get(num).getAttribute("value");
        WebElement chosenEvent = events.findElement(By.cssSelector("li[value='" + value + "']"));
        chosenEvent.click();

    }
    // הזנת שם פרטי של מקבל המתנה שינוי
    public void writingNameOfSenderField() throws Exception {
        writeText(nameOfSender, (readFromFile("firstName")));
    }
    // העלאת תמונה
    public void click_uploadPicture() {
        driver.findElement(uploadPicture).sendKeys(pathPicture);
    }

    public void click_submit() {
        click(continuePaymentButton);
    }

    public void nowRadioButton_select() {
        selected(nowRadioButton);
    }

    public void click_sms() {
        click(sms);
    }
    // הזנת מספר טלפון
    public void phoneNumberField() throws Exception {
        writeText(phoneNumber, readFromFile("phoneNumber"));
    }
   /* // לבדוק
    public  void nameField() throws Exception {
        writeText(name, (readFromFile("firstName")));
    }
    //*/

    public void phoneField() throws Exception {
        writeText(phoneNumberOfTheSender, readFromFile("phoneNumber"));
    }

    public void click_submitButton() {
        click(submitButton);
    }

    public void checkPage() throws Exception {
        checkElementStatus(checkPage,readFromFile("payment"));
    }
}


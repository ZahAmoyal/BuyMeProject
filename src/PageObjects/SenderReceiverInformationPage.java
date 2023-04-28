package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.util.List;


public class SenderReceiverInformationPage extends BasePage {

    private String absolutePathToMyFile = "src/Data/image.jpeg";
    private File path = new File(new File(absolutePathToMyFile).getAbsolutePath());
    private String pathPicture = String.valueOf(path);

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
    By phoneNumberReceiver = By.id("sms");
    By continuePaymentButton = By.cssSelector("[type='submit']");
    By phoneNumberOfTheSender = By.cssSelector("input[placeholder='מספר נייד']");

// פונקצייה המוודאת האם האלמנט נבחר, אם כן היא לא עושה דבר, אם לא היא מבצעת לחיצה על האלמנט
    public  void isSelected_someOneElse() {
        selected(someOneElseRadioButton);
    }
// פונקצייה המזינה את שדה מקבל המתנה
    public  void nameOfReceivesA_giftField() throws Exception {
        writeText(nameOfReceivesA_gift, (readFromFile("Receiver")));
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
        writeText(nameOfSender, (readFromFile("Blessing")));
    }
    // העלאת תמונה
    public void click_uploadPicture() {
        driver.findElement(uploadPicture).sendKeys(pathPicture);
    }
    //לחיצה על כפתור sumbit
    public void click_submit() {
        click(continuePaymentButton);
    }
// פונקצייה המוודאת האם האלמנט נבחר, אם כן היא לא עושה דבר, אם לא היא מבצעת לחיצה על האלמנט
    public void nowRadioButton_select() {
        selected(nowRadioButton);
    }
    // פונקצייה הלוחצת על כפתור SMS
    public void click_sms() {
        click(sms);
    }
    // הזנת שדה מספר פלאפון של המקבל
    public void phoneNumberField() throws Exception {
        writeText(phoneNumberReceiver, readFromFile("phoneNumberReceiver"));
    }
// הזנת שדה מספר פלאפון של השולח
    public void writePhoneFieldSender() throws Exception {
        writeText(phoneNumberOfTheSender, readFromFile("phoneNumberSender"));
    }
    //לחיצה על כפתור sumbit
    public void click_submitButton() {
        click(submitButton);
    }
//פונקצייה המוודא שהגעתי למסך הנכון בעזרת ASSERT והיא מקבלת אלמנט וכן טקסט ובודקת האם הוא קיים
    public void checkPage() throws Exception {
        checkElementStatus(checkPage,readFromFile("payment"));
    }
}


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

    private By checkPage = By.cssSelector("div.bottom-xs.bm-subtitle-1");
    final By someOneElseRadioButton = By.cssSelector(".ember-view.button.button-forSomeone.selected");
    final By nameOfReceivesA_gift = By.cssSelector("input[type='text']");
    final By events = By.cssSelector(".ember-view.bm-field.bm-select.with-icon.empty.md.with-label");
    final By uploadPicture = By.cssSelector("input[type='file']");
    final By nameOfSender = By.cssSelector("[data-parsley-group='voucher-greeting']");
    final By submitButton = By.cssSelector("[type='submit']");
    final By nowRadioButton = By.cssSelector("div.ember-view.button.button-now.selected");
    final By sms = By.cssSelector("svg[gtm='method-sms']");
    final By phoneNumberReceiver = By.id("sms");
    final By continuePaymentButton = By.cssSelector("[type='submit']");
    final By phoneNumberOfTheSender = By.cssSelector("input[placeholder='מספר נייד']");

    // A function for checking whether an element was chosen: if it was, it does nothing; if it wasn't, it clicks the element
    public void isSelected_someOneElse() {
        selected(someOneElseRadioButton);
    }

    // A function for filling the receiver's name field with a string value from the xml config file
    public void nameOfReceivesA_giftField() throws Exception {
        writeText(nameOfReceivesA_gift, (readFromFile("Receiver")));
    }

    // Select an event from the dropDown list
    public void chooseEvent() throws InterruptedException {
        click(events);
        Thread.sleep(500);
        WebElement events = driver.findElement(By.cssSelector(".ember-view.bm-field.bm-select.show-options.with-icon.empty.md.with-label"));
        List<WebElement> eventList = events.findElements(By.cssSelector(".ember-view.bm-select-option"));
        int num = (randomNum(2, eventList.size()));
        String value = eventList.get(num).getAttribute("value");
        WebElement chosenEvent = events.findElement(By.cssSelector("li[value='" + value + "']"));
        chosenEvent.click();
    }

    // A function for filling the receiver's first name field with a string value from the xml config file
    public void writingNameOfSenderField() throws Exception {
        writeText(nameOfSender, (readFromFile("Blessing")));
    }

    // A function for uploading a picture
    public void click_uploadPicture() {
        driver.findElement(uploadPicture).sendKeys(pathPicture);
    }

    //A function for clicking the submit button
    public void click_submit() {
        click(continuePaymentButton);
    }

    // A function for checking whether an element was chosen: if it was, it does nothing; if it wasn't, it clicks the element
    public void nowRadioButton_select() {
        selected(nowRadioButton);
    }

    // A function for clicking the SMS button
    public void click_sms() {
        click(sms);
    }

    // A function for filling the receiver's phone number field with a string value from the xml config file
    public void phoneNumberField() throws Exception {
        writeText(phoneNumberReceiver, readFromFile("phoneNumberReceiver"));
    }

    // A function for filling the sender's phone number field with a string value from the xml config file
    public void writePhoneFieldSender() throws Exception {
        writeText(phoneNumberOfTheSender, readFromFile("phoneNumberSender"));
    }

    //A function for clicking the submit button
    public void click_submitButton() {
        click(submitButton);
    }


    public String getCheckPage() {
        return getText(checkPage);
    }

    public String getAssertExpected() throws Exception {
        return readFromFile("myAccount");
    }

}


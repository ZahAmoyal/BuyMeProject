package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Tests.BaseTest.randomNum;
import static Tests.BaseTest.readFromFile;
import static org.openqa.selenium.By.tagName;

public class ChooseGiftPage extends BasePage {
    WebElement eventOpen;

    static By someOneElse = By.cssSelector(".ember-view.button.button-forSomeone.selected");
    static By nameOfReceivesA_gift = By.cssSelector("input[title='שם מקבל המתנה']");
    static By event = By.cssSelector(".ember-view.bm-field.bm-select.with-icon.empty.md.with-label");
    //static By eventOpen = By.cssSelector(".ember-view.bm-field.bm-select.show-options.with-icon.empty.md.with-label");

    static By writingField = By.cssSelector("[data-parsley-group=\"voucher-greeting\"]");
    static By uploadPicture = By.cssSelector(".media-circle-btn.ember-view.bm-media-upload");
    static By submit = By.cssSelector("[type=\"submit\"]");


    static By nowRadioButton = By.cssSelector(".ember-view.button.button-now.selected");
    static By sms = By.cssSelector("svg[gtm=\"method-sms\"]");
    static By phoneNumber = By.id("sms");
    static By name = By.cssSelector("[placeholder=\"שם שולח המתנה\"]");
    static By submitButton = By.cssSelector("[type=\"submit\"]");

    static By moreDetails = By.cssSelector("bm-body-1.text-link.theme");

    public ChooseGiftPage(WebDriver driver) {
        super(driver);
    }


    public static void isSelected_someOneElse() {
        selected(someOneElse);
    }

    public static void nameOfReceivesA_giftField() throws Exception {
        writeText(nameOfReceivesA_gift, (readFromFile("firstName")));
    }

    public static void clickEvent() throws InterruptedException {
        click(event);
        Thread.sleep(500);
        WebElement industries = driver.findElement(By.cssSelector(".ember-view.bm-field.bm-select.show-options.with-icon.empty.md.with-label"));
        List<WebElement> events = industries.findElements(By.cssSelector(".ember-view.bm-select-option"));
        for (WebElement element : events) {
            System.out.println(element.getText());
        }
        int num = (randomNum(events.size()));
        String id = events.get(num).getAttribute("id");
        Thread.sleep(500);
        industries.findElement(By.cssSelector("li[id="+id+"]")).click();

    }

    public static void writingField() throws Exception {
        writeText(writingField, (readFromFile("firstName")));
    }

    public static void click_uploadPicture() {
        click(uploadPicture);
    }
    //driver.findElement(By.id(browseButton)).sendKeys("<absolutePathToMyFile>");

    public static void click_submit() {
        click(submit);
    }

    public ChooseGiftPage nowRadioButton_select() {
        selected(nowRadioButton);
        return this;
    }

    public ChooseGiftPage click_sms() {
        click(sms);
        return this;
    }

    public ChooseGiftPage phoneNumberField() throws Exception {
        writeText(phoneNumber, (readFromFile("0543103356")));
        return this;
    }

    public ChooseGiftPage nameField() throws Exception {
        writeText(name, (readFromFile("firstName")));
        return this;
    }

    public ChooseGiftPage click_submitButton() {
        click(submitButton);
        return this;
    }

    public ChooseGiftPage click_moreDetails() {
        click(moreDetails);
        return this;
    }
}

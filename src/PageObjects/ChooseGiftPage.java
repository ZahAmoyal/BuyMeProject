package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;
import static org.openqa.selenium.By.tagName;

public class ChooseGiftPage extends BasePage {

    private By title = By.cssSelector("h1.bm-h1");
    By footer = By.cssSelector(".ember-view.bm-mini-footer");

    //constructor
    public ChooseGiftPage(WebDriver driver) {
        super(driver);
    }


    // A function for receiving a list and returning a random value (using rand function)
    public void pickFromBusinessList() throws InterruptedException {
        WebElement businesses = driver.findElement(By.cssSelector("ul.grid.bm-product-cards"));
        List<WebElement> businessList = businesses.findElements(By.cssSelector("div.ember-view.bm-product-card-link.mx-4.lr-6.sm-12"));
        String numValue = businessList.get(randomNum(0,businessList.size())).getAttribute("id");
        WebElement choose = businesses.findElement(By.cssSelector("[id=" + numValue + "]"));
        choose.click();
    }

    // A function for receiving a list and returning a random value (using rand function)
    public void pickSubOption() throws InterruptedException {
        Thread.sleep(1500);
        WebElement business = driver.findElement(By.cssSelector(".grid.gifts-list"));
        List<WebElement> subBusiness = business.findElements(tagName("li"));
        String subNumValue = subBusiness.get(randomNum(0,subBusiness.size())).getAttribute("id");
        WebElement choose = driver.findElement(By.cssSelector("[id=" + subNumValue + "]"));
        if (choose.getText().contains("נוספים")) {
            choose.click();
        } else {
            WebElement chosen = driver.findElement(By.cssSelector("input[placeholder='הכנס סכום']"));
            chosen.sendKeys("500");
            chosen.sendKeys(Keys.ENTER);
        }
    }
/*// A function for comparing between an element and a string value from the xml config file
    public void checkPage() throws Exception {
       // checkElementStatus(title, readFromFile("title"));
        //return "Fail";
    }*/
    // A function for scrolling down to a desired element, taking a screenshot and add it to the report
    public void scrollAndTakeScreenShot(){
        WebElement bottomPage = driver.findElement(footer);
        moveElement(bottomPage);
    }

    public String getTitle() {
        return getText(title);
    }
    public String getAssertExpected() throws Exception {
        return readFromFile("title");
    }
}


package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;
import static org.openqa.selenium.By.tagName;

public class ChooseGiftPage extends BasePage {

    By title = By.cssSelector("h1.bm-h1");
    By footer = By.cssSelector(".ember-view.bm-mini-footer");

    //constructor
    public ChooseGiftPage(WebDriver driver) {
        super(driver);
    }


    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public void pickFromBusinessList() throws InterruptedException {
        //Thread.sleep(3000);
        WebElement businesses = driver.findElement(By.cssSelector("ul.grid.bm-product-cards"));
        List<WebElement> businessList = businesses.findElements(By.cssSelector("div.ember-view.bm-product-card-link.mx-4.lr-6.sm-12"));
        String numValue = businessList.get(randomNum(0,businessList.size())).getAttribute("id");
        //Thread.sleep(1000);
        WebElement choose = businesses.findElement(By.cssSelector("[id=" + numValue + "]"));
        choose.click();
    }

    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
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
    // פונקתייה המשווה בין אלמנט לבין טקסט המגיע מהxml
    public boolean checkPage() throws Exception {
        return checkElementStatus(title,readFromFile("title"));
    }
// פונקצייה שמשתמשת בפונקציית הגלילה לאלמנט ובנוסף מבצעת צילום והוספה לדוח
    public void scrollAndTakeScreenShot(){
        WebElement bottomPage = driver.findElement(footer);
        moveElement(bottomPage);
    }
}


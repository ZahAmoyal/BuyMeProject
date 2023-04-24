package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static Tests.BaseTest.randomNum;
import static org.openqa.selenium.By.tagName;

public class ChooseGiftPage extends BasePage {

    static String noResult = "לא נמצאו תוצאות";

    public ChooseGiftPage(WebDriver driver) {
        super(driver);
    }

    By title = By.cssSelector(".title-xxl.bottom-md.top-none");

    public boolean checkTitle() {
        String result = getText(title);
        if (result.contains(noResult))
            return true;
        return false;
    }

    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public void choosing_A_gift_from_a_list() throws InterruptedException {
        Thread.sleep(1500);
        WebElement industries = driver.findElement(By.cssSelector(".grid.gifts-list"));
        List<WebElement> zah1 = industries.findElements(tagName("li"));
        String numValue = zah1.get(randomNum(zah1.size())).getAttribute("id");
        WebElement choose = driver.findElement(By.cssSelector("[id=" + numValue + "]"));
        if (choose.getText().contains("נוספים")) {
            choose.click();
        } else {
            WebElement chosen = driver.findElement(By.cssSelector("input[placeholder='הכנס סכום']"));
            chosen.sendKeys("500");
            chosen.sendKeys(Keys.ENTER);

        }
    }

    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public void choosing_A_gift() throws InterruptedException {
        Thread.sleep(3000);
        WebElement industries = driver.findElement(By.cssSelector("ul.grid.bm-product-cards"));
        List<WebElement> shops = industries.findElements(By.cssSelector("div.ember-view.bm-product-card-link.mx-4.lr-6.sm-12"));
        String numValue = shops.get(randomNum(shops.size())).getAttribute("id");
        Thread.sleep(1000);
        WebElement choose = industries.findElement(By.cssSelector("[id=" + numValue + "]"));
        choose.click();
    }
}


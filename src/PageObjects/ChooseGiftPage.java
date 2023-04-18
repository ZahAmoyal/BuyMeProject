package PageObjects;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Tests.BaseTest.randomNum;
import static Tests.BaseTest.readFromFile;
import static org.openqa.selenium.By.partialLinkText;
import static org.openqa.selenium.By.tagName;

public class ChooseGiftPage extends BasePage {


    public ChooseGiftPage(WebDriver driver) {
        super(driver);
    }

    static String noResult = "לא נמצאו תוצאות";

    static By title = By.cssSelector(".title-xxl.bottom-md.top-none");

    public static boolean checkTitle() {
        String result = getText(title);
        if (result.contains(noResult))
            return true;
        return false;
    }

    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public static void choosing_A_gift_from_a_list() throws InterruptedException {
        Thread.sleep(3000);
        WebElement industries = driver.findElement(By.cssSelector(".grid.gifts-list"));
        List<WebElement> zah1 = industries.findElements(tagName("li"));
        //String numValue = zah1.get(randomNum(zah1.size())).getAttribute("class");
        //System.out.println(numValue);
        //WebElement choose = industries.findElement(By.cssSelector("[class=" + numValue + "]"));
        WebElement choose = industries.findElement(By.cssSelector("li.ember-view.bm-gift-card-link"));
        //Thread.sleep(1000);
        //String dis = choose.getText();
        //System.out.println(dis);
        //if ((choose.findElement(By.cssSelector("div.ember-view.bm-gift-card.money")).isDisplayed()))
        WebElement submit = choose.findElement(By.tagName("button"));
        if (!choose.findElement(By.cssSelector("input[placeholder='הכנס סכום']")).isDisplayed()) {
            //WebElement submit = choose.findElement(By.tagName("button"));//zah1.get(num).findElement(By.cssSelector("div[class='bottom bm-subtitle-1'] button"));
            submit.click();
        } else {
            choose.findElement(By.cssSelector("input[placeholder='הכנס סכום']")).sendKeys("500");
            Thread.sleep(1000);
            submit.click();
            //WebElement submit = zah1.get(num).findElement(By.cssSelector("div[class='bottom bm-subtitle-1'] button"));
            //submit.click();
        }
    }

    public static void chooseGift() throws Exception {
        //LoginFlow.loginFlow();
        choosing_A_gift();
        choosing_A_gift_from_a_list();
    }

    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public static void choosing_A_gift() throws InterruptedException {
        Thread.sleep(3000);
        WebElement industries = driver.findElement(By.cssSelector("ul.grid.bm-product-cards"));
        List<WebElement> shops = industries.findElements(By.cssSelector("div.ember-view.bm-product-card-link.mx-4.lr-6.sm-12"));
        String numValue = shops.get(randomNum(shops.size())).getAttribute("id");
        Thread.sleep(1000);
        WebElement choose = industries.findElement(By.cssSelector("[id=" + numValue + "]"));
        choose.click();
    }
}

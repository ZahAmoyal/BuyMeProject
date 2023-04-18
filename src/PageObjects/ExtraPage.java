package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ExtraPage extends BasePage {


    public ExtraPage(WebDriver driver) {
        super(driver);
    }
    //static WebElement loadingDots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div"));
    static WebElement loadingDots = driver.findElement(By.cssSelector("div.spinner"));


    public static void printLoadingDots() {
        System.out.println("Size of the box is: " + loadingDots.getSize());
    }
}

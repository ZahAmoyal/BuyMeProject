package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


import java.util.List;

import static Tests.BaseTest.*;
import static org.openqa.selenium.By.tagName;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    static By login_SignUpButton = By.cssSelector("[class=\"notSigned\"]");
    static By sum = By.cssSelector("span[alt=\"סכום\"]");
    static By area = By.cssSelector("[title=\"אזור\"]");
    static By category = By.cssSelector("[title=\"קטגוריה\"]");
    static By submit = By.cssSelector("a.ember-view.bm-btn.no-reverse.main.md.ember-view");


    public static void clickLoginSignUpButton() {
        click(login_SignUpButton);
    }

    public static void clickArea() {
        click(area);
    }

    public static void clickCategory() {
        click(category);
    }

    public static void clickSubmit() {
        click(submit);
    }

    public static void clickSum() {
        click(sum);
    }
    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public static void ChooseAnAmount() throws InterruptedException {
        HomePage.clickSum();
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        List<WebElement> sum = industries.findElements(tagName("li"));
        String numValue= sum.get(randomNum(sum.size())).getAttribute("id");
        WebElement choose = industries.findElement(By.cssSelector("li[id=\"" + (numValue) + "\"]"));
        choose.click();
    }
    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public static void SelectAnArea() throws InterruptedException {
        HomePage.clickArea();
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        List<WebElement> area = industries.findElements(tagName("li"));
        String numValue= area.get(randomNum(area.size())).getAttribute("id");
        WebElement choose = industries.findElement(By.cssSelector("[id=\"" + (numValue) + "\"]"));
        choose.click();
    }
    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public static void categorySelection() throws InterruptedException {
        HomePage.clickCategory();
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.search.with-icon.empty.md.no-label.with-search"));
        List<WebElement> category = industries.findElements(tagName("li"));
        String numValue= category.get(randomNum(category.size())).getAttribute("id");
        WebElement choose = industries.findElement(By.cssSelector("[id=\"" + (numValue) + "\"]"));
        choose.click();
    }
// פונקצייה המאחדת את כל הפונקציות של הדף
    public static void searchGift() throws Exception {
            ChooseAnAmount();
            SelectAnArea();
            categorySelection();
            clickSubmit();
    }
}


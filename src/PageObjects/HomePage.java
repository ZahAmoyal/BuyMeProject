package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static Tests.BaseTest.randomNum;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By popUp = By.cssSelector("div.adoric_element.element-shape.closeLightboxButton");
    By login_SignUpButton = By.cssSelector("li[class='notSigned']");
    By sum = By.cssSelector("span[alt=\"סכום\"]");
    By area = By.cssSelector("[title=\"אזור\"]");
    By category = By.cssSelector("[title=\"קטגוריה\"]");
    By submit = By.cssSelector("a.ember-view.bm-btn.no-reverse.main.md.ember-view");


    public void clickLoginSignUpButton() {
        click(login_SignUpButton);
    }

    public void clickArea() {
        click(area);
    }

    public void clickCategory() {
        click(category);
    }

    public void clickSubmit() {
        click(submit);
    }

    public void clickSum() {
        click(sum);
    }

    // פונקצייה לסגירת פופאפ שהיה (כרגע לא פעיל)
    public void ifDis() {
        if (displayed(popUp)) {
            click(popUp);
        }
    }

    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public void chooseAnAmount() throws InterruptedException {
        this.clickSum();
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        List<WebElement> sum = industries.findElements(By.tagName("li"));
        String numValue = sum.get(randomNum(sum.size())).getAttribute("id");
        WebElement choose = industries.findElement(By.cssSelector("li[id=\"" + (numValue) + "\"]"));
        choose.click();
    }

    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public void SelectAnArea() throws InterruptedException {
        this.clickArea();
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        List<WebElement> area = industries.findElements(By.tagName("li"));
        String numValue = area.get(randomNum(area.size())).getAttribute("id");
        WebElement choose = industries.findElement(By.cssSelector("[id=\"" + (numValue) + "\"]"));
        choose.click();
    }

    // פונקצייה לקבלת רשימה ובחירת ערך רנדומלי (נעזר בפנקציית rand)
    public void categorySelection() throws InterruptedException {
        this.clickCategory();
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.search.with-icon.empty.md.no-label.with-search"));
        List<WebElement> category = industries.findElements(By.tagName("li"));
        String numValue = category.get(randomNum(category.size())).getAttribute("id");
        WebElement choose = industries.findElement(By.cssSelector("[id=\"" + (numValue) + "\"]"));
        choose.click();
    }
// פונקצייה המאחדת את כל הפונקציות של הדף
    /*public void searchGift() throws Exception {
            chooseAnAmount();
            SelectAnArea();
            categorySelection();
            clickSubmit();
    }*/
}


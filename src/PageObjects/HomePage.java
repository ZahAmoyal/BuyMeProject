package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    //constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    final By popUp = By.cssSelector("div.adoric_element.element-shape.closeLightboxButton");
    final By popUp2 = By.cssSelector("button[aria-label=\"close\"]");
    final By login_SignUpButton = By.cssSelector("li[class='notSigned']");
    final By sum = By.cssSelector("span[alt='סכום']");
    final By area = By.cssSelector("span[title='אזור']");
    final By category = By.cssSelector("span[title='קטגוריה']");
    final By submit = By.cssSelector("a.ember-view.bm-btn.no-reverse.main.md.ember-view");
    final By searchResult = By.cssSelector(".title-xxl.bottom-md.top-none");
    private By searchText = By.cssSelector("span[class=\"text\"]");
    final By logo = By.cssSelector("img[alt=\"לוגו BUY-ME\"]");

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

    // A function for closing the popup window (not active at the moment)
    public void ifDisPopUpAppear_OnTheRightSideScreen() {
        if (displayed(popUp) || displayed(popUp2)) {
            click(popUp);
        }
    }

    public void ifDispopUpAppear_OnTheBigScreen() {
        if (displayed(popUp2)) {
            click(popUp2);
        }
    }

    // A function for choosing a sum using the main function for finding a random value
    public void chooseAnAmount() throws InterruptedException {
        this.clickSum();
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        selectFromDropDown(industries, 2).click();
    }

    // A function for choosing an area using the main function for finding a random value
    public void selectAnArea() throws InterruptedException {
        this.clickArea();
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        selectFromDropDown(industries, 2).click();
    }

    // A function for choosing category using the main function for finding a random value
    public void categorySelection() throws InterruptedException {
        this.clickCategory();
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.search.with-icon.empty.md.no-label.with-search"));
        selectFromDropDown(industries, 3).click();
    }


    //A function for pressing the logo button
    public void clickLogo() {
        click(logo);
    }

    // A function for checking whether the text string contains a desired string which returns a boolean value
    public boolean checkTitle() throws Exception {
        if (getText(searchResult).contains(readFromFile("result"))) {
            clickLogo();
            return true;
        } else {
            return false;
        }
    }

    public String getSearchText() {
        return getText(searchText);
    }

    public String getAssertExpected() throws Exception {
        return readFromFile("search");
    }

    public void loading() {
        WebElement element = null;
        do {
            driver.navigate().refresh();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // set timeout to 10 seconds
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("app-loading-img")));
            //Thread.sleep(2000);
        } while (element.getSize() != null);
        System.out.println("The size of the screen is:" + element.getSize());
    }
}


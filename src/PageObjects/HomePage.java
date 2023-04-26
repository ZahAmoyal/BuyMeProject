package PageObjects;

import org.openqa.selenium.*;

import java.util.List;

public class HomePage extends BasePage {

    //constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By popUp = By.cssSelector("div.adoric_element.element-shape.closeLightboxButton");
    By login_SignUpButton = By.cssSelector("li[class='notSigned']");
    By sum = By.cssSelector("span[alt='סכום']");
    By area = By.cssSelector("span[title='אזור']");
    By category = By.cssSelector("span[title='קטגוריה']");
    By submit = By.cssSelector("a.ember-view.bm-btn.no-reverse.main.md.ember-view");
    By searchResult = By.cssSelector(".title-xxl.bottom-md.top-none");
    By searchText = By.cssSelector("span[class=\"text\"]");
    By logo = By.cssSelector("img[alt=\"לוגו BUY-ME\"]");
    By myAccountDropDown = By.cssSelector(".ember-view.dropdown.solid");
    By logOutButton = By.cssSelector("a[class=\"dropdown-item\"]");
    //WebElement loadingweb = driver.findElement(By.cssSelector("[id='app-loading-img']"));
    //List<WebElement> loading = loadingweb.findElements(By.tagName("div"));

    public void clickMyAccount() {
        click(myAccountDropDown);
    }
    public void clickLogOut(){
        click(logOutButton);
    }

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

    public void chooseAnAmount() {
        this.clickSum();
        selectFromDropDown().click();
    }

    public void selectAnArea() {
        this.clickArea();
        selectFromDropDown().click();
    }

    public void categorySelection() throws InterruptedException {
        this.clickCategory();
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.search.with-icon.empty.md.no-label.with-search"));
        List<WebElement> category = industries.findElements(By.tagName("li"));
        String numValue = category.get(randomNum(1, category.size())).getAttribute("id");
        WebElement choose = industries.findElement(By.cssSelector("li[id=\"" + (numValue) + "\"]"));
        choose.click();
    }

//
    public WebElement selectFromDropDown() {
        WebElement industries = driver.findElement(By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label"));
        List<WebElement> dropDown = industries.findElements(By.tagName("li"));
        String numValue = dropDown.get(randomNum(1, dropDown.size())).getAttribute("id");
        WebElement choose = industries.findElement(By.cssSelector("li[id=\"" + (numValue) + "\"]"));
        return choose;
    }
    public void clickLogo(){
        click(logo);
    }

    public boolean checkTitle() throws Exception {
        if (getText(searchResult).contains(readFromFile("result"))){
            clickLogo();
            return true;
        }
        else{
            return false;
        }
    }

    public void checkPage() throws Exception {
        System.out.println(getText(searchText));
        checkElementStatus(searchText,readFromFile("search"));
    }
}


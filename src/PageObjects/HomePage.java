package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static Tests.BaseTest.randomNum;
import static org.openqa.selenium.By.tagName;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    static By login_SignUpButton = By.cssSelector("[class=\"notSigned\"]");
    static By sum = By.cssSelector("[title=\"סכום\"]");
    static By area = By.cssSelector("[title=\"אזור\"]");
    static By category = By.cssSelector("[title=\"קטגוריה\"]");
    static By submit = By.cssSelector("a.ember-view.bm-btn.no-reverse.main.md.ember-view");


    public void clickLoginSignUpButton() {
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

}


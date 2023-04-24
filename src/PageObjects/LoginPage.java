package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //By registerButton = By.cssSelector("[class=\"text-link theme\"]");
    By emailField = By.cssSelector("[placeholder=\"מייל\"]");
    By passwordField = By.cssSelector("[placeholder=\"סיסמה\"]");
    //By rememberMeCheckBox = By.cssSelector(".ember-view.bm-checkbox.checked [class=\"fill\"]");
    By loginToBuyMeButton = By.cssSelector("[type=\"submit\"]");


    /*public void click_RegisterButton() {
        click(registerButton);
    }*/

    public void emailField() throws Exception {
        writeText(emailField, readFromFile("email"));
    }

    public void passwordField() throws Exception {
        writeText(passwordField, readFromFile("password"));
    }

    public void loginToBuyMe() {
        click(loginToBuyMeButton);
    }

}
/*
    public LoginPage rememberMeCheckBox(){
        click(rememberMeCheckBox);
        return this;
    }
 */



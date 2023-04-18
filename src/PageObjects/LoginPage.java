package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Tests.BaseTest.readFromFile;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    static By registerButton = By.cssSelector("[class=\"text-link theme\"]");
    static By emailField = By.cssSelector("[placeholder=\"מייל\"]");
    static By passwordField = By.cssSelector("[placeholder=\"סיסמה\"]");
    //By rememberMeCheckBox = By.cssSelector(".ember-view.bm-checkbox.checked [class=\"fill\"]");
    static By loginToBuyMeButton = By.cssSelector("[type=\"submit\"]");


    public static void  click_RegisterButton() {
        click(registerButton);
    }
    // להוסיף ReadFromFile
    public static void emailField(String email){
        writeText(emailField,email);
    }
    // להוסיף ReadFromFile
    public static void passwordField(String password){
        writeText(passwordField,password);
    }

    public static void loginToBuyMe(){
        click(loginToBuyMeButton);
    }
// התחברות על ידי הכנסת כל הפעולות
    public static void loginBuyMe() throws Exception {
        HomePage.clickLoginSignUpButton();
        LoginPage.emailField((readFromFile("email")));
        LoginPage.passwordField(readFromFile("password"));
        LoginPage.loginToBuyMe();
    }
}
/*
    public LoginPage rememberMeCheckBox(){
        click(rememberMeCheckBox);
        return this;
    }
 */



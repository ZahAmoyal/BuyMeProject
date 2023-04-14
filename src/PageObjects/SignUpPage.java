package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    //By xButton = By.cssSelector("[id=\"times\"]");
    //By signIn = By.cssSelector("[class=\"text-link theme\"]");
    //By registerWithFacebook = By.cssSelector("[class=\"social-btn.facebook\"]");
    //By registerWithGoogle = By.cssSelector("[class=\"social-btn.google\"]");
    By registerButton = By.cssSelector("li[class=\"notSigned\"]");
    By firstNameField = By.cssSelector("[placeholder=\"שם פרטי\"]");
    By emailField = By.cssSelector("[placeholder=\"מייל\"]");
    By passwordField = By.cssSelector("[placeholder=\"סיסמה\"]");
    By password_Authentication = By.cssSelector("[placeholder=\"אימות סיסמה\"]");
    static By checkBox_IAgree = By.cssSelector("div.login-options.grid.register-text");
    By submitButton = By.cssSelector("[gtm=\"הרשמה ל-BUYME\"]");

    public SignUpPage clickRegisterButton() {
        click(registerButton);
        return this;
    }

    public SignUpPage writeTextFirstNameField(String firstName){
        writeText(firstNameField,firstName);
        return this;
    }
    public SignUpPage writeTextEmailField(String email){
        writeText(emailField,email);
        return this;
    }
    public SignUpPage writeTextPasswordField(String password){
        writeText(passwordField,password);
        return this;
    }
    public SignUpPage writeTextPassword_Authentication(String passwordAuthentication) {
        writeText(password_Authentication, passwordAuthentication);
        return this;
    }
    public static void clickCheckBox_IAgree(){
        selected(checkBox_IAgree);
    }
    public SignUpPage clickSubmitButton(){
        click(submitButton);
        return this;
    }
}
/*
 public SignUpPage clickSignIn(){
        click(signIn);
        return this;
    }
public SignUpPage clickXButton() {
        click(xButton);
        return this;
    }
        public SignUpPage clickRegisterWithFacebook(){
        click(registerWithFacebook);
        return this;
    }
    public SignUpPage clickRegisterWithGoogle(){
        click(registerWithGoogle);
        return this;
    }
 */

package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    //Constructor
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    //
    By signUp = By.cssSelector("[class=\"text-link theme\"]");
    private By firstNameField = By.cssSelector("[placeholder=\"שם פרטי\"]");
    private By emailField = By.cssSelector("[placeholder=\"מייל\"]");
    private By passwordField = By.cssSelector("[placeholder=\"סיסמה\"]");
    private By password_Authentication = By.cssSelector("[placeholder=\"אימות סיסמה\"]");
    By checkBox_IAgree = By.cssSelector("div.login-options.grid.register-text");
    By submitButton = By.cssSelector("[gtm=\"הרשמה ל-BUYME\"]");
    By logOutButton = By.cssSelector("a[class=\"dropdown-item\"]");

    public void clickSignUp() {
        click(signUp);
    }

    public void writeTextFirstNameField() throws Exception {
        writeText(firstNameField,readFromFile("firstName"));
    }

    public void writeTextEmailField() throws Exception {
        writeText(emailField,readFromFile("email"));
    }

    public void writeTextPasswordField() throws Exception {
        writeText(passwordField,readFromFile("password"));
    }

    public void writeTextPassword_Authentication() throws Exception {
        writeText(password_Authentication, readFromFile("password"));
    }

    public void clickCheckBox_IAgree(){
        selected(checkBox_IAgree);
    }

    public void clickSubmitButton(){
        click(submitButton);
    }

    public void check() throws Exception {
        checkElementStatus(logOutButton,readFromFile("myAccount"));
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

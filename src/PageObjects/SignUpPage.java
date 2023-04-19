package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Tests.BaseTest.readFromFile;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    //By signIn = By.cssSelector("[class=\"text-link theme\"]");
    static By registerButton = By.cssSelector("li[class=\"notSigned\"]");
    private static By firstNameField = By.cssSelector("[placeholder=\"שם פרטי\"]");
    private static By emailField = By.cssSelector("[placeholder=\"מייל\"]");
    private static By passwordField = By.cssSelector("[placeholder=\"סיסמה\"]");
    private static By password_Authentication = By.cssSelector("[placeholder=\"אימות סיסמה\"]");
     static By checkBox_IAgree = By.cssSelector("div.login-options.grid.register-text");
     static By submitButton = By.cssSelector("[gtm=\"הרשמה ל-BUYME\"]");

    public static void clickRegisterButton() {
        click(registerButton);
    }

    public static void writeTextFirstNameField(String firstName){
        writeText(firstNameField,firstName);
    }
    public static void writeTextEmailField(String email){
        writeText(emailField,email);
    }
    public static void writeTextPasswordField(String password){
        writeText(passwordField,password);

    }
    public static void writeTextPassword_Authentication(String passwordAuthentication) {
        writeText(password_Authentication, passwordAuthentication);
    }
    public static void clickCheckBox_IAgree(){
        selected(checkBox_IAgree);
    }
    public static void clickSubmitButton(){
        click(submitButton);
    }
     public static void signUp() throws Exception {
         HomePage.clickLoginSignUpButton();
         LoginPage.click_RegisterButton();
         SignUpPage.writeTextFirstNameField(readFromFile("firstName"));
         SignUpPage.writeTextEmailField(readFromFile("email"));
         SignUpPage.writeTextPasswordField(readFromFile("password"));
         SignUpPage.writeTextPassword_Authentication(readFromFile("password"));
         SignUpPage.clickCheckBox_IAgree();
         SignUpPage.clickSubmitButton();
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

package PageObjects;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    //Constructor
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    //
    By signUpButton = By.cssSelector("[class=\"text-link theme\"]");
    private By firstNameField = By.cssSelector("[placeholder=\"שם פרטי\"]");
    private By emailField = By.cssSelector("[placeholder=\"מייל\"]");
    private By passwordField = By.cssSelector("[placeholder=\"סיסמה\"]");
    private By password_Authentication = By.cssSelector("[placeholder=\"אימות סיסמה\"]");
    By checkBox_IAgree = By.cssSelector("div.login-options.grid.register-text");
    By submitButton = By.cssSelector("[gtm=\"הרשמה ל-BUYME\"]");
    private By logOutButton = By.cssSelector("a[class=\"dropdown-item\"]");


    public String getLogOutButton() {
        return getText(logOutButton);
    }
    public String getAssertExpected() throws Exception {
        return readFromFile("myAccount");
    }


    // A function for clicking the signup button
    public void clickSignUp() {
        click(signUpButton);
    }
    // A function for filling the first name field with a string value from the xml config file
    public void writeTextFirstNameField() throws Exception {
        writeText(firstNameField,readFromFile("firstName"));
    }
    // A function for filling the email field with a string value from the xml config file
    public void writeTextEmailField() throws Exception {
        writeText(emailField,generateRandomEmailAddress());
    }
    // A function for filling the password field with a string value from the xml config file
    public void writeTextPasswordField() throws Exception {
        writeText(passwordField,readFromFile("password"));
    }
    // A function for filling the password field again with a string value from the xml config file
    public void writeTextPassword_Authentication() throws Exception {
        writeText(password_Authentication, readFromFile("password"));
    }
    // A function for clicking the "agreement to terms" checkbox
    public void clickCheckBox_IAgree(){
        selected(checkBox_IAgree);
    }
    // A function for clicking the submit button
    public void clickSubmitButton(){
        click(submitButton);
    }
    // A function for asserting whether I reached the correct page, receiving an element and a text string and checking whether it exists
   /* public void check() throws Exception {
         checkElementStatus(logOutButton, "readFromFile");*/
        //String result= checkElementStatus(logOutButton, "readFromFile");
        //return result;
    }




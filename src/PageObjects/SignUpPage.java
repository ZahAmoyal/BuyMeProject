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
    By logOutButton = By.cssSelector("a[class=\"dropdown-item\"]");

    // לחיצה על כפתור רשמה
    public void clickSignUp() {
        click(signUpButton);
    }
// הזנת שדה שם פרטי
    public void writeTextFirstNameField() throws Exception {
        writeText(firstNameField,readFromFile("firstName"));
    }
    // הזנת שדה אימייל
    public void writeTextEmailField() throws Exception {
        writeText(emailField,readFromFile("email"));
    }
// הזנת שדה סיסמה
    public void writeTextPasswordField() throws Exception {
        writeText(passwordField,readFromFile("password"));
    }
// הזנת שדה סיסמה שוב
    public void writeTextPassword_Authentication() throws Exception {
        writeText(password_Authentication, readFromFile("password"));
    }
// לחיצה על צקבוקס אני מסכים
    public void clickCheckBox_IAgree(){
        selected(checkBox_IAgree);
    }
// לחיצה על כפתור Submit
    public void clickSubmitButton(){
        click(submitButton);
    }
//פונקצייה המוודא שהגעתי למסך הנכון בעזרת ASSERT והיא מקבלת אלמנט וכן טקסט ובודקת האם הוא קיים
    public Boolean check() throws Exception {
       return checkElementStatus(logOutButton,readFromFile("myAccount"));
    }

}

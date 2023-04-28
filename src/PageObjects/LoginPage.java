package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.cssSelector("[placeholder=\"מייל\"]");
    By passwordField = By.cssSelector("[placeholder=\"סיסמה\"]");
    By loginToBuyMeButton = By.cssSelector("[type=\"submit\"]");
    By errorTextLogin = By.cssSelector("li.parsley-required");
    By xButton = By.cssSelector("span[class=\"ember-view bm-icon sm\"]");

    //פונקצייה המקבלת אלמנט ובודקת אם הטקסט שלו שווה לערך של הטקסט מהxml
    public void assertErrorMessage() throws Exception {
        Assert.assertTrue((getText(errorTextLogin).equals(readFromFile("extramessage"))));
    }
//פונקצייה לסגירת פופאפ
    public void closePopUp(){
        click(xButton);
    }

// פונקצייה להזנת שדה אימייל על ידי קובץ הXML
    public void emailField() throws Exception {
        writeText(emailField, readFromFile("email"));
    }
    // פונקצייה להזנת שדה סיסמה על ידי קובץ הXML
    public void passwordField() throws Exception {
        writeText(passwordField, readFromFile("password"));
    }
    // פונקצייה ללחיצה על כפתור כניסה
    public void loginToBuyMe() {
        click(loginToBuyMeButton);
    }

}



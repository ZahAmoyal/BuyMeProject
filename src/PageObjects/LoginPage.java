package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    //constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    final By emailField = By.cssSelector("[placeholder=\"מייל\"]");
    final By passwordField = By.cssSelector("[placeholder=\"סיסמה\"]");
    final By loginToBuyMeButton = By.cssSelector("[type=\"submit\"]");
    private By errorTextLogin = By.cssSelector("li.parsley-required");
    final By xButton = By.cssSelector("span[class=\"ember-view bm-icon sm\"]");


    // A function for closing the popup window
    public void closePopUp() {
        click(xButton);
    }

    // A function for filling the email field with a string value from the xml config file
    public void emailField() throws Exception {
        writeText(emailField, readFromFile("email"));
    }

    // A function for filling the password field with a string value from the xml config file
    public void passwordField() throws Exception {
        writeText(passwordField, readFromFile("password"));
    }

    // A function for pressing the login button
    public void loginToBuyMe() {
        click(loginToBuyMeButton);
    }


    public String getAssertExpected() throws Exception {
        return readFromFile("extramessage");
    }

    public String getErrorTextLogin() {
        return getText(errorTextLogin);
    }
}



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


    // A function for closing the popup window
    public void closePopUp(){
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

     // A function for receiving an element and asserting whether it is equal to a string value from the xml config file
    public void assertErrorMessage() throws Exception {
        Assert.assertTrue((getText(errorTextLogin).equals(readFromFile("extramessage"))));
    }
}



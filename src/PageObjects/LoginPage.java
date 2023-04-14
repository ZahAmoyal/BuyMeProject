package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By registerButton = By.cssSelector("[class=\"text-link theme\"]");
    //By login_RegisterButton = By.cssSelector("[class=\\\"notSigned\\\"]");
    //By xButton = By.cssSelector("[id=\"times\"]");
    //By facebookButton =By.cssSelector("[class=\"social-btn facebook\"]");
   // By googleButton = By.cssSelector("[class=\"social-btn google\"]");
    By emailField = By.cssSelector("[placeholder=\"מייל\"]");
    By passwordField = By.cssSelector("[placeholder=\"סיסמה\"]");
    //By forgotPasswordLink = By.cssSelector("[class=\"bm-body-2 text-link theme db\"]");
    //By rememberMeCheckBox = By.cssSelector(".ember-view.bm-checkbox.checked [class=\"fill\"]");
    By loginToBuyMe = By.cssSelector("[type=\"submit\"]");


    public LoginPage click_RegisterButton() {
        click(registerButton);
        return this;
    }
    public LoginPage emailField(String email){
        writeText(emailField,email);
        return this;
    }
    public  LoginPage passwordField(String password){
        writeText(passwordField,password);
        return this;
    }

    public LoginPage loginToBuyMe(){
        click(loginToBuyMe);
        return this;
    }

}
/*
    public  LoginPage xButton(){
        click(xButton);
        return this;
    }
    public LoginPage facebookButton(){
        click(facebookButton);
        return this;
    }
    public LoginPage googleButton(){
        click(googleButton);
        return this;
    }
    public LoginPage forgotPasswordLink(){
        click(forgotPasswordLink);
        return this;
    }
    public LoginPage rememberMeCheckBox(){
        click(rememberMeCheckBox);
        return this;
    }

 */



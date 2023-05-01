package Flows;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class SignUpFlow {
    SignUpPage signUpPage;

    public SignUpFlow(WebDriver driver) {
        signUpPage = new SignUpPage(driver);
    }

    public void signUpBuyMeFlow() throws Exception {
        signUpPage.clickSignUp();
        signUpPage.writeTextFirstNameField();
        signUpPage.writeTextEmailField();
        signUpPage.writeTextPasswordField();
        signUpPage.writeTextPassword_Authentication();
        signUpPage.clickCheckBox_IAgree();
        signUpPage.clickSubmitButton();

    }
    public void checkSignUpFlow() throws Exception {
       signUpPage.check();
    }

}


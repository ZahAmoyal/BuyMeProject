package Flows;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class SignUpFlow {
    SignUpPage signUpPage;
    Boolean result;

    public SignUpFlow(WebDriver driver) {
        signUpPage = new SignUpPage(driver);
    }

    public boolean signUpBuyMeFlow() throws Exception {
        signUpPage.clickSignUp();
        signUpPage.writeTextFirstNameField();
        signUpPage.writeTextEmailField();
        signUpPage.writeTextPasswordField();
        signUpPage.writeTextPassword_Authentication();
        signUpPage.clickCheckBox_IAgree();
        signUpPage.clickSubmitButton();
        return signUpPage.check();
    }

}


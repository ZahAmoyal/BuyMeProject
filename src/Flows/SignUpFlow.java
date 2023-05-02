package Flows;

import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

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

    public void assertSignUpFlow() throws Exception {
        assertEquals(signUpPage.getLogOutButton(), signUpPage.getAssertExpected());
    }
}


package tests;

import helpers.constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        Assert.assertEquals(loginPage.verifyLoginSuccess(),true);
    }
    @Test
    public void loginWithIncorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        logIn("juanito", "juanito123");
        Assert.assertEquals(loginPage.verifyLoginIncorrect(), "Invalid credentials");
    }
    @Test
    public void forgotPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgotPasswordLink.click();
        loginPage.usernameElement.sendKeys("Admin");
        loginPage.submitButton.click();
        Assert.assertTrue(loginPage.resetPasswordTitle.getText().contains("Reset Password link sent successfully"));
    }
    @Test
    public void validatePasswordRequired(){
        LoginPage loginPage = new LoginPage(driver);
        logIn("Admin", "");
        Assert.assertTrue(loginPage.errorSpanFieldRequired.isDisplayed());
    }
    @Test
    public void validateUsernameRequired(){
        LoginPage loginPage = new LoginPage(driver);
        logIn("", "admin123");
        Assert.assertTrue(loginPage.errorSpanFieldRequired.isDisplayed());
    }
}

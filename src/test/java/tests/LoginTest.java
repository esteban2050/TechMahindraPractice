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
}

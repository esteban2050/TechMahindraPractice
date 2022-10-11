package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        logIn();
        Assert.assertEquals(loginPage.verifyLoginSuccess(),true);
    }


}

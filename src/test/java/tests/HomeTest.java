package tests;

import helpers.constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class HomeTest extends BaseTest{

    @Test
    public void ValidateAboutOption(){
        LoginPage loginPage = new LoginPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        loginPage.profileIcon.click();
        loginPage.selectOptionInOptionsProfileIcon("About").click();
        Assert.assertEquals(loginPage.companyName.getText(), "OrangeHRM");
    }
}

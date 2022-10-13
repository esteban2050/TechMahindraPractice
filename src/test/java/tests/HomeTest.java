package tests;

import helpers.constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseTest{

    @Test
    public void validateLogout(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginpage = new LoginPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        homePage.profileIcon.click();
        homePage.selectOptionInOptionsProfileIcon("Logout").click();
        Assert.assertTrue(loginpage.usernameElement.isDisplayed());
    }
    @Test
    public void ValidateAboutOption(){
        HomePage homePage = new HomePage(driver);
        logIn(constants.USER, constants.PASSWORD);
        homePage.profileIcon.click();
        homePage.selectOptionInOptionsProfileIcon("About").click();
        Assert.assertEquals(homePage.companyName.getText(), "OrangeHRM");
    }
    @Test
    public void ValidateSupportOption(){
        HomePage homePage = new HomePage(driver);
        logIn(constants.USER, constants.PASSWORD);
        homePage.profileIcon.click();
        homePage.selectOptionInOptionsProfileIcon("Support").click();
        Assert.assertTrue(homePage.supportText.getText().contains("ossuport@orangehrm.com"));
    }
}

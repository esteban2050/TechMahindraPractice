package tests;

import helpers.constants;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.PimPage;

import static helpers.creationProcess.*;

public class AdminTest extends LoginTest{

    private final User user = buildAdmin();
    @Test
    public void shouldCreateNewAdmin(){
        PimPage pimPage = new PimPage(driver);
        AdminPage adminPage = new AdminPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        SearchAddButton(pimPage,driver);
        fillBasicUserInformation(user, pimPage);
        pimPage.saveButton.click();
        pimPage.waitForElementStatus("visible", pimPage.imageProfile);
        adminPage.clickOnAdminSlide();
        adminPage.buttonAdd.click();
        adminPage.waitForElementStatus("visible", adminPage.selectCategories.get(0));
        adminPage.addNewUser(user);
        adminPage.waitForElementStatus("visible", adminPage.buttonAdd);
        adminPage.searchAdminUser(user);
        Assert.assertEquals(adminPage.resultEmployee.get(1).getText(),user.getUserName());
        Assert.assertEquals(adminPage.resultEmployee.get(3).getText(),user.getFirstName() +" "+ user.getLastName());
    }


}

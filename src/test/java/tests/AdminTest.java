package tests;

import helpers.constants;
import models.User;
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
        createUser(pimPage, user, driver);
        pimPage.waitForElementStatus("visible", pimPage.imageProfile);
        adminPage.clickOnAdminSlide();
        adminPage.buttonAdd.click();
        pimPage.waitForElementStatus("visible", adminPage.selectCategories.get(0));
    }


}

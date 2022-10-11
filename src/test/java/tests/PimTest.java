package tests;

import models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PimPage;

import java.util.Map;

public class PimTest extends BaseTest {

    private final User user = PimPage.buildUser();

    @Test(priority = 1)
    public void CreateNewUser() {
        PimPage pimPage = new PimPage(driver);
        logIn();
        if (!pimPage.addButton.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pimPage.addButton);
        }
        pimPage.addButton.click();
        pimPage.completeFormWithEmployeeInformationToCreate(user, pimPage);
        pimPage.saveButton.click();
        pimPage.searchEmployee(pimPage, user.getEmployeeId());
        Assert.assertEquals(user.getEmployeeId(), pimPage.employeeInformation.get(1).getText());
        Assert.assertEquals(user.getFirstName(), pimPage.employeeInformation.get(2).getText());
        Assert.assertEquals(user.getLastName(), pimPage.employeeInformation.get(3).getText());
    }

    @Test(priority = 2)
    public void editUser() {
        PimPage pimPage = new PimPage(driver);
        Map<String, String> importantValuesEdited;
        logIn();
        pimPage.searchEmployee(pimPage, user.getEmployeeId());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pimPage.editIcon);
        importantValuesEdited = pimPage.completeFormWithEditedInformation(pimPage);
        pimPage.searchEmployee(pimPage, user.getEmployeeId());
        Assert.assertEquals(importantValuesEdited.get("jobTitle"), pimPage.employeeInformation.get(4).getText());
        Assert.assertEquals(importantValuesEdited.get("employeeStatus"), pimPage.employeeInformation.get(5).getText());
        Assert.assertEquals(importantValuesEdited.get("subUnit"), pimPage.employeeInformation.get(6).getText());
    }

    @Test(priority = 3)
    public void DeleteUser() {
        PimPage pimPage = new PimPage(driver);
        logIn();
        pimPage.searchEmployee(pimPage, user.getEmployeeId());
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pimPage.deleteIcon.click();
        pimPage.waitForElementStatus("click",pimPage.deletedConfirmed);
        pimPage.deletedConfirmed.click();
        //pimPage.waitForElementStatus("notDisplayed",pimPage.firstElementOfResult);
        pimPage.searchEmployee(pimPage, user.getEmployeeId());
        try {
            Thread.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(pimPage.noRecordsFoundMessage.getText().equals("No Records Found"));
    }



}

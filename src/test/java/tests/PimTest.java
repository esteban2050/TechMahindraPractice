package tests;

import helpers.constants;
import models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PimPage;

import java.util.Map;

import static helpers.creationProcess.*;

public class PimTest extends BaseTest {

    private final User user = buildUser();

    @Test(priority = 1)
    public void shouldCreateNewUser() {
        PimPage pimPage = new PimPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        createUser(pimPage, user, driver);
        pimPage.searchEmployee(pimPage, user.getEmployeeId());
        pimPage.waitForElementStatus("visible", pimPage.firstElementOfResult);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pimPage.firstElementOfResult);
        Assert.assertEquals(user.getEmployeeId(), pimPage.employeeInformation.get(1).getText());
        Assert.assertEquals(user.getFirstName(), pimPage.employeeInformation.get(2).getText());
        Assert.assertEquals(user.getLastName(), pimPage.employeeInformation.get(3).getText());
    }

    @Test(priority = 2)
    public void shouldEditUser() {
        Map<String, String> importantValuesEdited;
        PimPage pimPage = new PimPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        createUser(pimPage, user, driver);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        pimPage.waitForElementStatus("visible", pimPage.imageProfile);
        pimPage.searchEmployee(pimPage, user.getEmployeeId());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pimPage.editIcon);
        pimPage.waitForElementStatus("visible", pimPage.firstElementOfResult);
        importantValuesEdited = pimPage.completeFormWithEditedInformation(pimPage);
        pimPage.searchEmployee(pimPage, user.getEmployeeId());
        Assert.assertEquals(importantValuesEdited.get("jobTitle"), pimPage.employeeInformation.get(4).getText());
        Assert.assertEquals(importantValuesEdited.get("employeeStatus"), pimPage.employeeInformation.get(5).getText());
        Assert.assertEquals(importantValuesEdited.get("subUnit"), pimPage.employeeInformation.get(6).getText());
    }

    @Test(priority = 3)
    public void shouldDeleteUser() {
        PimPage pimPage = new PimPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        createUser(pimPage, user, driver);
        pimPage.waitForElementStatus("visible", pimPage.imageProfile);
        deleteUser(pimPage, user, driver);
        pimPage.searchEmployee(pimPage, user.getEmployeeId());
        Assert.assertEquals(pimPage.noRecordsFoundMessage.getText(), "No Records Found");
    }
    @Test
    public void shouldValidateAddEmployeeButton(){
        PimPage pimPage = new PimPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        pimPage.buttonsHeader.get(2).click();
        Assert.assertTrue(pimPage.firstNameInput.isDisplayed());
    }
    @Test
    public void shouldValidateReportsButton(){
        PimPage pimPage = new PimPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        pimPage.buttonsHeader.get(4).click();
        Assert.assertTrue(pimPage.employeeReportTitle.isDisplayed());
    }
    //TODO: 'Add more validations in the dropdown of the configuration button'
    @Test
    public void shouldValidateOptionsConfiguration(){
        PimPage pimPage = new PimPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        pimPage.buttonsHeader.get(0).click();
        pimPage.optionsConfigurationButton.get(0).click();
        Assert.assertTrue(pimPage.optionalFieldsTitle.isDisplayed());
    }
    @Test
    public void shouldValidateErrorMessageEmployeeIdAlreadyExists(){
        PimPage pimPage = new PimPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        createUser(pimPage, user, driver);
        pimPage.waitForElementStatus("visible", pimPage.imageProfile);
        pimPage.buttonsHeader.get(2).click();
        pimPage.waitForElementStatus("visible", pimPage.employeeIdInput);
        pimPage.employeeIdInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        pimPage.employeeIdInput.sendKeys(user.getEmployeeId());
        pimPage.firstNameInput.click();
        Assert.assertTrue(pimPage.spanErrorMessage.isDisplayed());
        Assert.assertTrue(pimPage.spanErrorMessage.getText().contains("Employee Id already exists"));
    }
    @Test
    public void shouldValidateErrorMessageUsernameAlreadyExists(){
        PimPage pimPage = new PimPage(driver);
        logIn(constants.USER, constants.PASSWORD);
        createUser(pimPage, user, driver);
        pimPage.waitForElementStatus("visible", pimPage.imageProfile);
        pimPage.buttonsHeader.get(2).click();
        pimPage.waitForElementStatus("visible", pimPage.createDetailsCheckbox);
        fillCreateLoginDetails(user, pimPage);
        Assert.assertTrue(pimPage.spanErrorMessage.isDisplayed());
    }
}
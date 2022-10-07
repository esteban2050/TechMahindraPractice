package tests;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.PimPage;

public class PimTest extends BaseTest {

    private final PimPage pimPage = new PimPage(driver);
    private final String firstName = "Name EmployeeExample";
    private final String lastName = "lastname EmployeeExample";
    private final String employeeId = "103765598";
    private String jobTitle;
    private String subUnit;
    private String employeeStatus;


    @Test
    public void CreateNewUser(){
        logIn();
        if (!PimPage.addButton.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PimPage.addButton);
        }
        PimPage.addButton.click();
        completeFormWithEmployeeInformationToCreate();
        PimPage.saveButton.click();
        searchEmployee(employeeId);

        /*Assertions.assertEquals(firstName, PimPage.employeeInformation.get(2).getText());
        Assertions.assertEquals(lastName, PimPage.employeeInformation.get(3).getText());
        Assertions.assertEquals(employeeId, PimPage.employeeInformation.get(1).getText());
    */
    }

//
//    @Test
//    public void editUser()  {
//        logIn();
//        searchEmployee(employeeId);
//        PimPage.editIcon.click();
//        completeFormWithEditedInformation();
//        searchEmployee(employeeId);
//        /*Assertions.assertEquals(jobTitle, PimPage.employeeInformation.get(4).getText());
//        Assertions.assertEquals(employeeStatus, PimPage.employeeInformation.get(5).getText());
//        Assertions.assertEquals(subUnit, PimPage.employeeInformation.get(6).getText());
//    */
//    }
//
//
//    @Test
//    public void DeleteUser() {
//        logIn();
//        searchEmployee(employeeId);
//        PimPage.deleteIcon.click();
//        PimPage.deletedConfirmed.click();
//        searchEmployee(employeeId);
//        //Assertions.assertTrue(PimPage.noRecordsFoundMessage.isDisplayed());
//    }
//
    public void completeFormWithEmployeeInformationToCreate() {
        PimPage.firstNameInput.sendKeys(firstName);
        PimPage.lastNameInput.sendKeys(lastName);
        PimPage.employeeIdInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        PimPage.employeeIdInput.sendKeys(employeeId);
        PimPage.createDetailsCheckbox.click();
        PimPage.usernameInput.sendKeys("juan.lg");
        PimPage.password.get(0).sendKeys("Juan.1037");
        PimPage.password.get(1).sendKeys("Juan.1037");
    }
//
//    public void completeFormWithEditedInformation()  {
//        PimPage.categories.get(5).click();
//        PimPage.joinedDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
//        PimPage.joinedDate.sendKeys("2021-08-08", Keys.RETURN);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        PimPage.dropdownLists.get(0).click(); //Job Title
//        pimPage.selectOptionInEditParameters("2").click();
//        jobTitle = PimPage.dropdownLists.get(0).getText();
//        PimPage.dropdownLists.get(1).click();//Job Category
//        ((JavascriptExecutor) driver).
//                executeScript("arguments[0].scrollIntoView(true);", pimPage.selectOptionInEditParameters("6"));
//        pimPage.selectOptionInEditParameters("6").click();
//        PimPage.dropdownLists.get(2).click();//Sub Unit
//        pimPage.selectOptionInEditParameters("2").click();
//        subUnit = PimPage.dropdownLists.get(2).getText();
//        PimPage.dropdownLists.get(3).click();//Location
//        pimPage.selectOptionInEditParameters("2").click();
//        PimPage.dropdownLists.get(4).click();//Employment Status
//        pimPage.selectOptionInEditParameters("2").click();
//        employeeStatus = PimPage.dropdownLists.get(4).getText();
//        PimPage.saveButton.click();
//    }

    public void searchEmployee(String employeeIdentification) {
        PimPage.xpathPim.click();
        PimPage.employeeId.sendKeys(employeeIdentification);
        PimPage.saveButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

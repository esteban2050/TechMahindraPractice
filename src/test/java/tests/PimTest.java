package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.PimPage;
import resources.helpers.openBrowser;

public class PimTest extends openBrowser {

    private final PimPage pimPage;

    public PimTest() {
        logIn();
        pimPage = new PimPage(driver);
    }

    @Test
    public void CreateNewUser() {
        if(!pimPage.addButton.isDisplayed()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pimPage.addButton);
        }
        pimPage.addButton.click();
        pimPage.firstNameInput.sendKeys("Name EmployeeExample");
        pimPage.lastNameInput.sendKeys("lastname EmployeeExample");
        pimPage.employeeIdInput.getText();
        pimPage.employeeIdInput.clear();
        pimPage.employeeIdInput.sendKeys("103765598");
        pimPage.createDetailscheckbox.click();

    }
}

package helpers;

import models.User;
import models.UserBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.PimPage;

public class creationProcess {

    public static User buildUser(){
        User user = UserBuilder.instanceUserObject()
                .withFirstName("juan Esteban")
                //.withEmployeeId("10376559934")
                .withLastName("Lopez Giraldo")
                .withUserName("juan.lg" + (int)(Math.random() * 10))
                .withPassword("Admin.1234")
                .build();
        return user;
    }
    public static void createUser(PimPage pimPage, User user, WebDriver driver){
        if (!pimPage.addButton.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pimPage.addButton);
        }
        pimPage.addButton.click();
        completeFormWithEmployeeInformationToCreate(user, pimPage);
        pimPage.saveButton.click();
    }

    public static void completeFormWithEmployeeInformationToCreate(User user, PimPage pimPage) {
        user.setEmployeeId(pimPage.employeeIdInput.getAttribute("value"));
        pimPage.firstNameInput.sendKeys(user.getFirstName());
        pimPage.lastNameInput.sendKeys(user.getLastName());
        /*pimPage.employeeIdInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        pimPage.employeeIdInput.sendKeys(user.getEmployeeId());*/
        pimPage.createDetailsCheckbox.click();
        pimPage.usernameInput.sendKeys(user.getUserName());
        pimPage.password.get(0).sendKeys(user.getPassword());
        pimPage.password.get(1).sendKeys(user.getPassword());
    }
}

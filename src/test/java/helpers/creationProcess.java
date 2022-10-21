package helpers;

import models.User;
import models.UserBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.PimPage;

public class creationProcess{

    public static User buildUser(){
        User user = UserBuilder.instanceUserObject()
                .withFirstName("juan Esteban")
                //.withEmployeeId("10376559934")
                .withLastName("Lopez Giraldo")
                .withUserName("juan.lg" + (int)(Math.random() * 100))
                .withPassword("Admin.1234")
                .build();
        return user;
    }

    public static User buildAdmin(){
        User user = UserBuilder.instanceUserObject()
                .withFirstName("julano")
                .withLastName("whatever")
                .withUserName("julano.lg" + (int)(Math.random() * 500))
                .withPassword("Admin.1234")
                .build();
        return user;
    }
    public static User buildUserDataIncorrect(){
        User user = UserBuilder.instanceUserObject()
                .withFirstName("")
                .withLastName("whatever")
                .withUserName("ju")
                .withPassword("Admin.1234")
                .build();
        return user;
    }
    public static void SearchAddButton(PimPage pimPage,WebDriver driver){
        if (!pimPage.addButton.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pimPage.addButton);
        }
        pimPage.addButton.click();
    }
    public static void createUser(PimPage pimPage, User user, WebDriver driver){
        SearchAddButton(pimPage,driver);
        fillBasicUserInformation(user, pimPage);
        fillCreateLoginDetails(user, pimPage);
        pimPage.saveButton.click();
    }
    public static void fillBasicUserInformation(User user, PimPage pimPage) {
        user.setEmployeeId(pimPage.employeeIdInput.getAttribute("value"));
        pimPage.firstNameInput.sendKeys(user.getFirstName());
        pimPage.lastNameInput.sendKeys(user.getLastName());
        /*pimPage.employeeIdInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        pimPage.employeeIdInput.sendKeys(user.getEmployeeId());*/
    }
    public static void fillCreateLoginDetails(User user, PimPage pimPage){
        pimPage.createDetailsCheckbox.click();
        pimPage.usernameInput.sendKeys(user.getUserName());
        pimPage.password.get(0).sendKeys(user.getPassword());
        pimPage.password.get(1).sendKeys(user.getPassword());
    }
    public static void askForElement(WebElement element){
        boolean staleElement = true;
        while(staleElement){
            try{
                element.click();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
    }

    public static void deleteUser(PimPage pimPage, User user, WebDriver driver){
        pimPage.searchEmployee(pimPage, user.getEmployeeId());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pimPage.deleteIcon);
        askForElement(pimPage.deleteIcon);
        pimPage.waitForElementStatus("visible", pimPage.deletedConfirmed);
        askForElement(pimPage.deletedConfirmed);
        pimPage.waitForElementStatus("visible", pimPage.headersResultTable);
    }
}

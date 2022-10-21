package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static helpers.creationProcess.askForElement;

public class AdminPage extends BasePage{

    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement xpathAdmin;
    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement buttonAdd;
    @FindBy(css = "div.oxd-select-text--after")
    public List<WebElement> selectCategories;
    @FindBy(css = "div.oxd-select-option")
    public List<WebElement> selectOptions;

    //Add user tab
    @FindBy(css = "div[class^='oxd-autocomplete-text-input'] > input")
    public WebElement employeeName;
    @FindBy(css = "div[class$='oxd-input-field-bottom-space'] > div>input")
    public WebElement username;
    @FindBy(css = "span[class$='oxd-input-group__message']")
    public WebElement errorSpanUserName;
    @FindBy(css = "button[type='submit']")
    public WebElement saveButton;
    @FindBy(css = "input[type='password']")
    public List<WebElement> passwords;
    @FindBy(css = "div[role='listbox']>div:nth-child(1)>span")
    public WebElement resultEmployeeName;

    //Result search
    @FindBy(css = "div[class='oxd-table-cell oxd-padding-cell']")
    public List<WebElement> resultEmployee;
    @FindBy(css = "div[class='oxd-loading-spinner']")
    public WebElement loadingSpinner;
    @FindBy(css = "button[class='oxd-icon-button oxd-table-cell-action-space']:nth-child(1)")
    public WebElement deleteIcon;
    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin")
    public WebElement deletedConfirmed;
    @FindBy(css = "div[class$='orangehrm-vertical-padding']>span")
    public WebElement resultMessage;

    public AdminPage(WebDriver driver){
        super(driver);
    }

    public void selectRole(){
        selectCategories.get(0).click();
        selectOptions.get(1).click();
    }

    public void selectStatus(){
        selectCategories.get(1).click();
        selectOptions.get(1).click();
    }
    public void clickOnAdminSide(){
        xpathAdmin.click();
    }

    //TODO: 'Debo validar este metodo por que al escribir el nombre de la persona, debe ser clickeado el nombre, mas no escrito'
    public void addNewUser(User user){
        selectRole();
        employeeName.sendKeys(user.getFirstName());
        waitForElementStatus("visible", resultEmployeeName);
        resultEmployeeName.click();
        selectStatus();
        username.click();
        username.sendKeys(user.getUserName());
        passwords.get(0).sendKeys(user.getPassword());
        passwords.get(1).sendKeys(user.getPassword());
        waitForElementStatus("noVisible", errorSpanUserName);
        saveButton.click();
    }

    public void searchAdminUser(User user) {
        clickOnAdminSide();
        username.sendKeys(user.getUserName());
        saveButton.click();
        waitForElementStatus("visible",loadingSpinner);
        waitForElementStatus("noVisible",loadingSpinner);

    }
    public void waitForElementStatus(String status, WebElement element){
        switch (status){
            case "click":
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            case "visible":
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case "noVisible":
                wait.until(ExpectedConditions.invisibilityOf(element));
                break;
        }
    }
    public void createNewAdmin(User user){
        buttonAdd.click();
        waitForElementStatus("visible", selectCategories.get(0));
        addNewUser(user);
        waitForElementStatus("visible", buttonAdd);
    }

    public void deleteAdmin(){
        deleteIcon.click();
        waitForElementStatus("visible", deletedConfirmed);
        askForElement(deletedConfirmed);
        waitForElementStatus("visible",loadingSpinner);
        waitForElementStatus("noVisible",loadingSpinner);
    }

}

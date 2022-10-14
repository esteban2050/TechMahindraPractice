package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static helpers.creationProcess.askForElement;

public class PimPage extends BasePage{

    @FindBy(xpath = "//span[text()='PIM']")
    public WebElement xpathPim;
    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addButton;
    @FindBy(css = "input[name='firstName']")
    public WebElement  firstNameInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    public WebElement  employeeIdInput;
    @FindBy(css = "input[name='lastName']")
    public WebElement  lastNameInput;
    @FindBy(css = "span[class='oxd-switch-input oxd-switch-input--active --label-right']")
    public WebElement  createDetailsCheckbox;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
    public WebElement  usernameInput;
    @FindBy(css = "input[type='password']")
    public List<WebElement> password;
    @FindBy(css = "button[type ='submit']")
    public WebElement saveButton;

    //Employee Information #app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div.oxd-table-body > div:nth-child(1) > div > div:nth-child(9) > div > button:nth-child(1)
    @FindBy(css = "div:nth-child(2) > input")
    public WebElement employeeId;

    //Information searched
    @FindBy(css = "div[class='oxd-table-cell oxd-padding-cell']")
    public List<WebElement> employeeInformation;
    @FindBy(css = "button>i[class='oxd-icon bi-trash']")
    public WebElement deleteIcon;
    @FindBy(css = "div[class='oxd-table-cell oxd-padding-cell']:nth-child(9)>div>button:nth-child(2)")
    public WebElement editIcon;
    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin")
    public WebElement deletedConfirmed;
    @FindBy(css = "span[class='oxd-text oxd-text--span']")
    public WebElement noRecordsFoundMessage;
    @FindBy(xpath = "//div[@class='oxd-table orangehrm-employee-list'][1]/div[2]/div[1]")
    public WebElement firstElementOfResult;

    @FindBy(css = "div[class='oxd-table-row oxd-table-row--with-border']")
    public WebElement headersResultTable;

    //Pim edit information
    @FindBy(css = "div[class='orangehrm-tabs-wrapper']")
    public List<WebElement> categories;
    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div:nth-child(1) > form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > div > div > input")
    public WebElement joinedDate;
    @FindBy(css = "div[class='oxd-select-text oxd-select-text--active']")
    public List<WebElement> dropdownLists;
    @FindBy(css = "div.orangehrm-edit-employee-image>img")
    public WebElement imageProfile;

    //Others
    @FindBy(css = "div[class$='oxd-toast-content--success']")
    public WebElement successCreationAlert;
    @FindBy(css = "div>h5")
    public WebElement employeeReportTitle;
    @FindBy(css = "div[class='orangehrm-card-container']>p")
    public WebElement optionalFieldsTitle;
    @FindBy(css = "ul>li[class^='oxd-topbar-body-nav-tab']")
    public List<WebElement> buttonsHeader;
    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space']>span")
    public WebElement spanErrorMessage;
    @FindBy(css = "ul[class='oxd-dropdown-menu']>li")
    public List<WebElement> optionsConfigurationButton;
    
    public PimPage(WebDriver driver){
        super(driver);
    }

    public WebElement selectOptionInEditParameters(String parameter){
        return driver.findElement(
                By.xpath("//div[@role='listbox']//div["+ parameter +"]"));
    }

    public Map<String, String> completeFormWithEditedInformation(PimPage pimPage)  {
        Map<String, String> importantValues = new HashMap<>();
        askForElement(pimPage.editIcon);
        pimPage.categories.get(5).click();
        wait.until(ExpectedConditions.visibilityOf(pimPage.joinedDate));
        fillField("JobTitle",pimPage);
        importantValues.put("jobTitle",pimPage.dropdownLists.get(0).getText());
        fillField("JobCategory",pimPage);
        fillField("SubUnit",pimPage);
        importantValues.put("subUnit", pimPage.dropdownLists.get(2).getText());
        fillField("Location",pimPage);
        fillField("EmploymentStatus",pimPage);
        importantValues.put("employeeStatus", pimPage.dropdownLists.get(4).getText());
        pimPage.saveButton.click();
        return importantValues;
    }

    public void fillField(String field, PimPage pimPage){
        switch (field) {
            case "Date" -> {
                pimPage.joinedDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
                pimPage.joinedDate.sendKeys("2021-08-08", Keys.RETURN);
            }
            case "JobTitle" -> {
                pimPage.dropdownLists.get(0).click();
                pimPage.selectOptionInEditParameters("2").click();
            }
            case "JobCategory" -> {
                pimPage.dropdownLists.get(1).click();//Job Category
                pimPage.selectOptionInEditParameters("2").click();
            }
            case "SubUnit" -> {
                pimPage.dropdownLists.get(2).click();//Sub Unit
                pimPage.selectOptionInEditParameters("2").click();
            }
            case "Location" -> {
                pimPage.dropdownLists.get(3).click();//Location
                pimPage.selectOptionInEditParameters("2").click();
            }
            case "EmploymentStatus" -> {
                pimPage.dropdownLists.get(4).click();//Employment Status
                pimPage.selectOptionInEditParameters("2").click();
            }
        }
    }

    public void searchEmployee(PimPage pimPage, String employeeIdentification) {
        wait.until(ExpectedConditions.visibilityOf(pimPage.xpathPim));
        pimPage.xpathPim.click();
        pimPage.employeeId.sendKeys(employeeIdentification);
        wait.until(ExpectedConditions.visibilityOf(pimPage.saveButton));
        pimPage.saveButton.click();
    }

    public void waitForElementStatus(String status, WebElement element){
        switch (status){
            case "click":
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            case "visible":
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case "notDisplayed":
                wait.until(ExpectedConditions.invisibilityOf(element));
                break;
        }
    }
}
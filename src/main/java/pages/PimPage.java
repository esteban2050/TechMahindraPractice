package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class PimPage{
    WebDriver driver;

    public PimPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='PIM']")
    public static WebElement xpathPim;
    @FindBy(xpath = "//button[text()=' Add ']")
    public static WebElement addButton;
    @FindBy(css = "input[name='firstName']")
    public static WebElement  firstNameInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    public static WebElement  employeeIdInput;
    @FindBy(css = "input[name='lastName']")
    public static WebElement  lastNameInput;
    @FindBy(css = "span[class='oxd-switch-input oxd-switch-input--active --label-right']")
    public static WebElement  createDetailsCheckbox;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
    public static WebElement  usernameInput;
    @FindBy(css = "input[type='password']")
    public static List<WebElement> password;
    @FindBy(css = "button[type ='submit']")
    public static WebElement saveButton;

    //Employee Information #app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div.oxd-table-body > div:nth-child(1) > div > div:nth-child(9) > div > button:nth-child(1)
    @FindBy(css = "div:nth-child(2) > input")
    public static WebElement employeeId;

    //Information searched
    @FindBy(css = "div[class='oxd-table-cell oxd-padding-cell']")
    public static List<WebElement> employeeInformation;
    @FindBy(css = "button>i[class='oxd-icon bi-trash']")
    public static WebElement deleteIcon;
    @FindBy(css = "button>i[class='oxd-icon bi-pencil-fill']")
    public static WebElement editIcon;
    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin")
    public static WebElement deletedConfirmed;
    @FindBy(css = "span[class='oxd-text oxd-text--span']")
    public static WebElement noRecordsFoundMessage;

    //Pim edit information
    @FindBy(css = "div[class='orangehrm-tabs-wrapper']")
    public static List<WebElement> categories;
    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div:nth-child(1) > form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > div > div > input")
    public static WebElement joinedDate;
    @FindBy(css = "div[class='oxd-select-text oxd-select-text--active']")
    public static List<WebElement> dropdownLists;
    @FindBy(css = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]")
    public static WebElement optionJobTitle;
    public WebElement selectOptionInEditParameters(String parameter){
        return driver.findElement(
                By.xpath("//div[@role='listbox']//div["+ parameter +"]"));
    }

}

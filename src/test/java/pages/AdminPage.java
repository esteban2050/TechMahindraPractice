package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminPage extends BasePage{

    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement xpathAdmin;
    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement buttonAdd;
    @FindBy(css = "div.oxd-select-text--after")
    public List<WebElement> selectCategories;
    @FindBy(css = "div.oxd-select-option")
    public List<WebElement> selectOptions;
    @FindBy(xpath = "//span[text()='Enabled']")
    public WebElement enabledOption;
    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement adminOption;

    //Add user tab
    @FindBy(css = "div[class='oxd-select-text oxd-select-text--active']")
    public List<WebElement> dropDownLists;
    @FindBy(css = "div[class^='oxd-autocomplete-text-input'] > input")
    public WebElement employeeName;
    @FindBy(css = "div[class$='oxd-input-field-bottom-space'] > div>input")
    public WebElement username;
    @FindBy(css = "button[type='submit']")
    public WebElement saveButton;
    @FindBy(css = "input[type='password']")
    public List<WebElement> passwords;

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
    public void clickOnAdminSlide(){
        xpathAdmin.click();
    }

    //TODO: 'Debo validar este metodo por que al escribir el nombre de la persona, debe ser clickeado el nombre, mas no escrito'
    public void addNewUser(User user){
        selectRole();
        employeeName.sendKeys(user.getFirstName());
        selectStatus();
        username.sendKeys(user.getUserName());
        passwords.get(0).sendKeys(user.getPassword());
        passwords.get(1).sendKeys(user.getPassword());
        saveButton.click();
    }


}

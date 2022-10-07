package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminPage extends BasePage{

    @FindBy(xpath = "//span[text()='Admin']")
    public static WebElement xpathAdmin;
    @FindBy(xpath = "//button[text()=' Add ']")
    public static WebElement buttonAdd;
    @FindBy(css = "div.oxd-select-text--after")
    public static List<WebElement> selectCategories;
    @FindBy(css = "div.oxd-select-option")
    public static List<WebElement> selectOptions;
    @FindBy(xpath = "//span[text()='Enabled']")
    public static WebElement enabledOption;
    @FindBy(xpath = "//span[text()='Admin']")
    public static WebElement adminOption;

    //Add user tab
    @FindBy(css = "div[class=\"oxd-select-text oxd-select-text--active\"]")
    public static List<WebElement> dropDownLists;
    @FindBy(css = "div[class=\"oxd-autocomplete-text-input oxd-autocomplete-text-input--active\"] > input")
    public static WebElement employeeName;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
    public static WebElement username;
    @FindBy(css = "input[type=\"password\"]")
    public static List<WebElement> passwords;

    public AdminPage(WebDriver driver){
        super(driver);
    }

    public static void selectRole(){
        selectCategories.get(0).click();
        selectOptions.get(1).click();
    }

    public static void selectStatus(){
        selectCategories.get(1).click();
        selectOptions.get(1).click();
    }
    public static void clickOnAdminSlide(){
        xpathAdmin.click();
    }

}

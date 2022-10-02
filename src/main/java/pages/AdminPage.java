package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {

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

    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver, this);
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

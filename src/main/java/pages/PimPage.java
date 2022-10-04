package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PimPage{

    public PimPage(WebDriver driver){
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
    @FindBy(css = "input[type='checkbox']")
    public static WebElement  createDetailscheckbox;

}

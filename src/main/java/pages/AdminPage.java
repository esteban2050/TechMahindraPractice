package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    private WebDriver driver;

    @FindBy(how = How.NAME, using = "username")
    private WebElement usernameElement;
    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordElement;
    @FindBy(how = How.CSS, using = "button.oxd-button")
    private WebElement loginButtonElement;

    @FindBy(how = How.CSS, using = "span.oxd-userdropdown-tab")
    private WebElement spanLoginElement;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeUsername(String username){
        usernameElement.sendKeys(username);
    }

    public void typePassword(String password){
        passwordElement.sendKeys(password);
    }

    public void clickOnLogin(){
        loginButtonElement.click();
    }

    public Boolean verifyLoginSuccess(){
        return spanLoginElement.isDisplayed();
    }
}

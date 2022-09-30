package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement usernameElement;
    @FindBy(name = "password")
    private WebElement passwordElement;
    @FindBy(css = "button.oxd-button")
    private WebElement loginButtonElement;

    @FindBy(css = "span.oxd-userdropdown-tab")
    private WebElement spanLoginElement;

    public void loginToThePage(String username, String password){
        typeInField(usernameElement, username);
        typeInField(passwordElement, password);
        clickOnLogin();
    }
    public void typeInField(WebElement webElement, String value){
        webElement.sendKeys(value);
    }

    public void clickOnLogin(){
        loginButtonElement.click();
    }

    public Boolean verifyLoginSuccess(){
        return spanLoginElement.isDisplayed();
    }
}

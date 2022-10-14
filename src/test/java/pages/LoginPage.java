package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(name = "username")
    public WebElement usernameElement;
    @FindBy(name = "password")
    public WebElement passwordElement;
    @FindBy(css = "button.oxd-button")
    public WebElement loginButtonElement;
    @FindBy(css = "span.oxd-userdropdown-tab")
    public WebElement spanLoginElement;
    @FindBy(css = "div[class^='oxd-alert-content']>p")
    public WebElement errorAlert;
    @FindBy(css = "div[class='orangehrm-login-forgot']>p")
    public WebElement forgotPasswordLink;
    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;
    @FindBy(css = "h6[class$='orangehrm-forgot-password-title']")
    public WebElement resetPasswordTitle;
    @FindBy(css = "div[class='oxd-form-row']>div>span")
    public WebElement errorSpanFieldRequired;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToThePage(String username, String password) {
        typeInField(usernameElement, username);
        typeInField(passwordElement, password);
        clickOnLogin();
    }

    public void typeInField(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    public void clickOnLogin() {
        loginButtonElement.click();
    }

    public Boolean verifyLoginSuccess() {
        return spanLoginElement.isDisplayed();
    }
    public String verifyLoginIncorrect() {
        return errorAlert.getText();
    }
}

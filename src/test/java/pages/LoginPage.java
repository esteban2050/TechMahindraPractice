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
}

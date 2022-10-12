package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(name = "username")
    public WebElement usernameElement;
    @FindBy(name = "password")
    WebElement passwordElement;
    @FindBy(css = "button.oxd-button")
    WebElement loginButtonElement;
    @FindBy(css = "span.oxd-userdropdown-tab")
    WebElement spanLoginElement;
    @FindBy(css = "div[class^='oxd-alert-content']>p")
    WebElement errorAlert;
    @FindBy(css = "ul>li[class='--active oxd-userdropdown']")
    public WebElement profileIcon;

    public WebElement selectOptionInOptionsProfileIcon(String parameter){
        return driver.findElement(
                By.cssSelector("//a[text()='"+ parameter + "']"));
    }

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

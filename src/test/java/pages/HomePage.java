package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = "ul>li[class='oxd-userdropdown']")
    public WebElement profileIcon;
    @FindBy(css = "div[class='oxd-grid-2 orangehrm-about']>div:nth-child(2)")
    public WebElement companyName;
    @FindBy(css = "div[class$='oxd-grid-item--gutters']>p[class$='orangehrm-support-text']")
    public WebElement supportText;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement selectOptionInOptionsProfileIcon(String parameter){
        return driver.findElement(
                By.xpath("//a[text()='"+ parameter + "']"));
    }
}

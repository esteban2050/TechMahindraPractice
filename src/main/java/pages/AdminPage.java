package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {

    @FindBy(xpath = "//span[text()='Admin']")
    private static WebElement xpathAdmin;

    @FindBy(xpath = "//button[text()=' Add ']")
    private static WebElement buttonAdd;

    @FindBy(xpath = "//div[@class=\"oxd-form-row\"]/div/div/div/div/div[@class=\"oxd-select-wrapper\"]")
    private static WebElement userRole;

    public static void clickOnAdminSlide(){
        xpathAdmin.click();
    }

    /*//*[@id="app"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div
//div[@class="oxd-form-row"]/div/div/div/div/div[@class="oxd-select-wrapper"]


    div[class="oxd-form-row"]>div[@class="oxd-select-wrapper"]

//div[@class="oxd-select-text--after"]/i[1]
//div[@class="oxd-select-text--after"]/i[1]''*/

}

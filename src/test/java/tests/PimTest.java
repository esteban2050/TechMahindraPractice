package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.PimPage;
import resources.helpers.openBrowser;

public class PimTest extends openBrowser {

    private final PimPage pimPage;

    public PimTest() {
        logIn();
        pimPage = new PimPage(driver);
    }

    @Test
    public void CreateNewUser() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pimPage.addButton);
        pimPage.addButton.click();

    }
}

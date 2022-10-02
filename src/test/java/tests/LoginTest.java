package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import resources.helpers.openBrowser;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends openBrowser {

    @Test
    public void login() {
        logIn();
        assertThat(loginPage.verifyLoginSuccess()).isEqualTo(true);
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}

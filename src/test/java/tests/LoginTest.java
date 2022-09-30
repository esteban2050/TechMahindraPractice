package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {
    private static final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public static WebDriver driver;

    @BeforeAll
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
    }

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToThePage("Admin", "admin123");
        assertThat(loginPage.verifyLoginSuccess()).isEqualTo(true);
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}

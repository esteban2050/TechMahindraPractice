package tests;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AdminPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AdminTest {

    private WebDriver driver;
    private static final String url= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
    }

    @Test
    public void login(){
        AdminPage  adminPage= new AdminPage(driver);
        adminPage.typeUsername("Admin");
        adminPage.typePassword("admin123");
        adminPage.clickOnLogin();
        assertThat(adminPage.verifyLoginSuccess()).isEqualTo(true);
    }


}

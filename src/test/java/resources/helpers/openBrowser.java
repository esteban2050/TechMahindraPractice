package resources.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

public class openBrowser {

    public static WebDriver driver;
    private static final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public LoginPage loginPage = new LoginPage(driver);

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
    }

    public void logIn(){
        this.loginPage.loginToThePage("Admin", "admin123");
    }
}

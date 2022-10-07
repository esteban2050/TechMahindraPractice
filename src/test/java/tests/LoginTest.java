package tests;

import org.testng.annotations.Test;

//import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        logIn();
        //assertThat(loginPage.verifyLoginSuccess()).isEqualTo(true);
    }


}

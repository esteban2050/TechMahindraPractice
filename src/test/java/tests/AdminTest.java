package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AdminPage;

public class AdminTest extends LoginTest{

    @BeforeEach
    public void standInTheSlide(){
        AdminPage.clickOnAdminSlide();
    }

    @Test
    public void  createNewAdmin(){

    }

}

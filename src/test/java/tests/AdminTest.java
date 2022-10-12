package tests;

import org.testng.annotations.Test;
import pages.AdminPage;

public class AdminTest extends LoginTest{


    @Test
    public void CreateNewAdmin(){
        AdminPage.clickOnAdminSlide();
    }


}

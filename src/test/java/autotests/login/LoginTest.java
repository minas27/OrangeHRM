package autotests.login;

import autotests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void checkLoginWithAdminUser() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.isOnLoginPage());
        loginPage.fillInUsername("Admin");
        loginPage.fillInPassword("admin123");
        loginPage.clickOnLogin();
    }
}

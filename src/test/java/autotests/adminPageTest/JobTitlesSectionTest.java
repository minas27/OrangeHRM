package autotests.adminPageTest;

import autotests.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static core.ActionsHelper.*;

public class JobTitlesSectionTest extends BaseTest {
    @Test
    public void checkJobTitleAvailabilityFromTheList(){
        Assert.assertTrue(loginPage.isOnLoginPage());
        loginPage.fillInUsername("Admin");
        loginPage.fillInPassword("admin123");
        loginPage.clickOnLogin();
        leftMenuComponent
                .goToAdminPage(getDriver())
                .openJobTitles(getDriver());
        scrollDown(getDriver(), 300);
        Assert.assertTrue(jobTitlesSection.isJobDisplayed("Account Assistant"));
        Assert.assertFalse(jobTitlesSection.isJobDisplayed("Account Assistant123"));
    }
}

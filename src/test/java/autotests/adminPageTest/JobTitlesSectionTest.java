package autotests.adminPageTest;

import autotests.BaseTest;

import core.ActionsHelper;
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

    @Test
    public void checkJobAddingFunctionality(){
        Assert.assertTrue(loginPage.isOnLoginPage());
        loginPage.fillInUsername("Admin");
        loginPage.fillInPassword("admin123");
        loginPage.clickOnLogin();
        leftMenuComponent
                .goToAdminPage(getDriver())
                .openJobTitles(getDriver())
                .clickOnAddBtn()
                .enterJobTitle("For testing")
                .enterJobDescription("test describe")
                .enterNotes("test note");
        scrollDown(getDriver(), 350);
        jobTitlesSection.clickOnSave();
        Assert.assertTrue(jobTitlesSection.isJobDisplayed("For testing"));
    }
}

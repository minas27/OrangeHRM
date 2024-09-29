package autotests.adminPageTest;

import autotests.BaseTest;
import business.objects.UserData;
import core.ActionsHelper;
import core.JacksonHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static core.ActionsHelper.scrollDown;
import static core.ActionsHelper.scrollIntoView;
import static core.WaitHelper.pause;

public class AdminPageTest extends BaseTest {
    @Test
    public void testUserSearchFunctionalityInAdminPage() {
        Assert.assertTrue(loginPage.isOnLoginPage());
        loginPage.fillInUsername("Admin");
        loginPage.fillInPassword("admin123");
        loginPage.clickOnLogin();
        leftMenuComponent
                .goToAdminPage(getDriver())
                .openUsersSection(getDriver())
                .searchEnterUsername("Admin")
                .clickOnSearch();
        scrollDown(getDriver(), 300);
        Assert.assertTrue(userManagementSection.isSearchResultDisplayed("Admin"));
    }

    @Test
    public void testUserAddAndDeletionFunctionality() throws InterruptedException, IOException {
        UserData user = JacksonHelper.deserializeJson("userData.json", UserData.class);
        loginPage.fillInUsername("Admin");
        loginPage.fillInPassword("admin123");
        loginPage.clickOnLogin();
        leftMenuComponent
                .goToAdminPage(getDriver())
                .openUsersSection(getDriver())
                .searchEnterUsername(user.getUsername())
                .clickOnSearch();
        scrollDown(getDriver(), 300);
        Assert.assertFalse(userManagementSection.isSearchResultDisplayed(user.getUsername()));
        scrollDown(getDriver(), -300);
        userManagementSection.createNewUser(user);
        scrollDown(getDriver(), 900);
        Assert.assertTrue(userManagementSection.isSearchResultDisplayed(user.getUsername()));
        userManagementSection
                .searchEnterUsername(user.getUsername())
                .clickOnSearch();
        pause(2);
        userManagementSection.deleteUserByUsername(user.getUsername());
        Assert.assertFalse(userManagementSection.isSearchResultDisplayed(user.getUsername()));
    }

}

package autotests.adminPageTest;

import autotests.BaseTest;
import core.ActionsHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import static core.ActionsHelper.scrollDown;

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
    public void testUserDeletionFunctionality(){
        loginPage.fillInUsername("Admin");
        loginPage.fillInPassword("admin123");
        loginPage.clickOnLogin();
        leftMenuComponent
                .goToAdminPage(getDriver())
                .openUsersSection(getDriver())
                .searchEnterUsername("FMLName")
                .clickOnSearch();
        scrollDown(getDriver(), 300);
        Assert.assertTrue(userManagementSection.isSearchResultDisplayed("FMLName"));
        userManagementSection.deleteUserByUsername("FMLName");
        Assert.assertFalse(userManagementSection.isSearchResultDisplayed("FMLName"));
    }

}

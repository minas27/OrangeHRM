package autotests.dashboard.adminPageTest;

import autotests.BaseTest;
import core.ActionsHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

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
                .searchEnterUsername("sandip123")
                .clickOnSearch();
        ActionsHelper.scrollDown(getDriver(), 300);
        Assert.assertTrue(userManagementSection.isSearchResultDisplayed("sandip123"));
    }

}

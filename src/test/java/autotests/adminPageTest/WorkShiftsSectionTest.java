package autotests.adminPageTest;

import autotests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static core.ActionsHelper.scrollDown;

public class WorkShiftsSectionTest extends BaseTest {
    @Test
    public void checkWorkshiftAddingFunctionality() {
        Assert.assertTrue(loginPage.isOnLoginPage());
        loginPage.fillInUsername("Admin");
        loginPage.fillInPassword("admin123");
        loginPage.clickOnLogin();
        leftMenuComponent
                .goToAdminPage(getDriver())
                .openWorkShifts(getDriver())
                .clickOnAdd()
                .enterShiftName("Nighty")
                .clickOnWorkingHoursFromBtn()
                .increaseHours()
                .increaseMinutes();
        scrollDown(getDriver(), 150);
        workShiftsSection
//                .selectPM()
                .clickOnWorkingHoursToBtn()
                .decreaseHours()
                .enterHints("Hint for me")
                .clickOnSave();
        Assert.assertTrue(workShiftsSection.isAddedShiftDisplayed("Nighty"));
    }

    @Test
    public void checkWorkShiftDeletingFunctionality() {
        Assert.assertTrue(loginPage.isOnLoginPage());
        loginPage.fillInUsername("Admin");
        loginPage.fillInPassword("admin123");
        loginPage.clickOnLogin();
        leftMenuComponent
                .goToAdminPage(getDriver())
                .openWorkShifts(getDriver());
        Assert.assertTrue(workShiftsSection.isAddedShiftDisplayed("Nighty"));
        workShiftsSection
                .clickOnDeleteBtnByName("Nighty")
                .clickOnYesDeleteBtn();
        Assert.assertFalse(workShiftsSection.isAddedShiftDisplayed("Nighty"));
    }
}

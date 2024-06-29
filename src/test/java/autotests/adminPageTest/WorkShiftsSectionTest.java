package autotests.adminPageTest;

import autotests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static core.ActionsHelper.scrollDown;

public class WorkShiftsSectionTest extends BaseTest {
    @Test
    public void checkWorkshiftAddinFunctionality(){
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
}

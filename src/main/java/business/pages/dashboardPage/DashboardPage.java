package business.pages.dashboardPage;

import business.BasePage;
import business.pages.leavePage.AssignLeaveSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    @FindBy(css = "button[title='Assign Leave']")
    private WebElement assignLeaveButton;

    @FindBy(css = "button[title='Leave List']")
    private WebElement leaveListButton;

    @FindBy(css = "button[title='Timesheets']")
    private WebElement timeSheetsButton;

    @FindBy(css = "button[title='Apply Leave']")
    private WebElement applyLeaveButton;

    @FindBy(css = "button[title='My Leave']")
    private WebElement myLeaveButton;

    @FindBy(css = "button[title='My Timesheet']")
    private WebElement myTimesheetButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnDashboardPage(){
        return true;
    }

    public AssignLeaveSection clickOnAssignLeave(WebDriver driver){
        assignLeaveButton.click();
        return new AssignLeaveSection(driver);
    }
}

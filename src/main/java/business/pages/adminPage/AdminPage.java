package business.pages.adminPage;

import business.pages.BasePage;
import business.pages.adminPage.jobSection.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.ActionsHelper.*;

public class AdminPage extends BasePage {
    @FindBy(xpath = "//span[normalize-space()='User Management']")
    private WebElement userManagementMenuSection;

    @FindBy(css = "ul[class='oxd-dropdown-menu'] li")
    private WebElement userManagementMenuUsersSection;

    @FindBy(xpath = "//span[normalize-space()='Job']")
    private WebElement jobMenuSection;

    @FindBy(xpath = "//a[normalize-space()='Job Titles']")
    private WebElement jobMenuJobTitlesSection;

    @FindBy(xpath = "//a[normalize-space()='Pay Grades']")
    private WebElement jobMenuPayGradesSection;

    @FindBy(xpath = "//a[normalize-space()='Employment Status']")
    private WebElement jobMenuEmploymentStatusSection;

    @FindBy(xpath = "//a[normalize-space()='Job Categories']")
    private WebElement jobMenuJobCategoriesSection;

    @FindBy(xpath = "//a[normalize-space()='Work Shifts']")
    private WebElement jobMenuWorkShiftsSection;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public UserManagementSection openUsersSection(WebDriver driver){
        click(userManagementMenuSection);
        click(userManagementMenuUsersSection);
        return new UserManagementSection(getDriver());
    }

    public JobTitlesSection openJobTitles(WebDriver driver){
        click(jobMenuSection);
        click(jobMenuJobTitlesSection);
        return new JobTitlesSection(getDriver());
    }

    public PayGradesSection openPayGrades(WebDriver driver){
        click(jobMenuSection);
        click(jobMenuPayGradesSection);
        return new PayGradesSection(getDriver());
    }

    public EmploymentStatusSection openEmploymentStatus(WebDriver driver){
        click(jobMenuSection);
        click(jobMenuEmploymentStatusSection);
        return new EmploymentStatusSection(getDriver());
    }

    public JobCategoriesSection openJobCategories(WebDriver driver){
        click(jobMenuSection);
        click(jobMenuJobCategoriesSection);
        return new JobCategoriesSection(getDriver());
    }

    public WorkShiftsSection openWorkShifts(WebDriver driver){
        click(jobMenuSection);
        click(jobMenuWorkShiftsSection);
        return new WorkShiftsSection(getDriver());
    }
}

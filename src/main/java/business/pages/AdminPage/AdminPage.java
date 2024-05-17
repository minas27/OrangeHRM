package business.pages.AdminPage;

import business.BasePage;
import business.pages.AdminPage.JobSection.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {
    @FindBy(xpath = "//span[normalize-space()='User Management']")
    private WebElement userManagementMenuSection;

    @FindBy(css = "ul[class='oxd-dropdown-menu'] li")
    private WebElement userManagementMenuUsersSection;

    @FindBy(xpath = "//span[normalize-space()='Job']")
    private WebElement jobMenuSection;

    @FindBy(xpath = "//span[normalize-space()='Job']")
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
        userManagementMenuSection.click();
        waitHelper.waitUntilVisibility(userManagementMenuUsersSection);
        userManagementMenuUsersSection.click();
        return new UserManagementSection(driver);
    }

    public JobTitlesSection openJobTitles(WebDriver driver){
        jobMenuSection.click();
        waitHelper.waitUntilVisibility(jobMenuJobTitlesSection);
        jobMenuJobTitlesSection.click();
        return new JobTitlesSection(driver);
    }

    public PayGradesSection openPayGrades(WebDriver driver){
        jobMenuSection.click();
        waitHelper.waitUntilVisibility(jobMenuPayGradesSection);
        jobMenuPayGradesSection.click();
        return new PayGradesSection(driver);
    }

    public EmploymentStatusSection openEmploymentStatus(WebDriver driver){
        jobMenuSection.click();
        waitHelper.waitUntilVisibility(jobMenuEmploymentStatusSection);
        jobMenuEmploymentStatusSection.click();
        return new EmploymentStatusSection(driver);
    }

    public JobCategoriesSection openJobCategories(WebDriver driver){
        jobMenuSection.click();
        waitHelper.waitUntilVisibility(jobMenuJobCategoriesSection);
        jobMenuJobCategoriesSection.click();
        return new JobCategoriesSection(driver);
    }

    public WorkShiftsSection openWorkShifts(WebDriver driver){
        jobMenuSection.click();
        waitHelper.waitUntilVisibility(jobMenuWorkShiftsSection);
        jobMenuWorkShiftsSection.click();
        return new WorkShiftsSection(driver);
    }
}

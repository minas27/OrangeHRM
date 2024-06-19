package business.pages.AdminPage.JobSection;

import business.pages.AdminPage.AdminPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkShiftsSection extends AdminPage {
    public WorkShiftsSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(css = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    private WebElement shiftNameInput;

    @FindBy(xpath = "//div[contains(@class, 'oxd-grid-item')]//label[text()='From']/following::div[@class='oxd-time-input'][1]/input")
    private WebElement workingHoursFrom;

    @FindBy(xpath = "//div[contains(@class, 'oxd-grid-item')]//label[text()='To']/following::div[@class='oxd-time-input'][1]/input")
    private WebElement workingHoursTo;

    @FindBy(css = ".oxd-input.oxd-input--focus.oxd-time-hour-input-text")
    private WebElement workingHoursFromInputForHour;

    @FindBy(css = ".oxd-input.oxd-input--active.oxd-time-minute-input-text")
    private WebElement workingHoursFromInputForMinute;

    @FindBy(css = "i[class='oxd-icon bi-chevron-up oxd-icon-button__icon oxd-time-hour-input-up']")
    private WebElement increaseHourBtn;

    @FindBy(css = "i[class='oxd-icon bi-chevron-down oxd-icon-button__icon oxd-time-hour-input-down']")
    private WebElement decreaseHourBtn;

    @FindBy(css = "i[class='oxd-icon bi-chevron-up oxd-icon-button__icon oxd-time-minute-input-up']")
    private WebElement increaseMinuteBtn;

    @FindBy(css = "i[class='oxd-icon bi-chevron-down oxd-icon-button__icon oxd-time-minute-input-down']")
    private WebElement decreaseMinuteBtn;

    @FindBy(css = "input[value='AM']")
    private WebElement timeAMBtn;

    @FindBy(css = "input[value='PM']")
    private WebElement timePMBtn;

    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement assignedEmployeesInput;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement requiredWarningMessage;

    public WorkShiftsSection clickOnAdd(){
        waitHelper.waitUntilVisibility(addBtn);
        addBtn.click();
        return this;
    }

    //TODO implement delete and edit options for existing statuses

    public WorkShiftsSection clickOnCancel(){
        waitHelper.waitUntilVisibility(cancelBtn);
        cancelBtn.click();
        return this;
    }

    public WorkShiftsSection clickOnSave(){
        waitHelper.waitUntilVisibility(saveBtn);
        saveBtn.click();
        return this;
    }
}

package business.pages.adminPage.jobSection;

import business.pages.adminPage.AdminPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static core.ActionsHelper.*;

public class WorkShiftsSection extends AdminPage {
    public WorkShiftsSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    private WebElement shiftNameInput;

    @FindBy(xpath = "//div[contains(@class, 'oxd-grid-item')]//label[text()='From']/following::div[@class='oxd-time-input'][1]/input")
    private WebElement workingHoursFrom;

    @FindBy(xpath = "//div[contains(@class, 'oxd-grid-item')]//label[text()='To']/following::div[@class='oxd-time-input'][1]/input")
    private WebElement workingHoursTo;

    @FindBy(css = ".oxd-input.oxd-input--active.oxd-time-hour-input-text")
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

    @FindBy(xpath = "//button[normalize-space()='No, Cancel']")
    private WebElement cancelBtnForDeleting;

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement yesDeletBtn;



    public WorkShiftsSection clickOnAdd(){
        click(addBtn);
        return this;
    }

    //TODO implement delete and edit options for existing statuses

    public WorkShiftsSection enterShiftName(String shiftName){
        insertData(shiftNameInput, shiftName);
        return this;
    }

    public WorkShiftsSection clickOnWorkingHoursFromBtn(){
        click(workingHoursFrom);
        return this;
    }

    public WorkShiftsSection clickOnWorkingHoursToBtn(){
        click(workingHoursTo);
        return this;
    }

    public WorkShiftsSection increaseHours(){
        click(increaseHourBtn);
        return this;
    }

    public WorkShiftsSection decreaseHours(){
        click(decreaseHourBtn);
        return this;
    }

    public WorkShiftsSection increaseMinutes(){
        click(increaseMinuteBtn);
        return this;
    }

    public WorkShiftsSection decreaseMinutes(){
        click(decreaseMinuteBtn);
        return this;
    }

    public WorkShiftsSection selectAM(){
        click(timeAMBtn);
        return this;
    }

    public WorkShiftsSection selectPM(){
        click(timePMBtn);
        return this;
    }

    public WorkShiftsSection enterHints(String hints){
        insertData(assignedEmployeesInput, hints);
        return this;
    }

    public WorkShiftsSection clickOnCancel(){
        click(cancelBtn);
        return this;
    }

    public WorkShiftsSection clickOnSave(){
        click(saveBtn);
        return this;
    }

    public WebElement getWorkshiftByName(String workshiftName){
        waitHelper.waitUntilVisibility(By.xpath("//div[contains(text(),'" + workshiftName + "')]"));
        return getDriver().findElement(By.xpath("//div[contains(text(),'" + workshiftName + "')]"));
    }

    public WebElement findRowByName(String name) {
        waitHelper.waitUntilVisibility(By.cssSelector(".oxd-table-row"));

        WebElement row = getDriver().findElement(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell' and div[text()='" + name + "']]/parent::div"));

        return row;
    }

    public WorkShiftsSection clickOnDeleteBtnByName(String name){
        findRowByName(name).findElement(By.cssSelector("button.oxd-icon-button")).click();
        return this;
    }

    public WorkShiftsSection clickOnCancelBtnOfDelete(){
        click(cancelBtnForDeleting);
        return this;
    }

    public WorkShiftsSection clickOnYesDeleteBtn(){
        click(yesDeletBtn);
        return this;
    }

    public Boolean isAddedShiftDisplayed(String workshiftName){
        return  isDisplayed(getWorkshiftByName(workshiftName));
    }
}

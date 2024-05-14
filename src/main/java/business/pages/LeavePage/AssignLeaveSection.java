package business.pages.LeavePage;

import business.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignLeaveSection extends BasePage {
    @FindBy(css = "[placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(className = "oxd-select-text-input")
    private WebElement leaveTypeDropdown;

    @FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]")
    private WebElement fromDateInput;

    @FindBy(xpath = "//div[@class='oxd-layout-context']//div[2]//div[1]//div[2]//div[1]//div[1]//input[1]")
    private WebElement toDateInput;

    @FindBy(className = "oxd-textarea")
    private WebElement commentsInput;

    @FindBy(css = "[type='submit']")
    private WebElement assignButton;

    @FindBy(xpath = "//*[contains(text(),\"CAN - B\")]")
    private WebElement leaveTypeCanBereavement;

    @FindBy(xpath = "//*[contains(text(),\"CAN - F\")]")
    private WebElement leaveTypeCanFMLA;

    @FindBy(xpath = "//*[contains(text(),\"CAN - M\")]")
    private WebElement leaveTypeMatternity;

    @FindBy(xpath = "//*[contains(text(),\"CAN - P\")]")
    private WebElement leaveTypePersonal;

    @FindBy(xpath = "//*[contains(text(),\"CAN - V\")]")
    private WebElement leaveTypeCanVacation;

    @FindBy(xpath = "//*[contains(text(),\"CAN - V\")]")
    private WebElement leaveTypeSick;

    @FindBy(xpath = "//*[contains(text(),\"US - B\")]")
    private WebElement leaveTypeUsBereavement;

    @FindBy(xpath = "//*[contains(text(),\"US - F\")]")
    private WebElement leaveTypeUsFmla;

    @FindBy(xpath = "//*[contains(text(),\"US - M\")]")
    private WebElement leaveTypeUsMatternity;

    @FindBy(xpath = "//*[contains(text(),\"US - P\")]")
    private WebElement leaveTypeUsPersonal;

    @FindBy(xpath = "//*[contains(text(),\"US - V\")]")
    private WebElement leaveTypeUsVacation;

    public AssignLeaveSection(WebDriver driver) {
        super(driver);
    }


}

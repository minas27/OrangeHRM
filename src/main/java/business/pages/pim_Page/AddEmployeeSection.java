package business.pages.pim_Page;

import business.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.ActionsHelper.click;
import static core.ActionsHelper.insertData;

public class AddEmployeeSection extends BasePage {
    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameInput;

    @FindBy(css = "input[placeholder='Middle Name']")
    private WebElement middleNameInput;

    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div//input")
    private WebElement employeeIdInput;

    @FindBy(xpath = "//p[text()='Create Login Details']/following-sibling::div//input[@type='checkbox']")
    private WebElement createLoginDetailsBtn;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    @FindBy(className = "employee-image-action")
    private WebElement addPhotoBtn;

    @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[text()='Password']/parent::div/following-sibling::div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[text()='Confirm Password']/parent::div/following-sibling::div/input")
    private WebElement confirmPasswordInput;

    @FindBy(css = "input[type='radio'][value='1']")
    private WebElement statusEnabled;

    @FindBy(css = "input[type='radio'][value='2']")
    private WebElement statusDisabled;

    public AddEmployeeSection(WebDriver driver) {
        super(driver);
    }

    public AddEmployeeSection enterFullName(String fName, String mName, String lName) {
        insertData(firstNameInput, fName);
        insertData(middleNameInput, mName);
        insertData(lastNameInput, lName);
        return this;
    }

    public AddEmployeeSection clickOnCreateLoginDetails(){
        click(createLoginDetailsBtn);
        return this;
    }

    public AddEmployeeSection enterUsername(String username){
        insertData(usernameInput, username);
        return this;
    }

    public AddEmployeeSection selectStatus(String status){
        if (status.equals("Enabled")){
            click(statusEnabled);
            return this;
        } else if(status.equals("Disabled")){
            click(statusDisabled);
            return this;
        }
        return this;
    }

    public AddEmployeeSection enterPassword(String password){
        insertData(passwordInput, password);
        return this;
    }

    public AddEmployeeSection enterConfirmPassword(String confirmPassword){
        insertData(confirmPasswordInput, confirmPassword);
        return this;
    }

    public EmployeeListSection clickOnCancel(){
        click(cancelBtn);
        return new EmployeeListSection(getDriver());
    }

    public EmployeeListSection clickOnSave(){
        click(saveBtn);
        return new EmployeeListSection(getDriver());
    }
}

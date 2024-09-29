package business.pages.adminPage;

import business.objects.UserData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static core.ActionsHelper.*;
import static core.WaitHelper.pause;
import static core.WaitHelper.waitUntilVisibility;

public class UserManagementSection extends AdminPage {

    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    private WebElement userSearchUsernameInput;

    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement userEmployeeNameInput;

    @FindBy(xpath = "//*[text()=\" Reset \"]")
    private WebElement resetBtn;

    @FindBy(xpath = "//*[text()=\" Search \"]")
    private WebElement searchBtn;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addNewUserBtn;

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement yesDeleteBtn;

    @FindBy(xpath = "//button[normalize-space()='No, Cancel']")
    private WebElement noCancelBtn;

    @FindBy(xpath = "//label[text()='User Role']/ancestor::div[contains(@class, 'oxd-input-group')]//i")
    private WebElement userRoleDropdownBtn;

    @FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class, 'oxd-input-group')]//i")
    private WebElement statusDropdownBtn;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement newUserCancelBtn;

    public UserManagementSection(WebDriver driver) {
        super(driver);
    }

    public UserManagementSection searchEnterUsername(String username) {
        insertData(userSearchUsernameInput, username);
        return this;
    }

    public UserManagementSection enterUserRole(String role) {
        click(userRoleDropdownBtn);
        click(getDriver().findElement(By.xpath("//span[contains(text(),'" + role + "')]")));
        return this;
    }

    public UserManagementSection enterEmployeeName(String name) throws InterruptedException {
        insertData(userEmployeeNameInput, name);
        pause(3);
        click(getDriver().findElement(By.xpath("//div[contains(@class, 'oxd-autocomplete-dropdown')]//div[contains(@class, 'oxd-autocomplete-option')]/span[contains(text(), '" + name + "')]")));
        return this;
    }

    public UserManagementSection userStatus(String status){
        click(statusDropdownBtn);
        click(getDriver().findElement(By.xpath("//span[normalize-space()='" + status + "']")));
        return this;
    }

    public UserManagementSection clickOnReset(){
        click(resetBtn);
        return this;
    }

    public UserManagementSection clickOnSearch(){
        click(searchBtn);
        return this;
    }

    public boolean isSearchResultDisplayed(String searchText) {
        String formattedXpath = String.format("//div[text() = '%s']", searchText);

        try {
            waitUntilVisibility(By.xpath(formattedXpath));
            WebElement searchResult = getDriver().findElement(By.xpath(formattedXpath));
            return searchResult.isDisplayed();

        } catch (NoSuchElementException | TimeoutException | NullPointerException e) {
            return false;
        }
    }

    public WebElement findRowOfUserByUsername(String username) {
        try {
            return getDriver().findElement(By.xpath("//div[contains(@class, 'oxd-table-row')][.//div[text()='" + username + "']]"));

        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public UserManagementSection deleteUserByUsername(String username) {
        if (findRowOfUserByUsername(username) != null) {
            WebElement deleteButton = findRowOfUserByUsername(username).findElement(By.xpath("//button[i[contains(@class, 'bi-trash')]]"));
            click(deleteButton);
            click(yesDeleteBtn);
        }
        return this;
    }

    public UserManagementSection editUserByUsername(){
        return this;
    }

    public UserManagementSection clickOnAdd() {
        click(addNewUserBtn);
        return new UserManagementSection(getDriver());
    }

    public UserManagementSection insertNewUserCredential(String label, String value) {
        String xpath = String.format("//label[text()='%s']/parent::div/following-sibling::div//input", label);
        WebElement inputField = getDriver().findElement(By.xpath(xpath));
        insertData(inputField, value);
        return this;
    }

    public UserManagementSection newUserOperation(String action){
        click(getDriver().findElement(By.xpath("//button[normalize-space()='" + action + "']")));
        return this;
    }

    public void createNewUser(UserData userData) throws InterruptedException {
        clickOnAdd();
        enterUserRole(userData.getUserRole());
        enterEmployeeName(userData.getEmployeeName());
        userStatus(userData.getStatus());
        insertNewUserCredential("Username", userData.getUsername());
        insertNewUserCredential("Password", userData.getPassword());
        insertNewUserCredential("Confirm Password", userData.getPassword());
        newUserOperation("Save");
    }

    public boolean isErrorMessageDisplayed(String errorMessage) {
        String xpath = String.format("//span[contains(@class, 'oxd-input-field-error-message') and text()='%s']", errorMessage);

        try {
            WebElement errorElement = getDriver().findElement(By.xpath(xpath));
            waitUntilVisibility(errorElement);
            return errorElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        catch (TimeoutException e) {
            return false;
        }
    }
}

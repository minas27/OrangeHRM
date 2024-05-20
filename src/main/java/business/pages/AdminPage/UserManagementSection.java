package business.pages.AdminPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserManagementSection extends AdminPage {

    @FindBy(css = ".oxd-input.oxd-input--focus")
    private WebElement userSearchUsernameInput;

    @FindBy(css = "(//div[contains(text(),'-- Select --')])[1]")
    private WebElement userSearchUserRoleInput;

    @FindBy(xpath = "//span[contains(text(),'Admin')]")
    private WebElement userSearchAdminRoleOption;

    @FindBy(xpath = "//span[contains(text(),'ESS')]")
    private WebElement userSearchEssRoleOption;

    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement userSearchEmployeeNameInput;

    @FindBy(css = "(//div[contains(text(),'-- Select --')])[2]")
    private WebElement selectStatusInput;

    @FindBy(xpath = "//span[normalize-space()='Enabled']")
    private WebElement enabledOption;

    @FindBy(xpath = "//span[normalize-space()='Disabled']")
    private WebElement disabledOption;

    @FindBy(xpath = "//*[text()=\" Reset \"]")
    private WebElement resetBtn;

    @FindBy(xpath = "//*[text()=\" Search \"]")
    private WebElement searchBtn;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addNewUserBtn;

    @FindBy(xpath = "//div[contains(text(),'%s')]")
    private WebElement searchResult;

    public UserManagementSection(WebDriver driver) {
        super(driver);
    }

    public UserManagementSection searchEnterUsername(String username) {
        waitHelper.waitUntilVisibility(userSearchUsernameInput);
        userSearchUsernameInput.sendKeys(username);
        return this;
    }

    public UserManagementSection searchSelectRoleAdmin() {
        waitHelper.waitUntilVisibility(userSearchUserRoleInput);
        userSearchUserRoleInput.click();
        waitHelper.waitUntilVisibility(userSearchAdminRoleOption);
        userSearchAdminRoleOption.click();
        return this;
    }

    public UserManagementSection searchSelectESS() {
        waitHelper.waitUntilVisibility(userSearchUserRoleInput);
        userSearchUserRoleInput.click();
        waitHelper.waitUntilVisibility(userSearchEssRoleOption);
        userSearchEssRoleOption.click();
        return this;
    }

    public UserManagementSection searchEnterEmployeeName(String name) {
        waitHelper.waitUntilVisibility(userSearchEmployeeNameInput);
        userSearchEmployeeNameInput.sendKeys(name);
        return this;
    }

    public UserManagementSection searchSelectStatusEnabled(){
        waitHelper.waitUntilVisibility(selectStatusInput);
        selectStatusInput.click();
        waitHelper.waitUntilVisibility(enabledOption);
        enabledOption.click();
        return this;
    }

    public UserManagementSection searchSelectStatusDisabled(){
        waitHelper.waitUntilVisibility(selectStatusInput);
        selectStatusInput.click();
        waitHelper.waitUntilVisibility(disabledOption);
        disabledOption.click();
        return this;
    }

    public UserManagementSection clickOnReset(){
        waitHelper.waitUntilVisibility(resetBtn);
        resetBtn.click();
        return this;
    }

    public UserManagementSection clickOnSearch(){
        waitHelper.waitUntilVisibility(searchBtn);
        searchBtn.click();
        return this;
    }

    public boolean isSearchResultDisplayed(String searchText) {
        String formattedXpath = String.format("//div[contains(text(),'%s')]", searchText);

        try {
            WebElement searchResult = getDriver().findElement(By.xpath(formattedXpath));
            return searchResult.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}

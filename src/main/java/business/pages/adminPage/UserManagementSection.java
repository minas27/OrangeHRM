package business.pages.adminPage;

import core.ActionsHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static core.ActionsHelper.*;

public class UserManagementSection extends AdminPage {

    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
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

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement yesDeleteBtn;

    @FindBy(xpath = "//button[normalize-space()='No, Cancel']")
    private WebElement noCancelBtn;

    public UserManagementSection(WebDriver driver) {
        super(driver);
    }

    public UserManagementSection searchEnterUsername(String username) {
        insertData(userSearchUsernameInput, username);
        return this;
    }

    public UserManagementSection searchSelectRoleAdmin() {
        click(userSearchUserRoleInput);
        click(userSearchAdminRoleOption);
        return this;
    }

    public UserManagementSection searchSelectESS() {
        click(userSearchUserRoleInput);
        click(userSearchEssRoleOption);
        return this;
    }

    public UserManagementSection searchEnterEmployeeName(String name) {
        insertData(userSearchEmployeeNameInput, name);
        return this;
    }

    public UserManagementSection searchSelectStatusEnabled(){
        click(selectStatusInput);
        click(enabledOption);
        return this;
    }

    public UserManagementSection searchSelectStatusDisabled(){
        click(selectStatusInput);
        click(disabledOption);
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
            waitHelper.waitUntilVisibility(By.xpath(formattedXpath));
            WebElement searchResult = getDriver().findElement(By.xpath(formattedXpath));
            return searchResult.isDisplayed();

        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    //TODO implement find UserNameRowElement by given username
    public WebElement findRowOfUserByUsername(String username){
        List<WebElement> rows = getDriver().findElements(By.className("oxd-table-row"));
        WebElement usernameCell = null;
        for (WebElement row : rows) {
            try {
                usernameCell = row.findElement(By.xpath(".//div[@role='row' and contains(text(), '" + username + "')]"));
            } catch (NoSuchElementException e) {
                continue;
            }
        }
        return usernameCell;
    }

    //TODO implement delete user with given username value
    public void deleteUserByUsername(String username) {
            if (findRowOfUserByUsername(username) != null) {
                WebElement deleteButton = findRowOfUserByUsername(username).findElement(By.className("bi-trash"));
                deleteButton.click();
                waitHelper.waitUntilVisibility(yesDeleteBtn);
                yesDeleteBtn.click();
            }
        }
}

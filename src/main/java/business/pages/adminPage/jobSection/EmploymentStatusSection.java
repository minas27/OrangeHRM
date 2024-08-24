package business.pages.adminPage.jobSection;

import business.pages.adminPage.AdminPage;
import core.ActionsHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.ActionsHelper.*;

public class EmploymentStatusSection extends AdminPage {
    public EmploymentStatusSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    private WebElement nameInput;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement requiredWarningMessage;

    public EmploymentStatusSection clickOnAdd(){
        click(addBtn);
        return this;
    }

    public EmploymentStatusSection enterName(String name){
        insertData(nameInput, name);
        return this;
    }

    public EmploymentStatusSection clickOnCancel(){
        click(cancelBtn);
        return this;
    }

    public EmploymentStatusSection clickOnSave(){
        click(saveBtn);
        return this;
    }

    //TODO implement delete and edit options for existing statuses

    public Boolean isRequiredMessageDisplayed() {
        return isDisplayed(requiredWarningMessage);
    }
}

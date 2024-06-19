package business.pages.AdminPage.JobSection;

import business.pages.AdminPage.AdminPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobCategoriesSection extends AdminPage {
    public JobCategoriesSection(WebDriver driver) {
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

    public JobCategoriesSection clickOnAdd(){
        waitHelper.waitUntilVisibility(addBtn);
        addBtn.click();
        return this;
    }

    public JobCategoriesSection enterName(String name){
        waitHelper.waitUntilVisibility(nameInput);
        nameInput.sendKeys(name);
        return this;
    }

    public JobCategoriesSection clickOnCancel(){
        waitHelper.waitUntilVisibility(cancelBtn);
        cancelBtn.click();
        return this;
    }

    public JobCategoriesSection clickOnSave(){
        waitHelper.waitUntilVisibility(saveBtn);
        saveBtn.click();
        return this;
    }

    //TODO implement delete and edit options for existing statuses

    public Boolean isRequiredMessageDisplayed(){
        try {
            waitHelper.waitUntilVisibility(requiredWarningMessage);
            return requiredWarningMessage.isDisplayed();
        }

        catch (NoSuchElementException e) {
            return false;
        }
    }
}

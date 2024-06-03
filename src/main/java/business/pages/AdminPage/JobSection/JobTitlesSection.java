package business.pages.AdminPage.JobSection;

import business.pages.AdminPage.AdminPage;
import core.ActionsHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class JobTitlesSection extends AdminPage {
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    private WebElement jobTitleInput;

    @FindBy(css = "textarea[placeholder='Type description here']")
    private WebElement jobDescriptionInput;

    @FindBy(className = "oxd-file-button")
    private WebElement jobSpecificationUploadInput;

    @FindBy(css = "textarea[placeholder='Add note']")
    private WebElement addNoteInput;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    public JobTitlesSection(WebDriver driver) {
        super(driver);
    }

    public JobTitlesSection clickOnAddBtn(){
        waitHelper.waitUntilVisibility(addBtn);
        addBtn.click();
        return this;
    }

    public JobTitlesSection enterJobTitle(String jobTitle){
        waitHelper.waitUntilVisibility(jobTitleInput);
        jobTitleInput.sendKeys(jobTitle);
        return this;
    }

    public JobTitlesSection enterJobDescription(String jobDescription){
        waitHelper.waitUntilVisibility(jobDescriptionInput);
        jobDescriptionInput.sendKeys(jobDescription);
        return this;
    }

    public JobTitlesSection enterNotes(String notes){
        waitHelper.waitUntilVisibility(addNoteInput);
        addNoteInput.sendKeys(notes);
        return this;
    }

    public JobTitlesSection clickOnCancel(WebDriver driver){
        ActionsHelper.scrollDown(driver, 350);
        waitHelper.waitUntilVisibility(cancelBtn);
        cancelBtn.click();
        return this;
    }

    public JobTitlesSection clickOnSave(){
        waitHelper.waitUntilVisibility(saveBtn);
        saveBtn.click();
        return this;
    }

    public boolean isJobDisplayed(String jobTitle){
        try {
            waitHelper.waitUntilVisibility(By.xpath("//div[contains(text(),'" + jobTitle + "')]"));
            WebElement jobTitleSearch = getDriver().findElement(By.xpath("//div[contains(text(),'" + jobTitle + "')]"));
            return  jobTitleSearch.isDisplayed();
        }
        catch (NoSuchElementException | TimeoutException e){
            return false;
        }
    }

}

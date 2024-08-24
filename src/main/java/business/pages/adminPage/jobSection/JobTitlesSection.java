package business.pages.adminPage.jobSection;

import business.pages.adminPage.AdminPage;
import core.ActionsHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static core.ActionsHelper.*;

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
        click(addBtn);
        return this;
    }

    public JobTitlesSection enterJobTitle(String jobTitle){
        insertData(jobTitleInput, jobTitle);
        return this;
    }

    public JobTitlesSection enterJobDescription(String jobDescription){
        insertData(jobDescriptionInput, jobDescription);
        return this;
    }

    public JobTitlesSection enterNotes(String notes){
        insertData(addNoteInput, notes);
        return this;
    }

    public JobTitlesSection clickOnCancel(WebDriver driver){
        scrollDown(driver, 350);
        click(cancelBtn);
        return this;
    }

    public JobTitlesSection clickOnSave(){
        click(saveBtn);
        return this;
    }

    //TODO implement delete functionality by passing job name
    public JobTitlesSection deleteJob(String jobTitle){
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

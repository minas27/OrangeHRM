package business.pages.AdminPage.JobSection;

import business.pages.AdminPage.AdminPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class PayGradesSection extends AdminPage {
    public PayGradesSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    private WebElement nameInput;

    @FindBy(css = "[type='submit']")
    private WebElement saveBtn;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[text()='Required']")
    private WebElement requiredWarningMessage;

    public PayGradesSection clickOnSave(){
        waitHelper.waitUntilVisibility(saveBtn);
        saveBtn.click();
        return this;
    }

    public PayGradesSection clickOnCancel(){
        waitHelper.waitUntilVisibility(cancelBtn);
        cancelBtn.click();
        return this;
    }

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

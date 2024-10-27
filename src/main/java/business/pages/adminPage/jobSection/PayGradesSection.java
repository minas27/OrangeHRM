package business.pages.adminPage.jobSection;

import business.pages.adminPage.AdminPage;
import core.CommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.ActionsHelper.*;
import static core.CommonElements.*;

public class PayGradesSection extends AdminPage {
    private CommonElements commonElements;

    public PayGradesSection(WebDriver driver) {
        super(driver);
        this.commonElements = new CommonElements(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper']//label[text()='Name']/ancestor::div[contains(@class, 'oxd-input-group')]//input")
    private WebElement nameInput;

    @FindBy(css = "[type='submit']")
    private WebElement saveBtn;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelBtn;

    public PayGradesSection clickOnSave(){
        click(saveBtn);
        return this;
    }

    public PayGradesSection clickOnCancel(){
        click(cancelBtn);
        return this;
    }

    public PayGradesSection clickOnAdd(){
        click(addBtn);
        return this;
    }

    public PayGradesSection enterName(String name){
        insertData(nameInput, name);
        return this;
    }

    //TODO add remove and edit functionality for a given grade

    public PayGradesSection deleteUserByUsername(String username) {
        if (commonElements.findRowOfUserByUsername(username) != null) {
            WebElement deleteButton = commonElements.findRowOfUserByUsername(username).findElement(By.xpath("//button[i[contains(@class, 'bi-trash')]]"));
            click(deleteButton);
            click(commonElements.getYesDeleteBtn());
        }
        return this;
    }
}

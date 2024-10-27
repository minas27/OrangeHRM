package business.pages.pim_Page;

import business.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.ActionsHelper.click;

public class EmployeeListSection extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'oxd-input-group') and .//label[text()='Employee Id']]//input")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class, 'oxd-input-group')]//input")
    private WebElement employeeID;

    @FindBy(xpath = "//label[text()='Employment Status']/ancestor::div[contains(@class, 'oxd-input-group')]//i[contains(@class, 'oxd-icon')]")
    private WebElement employmentStatusDropdownBtn;

    @FindBy(xpath = "//div[contains(@class, 'oxd-grid-item')]//label[text()='Include']/following::div[contains(@class, 'oxd-select-text')][1]//i[contains(@class, 'oxd-icon')]")
    private WebElement includeDropdownBtn;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--focus']//input[@placeholder='Type for hints...']")
    private WebElement supervisorNameInput;

    @FindBy(xpath = "//label[text()='Job Title']/ancestor::div[contains(@class, 'oxd-input-group')]/descendant::i[contains(@class, 'oxd-select-text--arrow')]")
    private WebElement jobTitleDropdownBtn;

    public EmployeeListSection(WebDriver driver) {
        super(driver);
    }

    private WebElement getEmploymentStatusByName(String statusName){
        return getDriver().findElement(By.xpath("//span[normalize-space()='" + statusName + "']"));
    }

    private WebElement getIncludeOptionByName(String includeName){
        return getDriver().findElement(By.xpath("//span[normalize-space()='" + includeName + "']"));
    }


    public EmployeeListSection selectEmploymentStatus(String statusOption){
        click(employmentStatusDropdownBtn);
        WebElement option = getEmploymentStatusByName(statusOption);
        click(option);
        return this;
    }

    public EmployeeListSection selectIncludeOptionByName(String includeOption){
        click(includeDropdownBtn);
        return this;
    }
}

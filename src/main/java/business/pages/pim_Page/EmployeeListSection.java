package business.pages.pim_Page;

import business.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListSection extends BasePage {
    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//div[contains(@class, 'oxd-input-group') and .//label[text()='Employee Id']]//input")
    private WebElement employeeID;

    @FindBy(xpath = "//label[text()='Employment Status']/ancestor::div[contains(@class, 'oxd-input-group')]/descendant::i[contains(@class, 'oxd-select-text--arrow')]")
    private WebElement employmentStatusDropdownBtn;

    @FindBy(xpath = "//label[text()='Include']/ancestor::div[contains(@class, 'oxd-input-group')]/descendant::i[contains(@class, 'oxd-select-text--arrow')]")
    private WebElement includeDropdownBtn;

    @FindBy(xpath = "//div[contains(text(),'Current Employees Only')]")
    private WebElement includeCurrentEmployeesOnly;

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
        waitHelper.waitUntilVisibility(employmentStatusDropdownBtn);
        employmentStatusDropdownBtn.click();
        WebElement option = getEmploymentStatusByName(statusOption);
        waitHelper.waitUntilVisibility(option);
        option.click();
        return this;
    }

    public EmployeeListSection selectIncludeOptionByName(String includeOption){
        waitHelper.waitUntilVisibility(includeDropdownBtn);
        includeDropdownBtn.click();
        return this;
    }
}

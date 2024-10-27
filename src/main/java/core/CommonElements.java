package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static core.ActionsHelper.click;
import static core.WaitHelper.waitUntilVisibility;

public class CommonElements {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public CommonElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement yesDeleteBtn;

    @FindBy(xpath = "//button[normalize-space()='No, Cancel']")
    private WebElement noCancelBtn;

    public WebElement findRowOfUserByUsername(String title) {
        try {
            return getDriver().findElement(By.xpath("//div[contains(@class, 'oxd-table-row')][.//div[text()='" + title + "']]"));

        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public WebElement getAddBtn() {
        return addBtn;
    }

    public WebElement getYesDeleteBtn() {
        return yesDeleteBtn;
    }

    public WebElement getNoCancelBtn() {
        return noCancelBtn;
    }
}

package business.pages;

import core.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(css = "[title=\"Help\"]")
    private WebElement helpCenterButton;

    public WaitHelper waitHelper;

    private WebDriver driver;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnHelpButton(){
        WaitHelper.waitUntilVisibility(helpCenterButton);
        helpCenterButton.click();
    }

    public WebDriver getDriver(){
        return driver;
    }
}

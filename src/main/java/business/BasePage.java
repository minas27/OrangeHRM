package business;

import core.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WaitHelper waitHelper;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }


}

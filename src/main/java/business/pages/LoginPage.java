package business.pages;

import business.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "[placeholder=\"Username\"]")
    private WebElement usernameInput;

    @FindBy(css = "[placeholder=\"Password\"]")
    private WebElement passwordInput;

    @FindBy(css = "[type=\"submit\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[text()='Forgot your password? ']")
    private WebElement forgotPasswordButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillInUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void fillInPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public boolean isOnLoginPage() {
        waitHelper.waitUntilVisibility(usernameInput);
        return usernameInput.isDisplayed();
    }
}

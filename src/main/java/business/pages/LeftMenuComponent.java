package business.pages;

import business.pages.adminPage.AdminPage;
import business.pages.dashboardPage.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuComponent extends BasePage {
    @FindBy(css = "[placeholder='Search']")
    private WebElement searchBar;

    @FindBy(css = "button[role='none']")
    private WebElement leftSideMenuExpandButton;

    @FindBy(xpath = "//a[.//span[text()='Admin']]")
    private WebElement adminPageButton;

    @FindBy(xpath = "//a[.//span[text()='PIM']]")
    private WebElement pimPageButton;

    @FindBy(xpath = "//a[.//span[text()='Leave']]")
    private WebElement leavePageButton;

    @FindBy(xpath = "//a[.//span[text()='Time']]")
    private WebElement timePageButton;

    @FindBy(xpath = "//a[.//span[text()='Recruitment']]")
    private WebElement recruitmentPageButton;

    @FindBy(xpath = "//a[.//span[text()='My Info']]")
    private WebElement myInfoPageButton;

    @FindBy(xpath = "//a[.//span[text()='Performance']]")
    private WebElement performancePageButton;

    @FindBy(xpath = "//a[.//span[text()='Dashboard']]")
    private WebElement dashboardPageButton;

    @FindBy(xpath = "//a[.//span[text()='Directory']]")
    private WebElement directoryPageButton;

    @FindBy(xpath = "//a[.//span[text()='Maintenance']]")
    private WebElement maintenancePageButton;

    @FindBy(xpath = "//a[.//span[text()='Claim']]")
    private WebElement claimPageButton;

    @FindBy(xpath = "//a[.//span[text()='Buzz']]")
    private WebElement buzzPageButton;

    public LeftMenuComponent(WebDriver driver) {
        super(driver);
    }

    public void searchForDashboardSection(String section) {
        waitHelper.waitUntilVisibility(searchBar);
        searchBar.sendKeys(section);
    }

    public void clickOnExpandButton(){
        waitHelper.waitUntilVisibility(leftSideMenuExpandButton);
        leftSideMenuExpandButton.click();
    }

    public boolean isLeftMenuExpanded(){
        waitHelper.waitUntilVisibility(adminPageButton);
        return !adminPageButton.getAttribute("class").contains("toggle");
    }

    public AdminPage goToAdminPage(WebDriver driver){
        waitHelper.waitUntilVisibility(adminPageButton);
        adminPageButton.click();
        return new AdminPage(driver);
    }

    public DashboardPage goToDashboardPage(WebDriver driver){
        waitHelper.waitUntilVisibility(dashboardPageButton);
        dashboardPageButton.click();
        return new DashboardPage(driver);
    }

}

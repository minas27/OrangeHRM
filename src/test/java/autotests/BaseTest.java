package autotests;

import business.pages.adminPage.AdminPage;
import business.pages.adminPage.jobSection.JobTitlesSection;
import business.pages.adminPage.jobSection.WorkShiftsSection;
import business.pages.adminPage.UserManagementSection;
import business.pages.dashboardPage.DashboardPage;
import business.pages.LeftMenuComponent;
import business.pages.LoginPage;
import core.ActionsHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import static business.data.CommonData.BASE_URL;

public class BaseTest {
    private static ChromeDriver chromeDriver;

    protected LoginPage loginPage;

    protected LeftMenuComponent leftMenuComponent;

    protected DashboardPage dashboardPage;

    protected AdminPage adminPage;

    protected UserManagementSection userManagementSection;

    protected JobTitlesSection jobTitlesSection;

    protected WorkShiftsSection workShiftsSection;

    protected static ActionsHelper actionsHelper;



    public BaseTest() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        actionsHelper = new ActionsHelper();
        loginPage = new LoginPage(chromeDriver);
        leftMenuComponent = new LeftMenuComponent(chromeDriver);
        dashboardPage = new DashboardPage(chromeDriver);
        adminPage = new AdminPage(chromeDriver);
        userManagementSection = new UserManagementSection(chromeDriver);
        jobTitlesSection = new JobTitlesSection(chromeDriver);
        workShiftsSection = new WorkShiftsSection(chromeDriver);
    }

    public static ChromeDriver getDriver(){
        return chromeDriver;
    }

    @BeforeMethod
    public void setup() {
        chromeDriver.manage().window().maximize();
        chromeDriver.get(BASE_URL);
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        chromeDriver.close();
    }
}

package autotests;

import business.factory.DriverManager;
import business.pages.adminPage.AdminPage;
import business.pages.adminPage.jobSection.JobTitlesSection;
import business.pages.adminPage.jobSection.WorkShiftsSection;
import business.pages.adminPage.UserManagementSection;
import business.pages.dashboardPage.DashboardPage;
import business.pages.LeftMenuComponent;
import business.pages.LoginPage;
import core.ActionsHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static business.data.CommonData.BASE_URL;

public class BaseTest {

    protected LoginPage loginPage;

    protected LeftMenuComponent leftMenuComponent;

    protected DashboardPage dashboardPage;

    protected AdminPage adminPage;

    protected UserManagementSection userManagementSection;

    protected JobTitlesSection jobTitlesSection;

    protected WorkShiftsSection workShiftsSection;

    protected static ActionsHelper actionsHelper;

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(@Optional String browser){
        browser = System.getProperty("browser", browser);
        setDriver(new DriverManager().initializeDriver(browser));
        getDriver().get(BASE_URL);
        actionsHelper = new ActionsHelper();
        loginPage = new LoginPage(getDriver());
        leftMenuComponent = new LeftMenuComponent(getDriver());
        dashboardPage = new DashboardPage(getDriver());
        adminPage = new AdminPage(getDriver());
        userManagementSection = new UserManagementSection(getDriver());
        jobTitlesSection = new JobTitlesSection(getDriver());
        workShiftsSection = new WorkShiftsSection(getDriver());
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " + "DRIVER = " + getDriver());
    }

    @Parameters("browser")
    @AfterMethod
    public void quitDriver(@Optional String browser, ITestResult result) throws IOException {
        getDriver().close();
        System.out.println("Current thread: " + Thread.currentThread().getId() + ", " + "Driver = " + getDriver());
//        if(result.getStatus() == ITestResult.FAILURE){
//            File destFile = new File("scr" + File.separator +
//                    browser + File.separator +
//                    result.getTestClass().getRealClass().getSimpleName() +
//                    "_" + result.getMethod().getMethodName() + ".png");
//            takeScreenshot(destFile);
//            takeScreenshotUsingAShot(destFile);
//        }
    }

}

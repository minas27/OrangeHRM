package autotests;

import business.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import static business.data.CommonData.BASE_URL;

public class BaseTest {
    private static ChromeDriver chromeDriver;

    protected LoginPage loginPage;

    public BaseTest() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        loginPage = new LoginPage(chromeDriver);
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

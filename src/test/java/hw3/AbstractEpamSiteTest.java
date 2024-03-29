package hw3;

import hw3.page.AbstractPage;
import hw3.utils.PropertiesWorking;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public abstract class AbstractEpamSiteTest {

    public WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        PropertiesWorking.loadFromPropertiesFile("./src/main/resources/hw3/user-data.properties");
    }

    @AfterClass
    public void clear() {
        webDriver.close();
    }

    public void openPageLoginVerifyUrlTitleUsername(AbstractPage page) {
//    1. Open test site by URL
        page.openMainPage();
        assertTrue(page.verifyPageUrl("https://jdi-testing.github.io/jdi-light/index.html"));
//    2. Assert Browser title
        assertTrue(page.verifyBrowserTitle("Home Page"));
//    3. Perform login
        page.getLogInComponent().login();
        //to check if user logged in logout button must appear
        assertTrue(page.getLogInComponent().verifyLogoutButton("LOGOUT"));
//    4. Assert Username is logged in
        assertTrue(page.getLogInComponent().verifyUsername());
    }

}
package hw4.tests;

import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
import hw4.utils.PropertiesWorking;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class AbstractEpamSiteTest {

    public WebDriver webDriver;

    public ActionStep actionStep;
    public AssertionStep assertionStep;

    @BeforeClass
    public void setUp(ITestContext testContext) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        PropertiesWorking.loadFromPropertiesFile("./src/main/resources/hw3/user-data.properties");

        actionStep = new ActionStep(webDriver);
        assertionStep = new AssertionStep(webDriver);

        testContext.setAttribute("webDriver", webDriver);
    }

    @AfterClass
    public void clear() {
        webDriver.close();
    }

    public void openPageLoginVerifyUrlTitleUsername(String login, String password, String username) {
//    1. Open test site by URL
        actionStep.openSitePage("index");
        String homePageUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        assertionStep.assertSiteUrl(homePageUrl);
//    2. Assert Browser title
        assertionStep.assertBrowserTitle("Home Page");
//    3. Perform login
        actionStep.performLogin(login, password);
        //to check if user logged in logout button should appear
        assertionStep.afterLoginLogoutButtonShouldAppear();
//    4. Assert Username is logged in
        assertionStep.assertUserName(username);
    }
}
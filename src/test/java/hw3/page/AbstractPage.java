package hw3.page;

import hw3.page.component.forAbstractPage.HeaderMenuComponent;
import hw3.page.component.forAbstractPage.LeftMenuComponent;
import hw3.page.component.forAbstractPage.LogInComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    protected WebDriver webDriver;

    private HeaderMenuComponent headerMenuComponent;
    private LeftMenuComponent leftMenuComponent;
    private LogInComponent logInComponent;


    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        headerMenuComponent = new HeaderMenuComponent();
        leftMenuComponent = new LeftMenuComponent();
        logInComponent = new LogInComponent();
    }

    public void openMainPage(){
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.get(url);
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    SoftAssert softAssert = new SoftAssert();

    public void verifySiteUrl(String expUrl) {
        softAssert.assertEquals(webDriver.getCurrentUrl(),expUrl);
    }

    public void verifyBrowserTitle(String expTitle) {
        softAssert.assertEquals(webDriver.getTitle(),expTitle);
    }

    public HeaderMenuComponent getHeaderMenuComponent() {
        return headerMenuComponent;
    }

    public LeftMenuComponent getLeftMenuComponent() {
        return leftMenuComponent;
    }

    public LogInComponent getLogInComponent() {
        return logInComponent;
    }
}
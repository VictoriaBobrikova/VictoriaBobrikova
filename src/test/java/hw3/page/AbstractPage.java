package hw3.page;

import hw3.page.component.abstractPageComponents.HeaderMenuComponent;
import hw3.page.component.abstractPageComponents.LeftMenuComponent;
import hw3.page.component.abstractPageComponents.LogInComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    public WebDriver webDriver;

    private HeaderMenuComponent headerMenuComponent;
    private LeftMenuComponent leftMenuComponent;
    private LogInComponent logInComponent;


    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        headerMenuComponent = new HeaderMenuComponent(webDriver);
        leftMenuComponent = new LeftMenuComponent();
        logInComponent = new LogInComponent(webDriver);

        PageFactory.initElements(webDriver, headerMenuComponent);
        PageFactory.initElements(webDriver, leftMenuComponent);
        PageFactory.initElements(webDriver, logInComponent);
    }

    public void openMainPage() {
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.get(url);
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    public boolean verifyPageUrl(String expUrl) {
        return webDriver.getCurrentUrl().equals(expUrl);
    }

    public boolean verifyBrowserTitle(String expTitle) {
        return webDriver.getTitle().equals(expTitle);
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
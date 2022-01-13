package hw5.steps;

import hw5.page.DifferentElementsPage;
import hw5.page.MainPage;
import hw5.page.UserTablePage;
import hw5.services.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseStep {

    protected MainPage mainPage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    protected AbstractBaseStep() {
        WebDriver webDriver = WebDriverSingleton.getDriver();
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        userTablePage = new UserTablePage(webDriver);
    }
}
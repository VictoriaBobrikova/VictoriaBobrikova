package hw4.steps;

import hw4.page.DifferentElementsPage;
import hw4.page.MainPage;
import hw4.utils.PropertiesWorking;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    public MainPage mainPage;
    public DifferentElementsPage differentElementsPage;

    protected AbstractStep(WebDriver webDriver) {
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Step("Open epam site {namePage} page")
    public void openSitePage(String namePage) {
        mainPage.openPage(namePage);
    }

    @Step("Perform login")
    public void performLogin(String login, String password) {
        mainPage.getLogInComponent().login(login, password);
    }
}

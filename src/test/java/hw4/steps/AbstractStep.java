package hw4.steps;

import hw4.page.DifferentElementsPage;
import hw4.page.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    MainPage mainPage;
    DifferentElementsPage differentElementsPage;

    protected AbstractStep(WebDriver webDriver) {
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Step("Open epam site home page")
    public void openHomePage() {
        mainPage.openMainPage();
    }

    @Step("Perform login")
    public void performLogin() {
        mainPage.getLogInComponent().login();
    }
}

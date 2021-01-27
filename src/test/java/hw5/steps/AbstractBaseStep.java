package hw5.steps;

import hw5.page.DifferentElementsPage;
import hw5.page.MainPage;
import org.openqa.selenium.WebDriver;

public class AbstractBaseStep {

    public MainPage mainPage;
    public DifferentElementsPage differentElementsPage;

    protected AbstractBaseStep() {
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }
}

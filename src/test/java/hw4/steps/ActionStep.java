package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Get window handler to check it")
    public String getWindowHandler() {
        return mainPage.getIFrameComponent().getWindowHandle();
    }

    @Step("Switch to the iframe")
    public void switchToIFrame() {
        mainPage.getIFrameComponent().switchToIframe();
    }

    @Step("Switch to original window back")
    public void switchToOriginalWindow() {
        mainPage.getIFrameComponent().switchFromIframeBack();
    }

    @Step("Click Different Elements in Service menu")
    public void clickDifferentElementsInServiceMenu() {
        mainPage.getHeaderMenuComponent().openDifferentElementsInService();
        differentElementsPage.pageLoad();
    }

    @Step("Select {name}")
    public void selectCheckboxOrRadioButton(String name) {
        differentElementsPage.getCheckboxOrRadiobuttonByText(name).click();
    }

    @Step("Open Colors dropdown")
    public void openDropdownWithColors() {
        differentElementsPage.openColorsDropdown();
    }

    @Step("Click {color} color in dropdown")
    public void clickColor(String color) {
        differentElementsPage.getColor(color).click();
    }
}
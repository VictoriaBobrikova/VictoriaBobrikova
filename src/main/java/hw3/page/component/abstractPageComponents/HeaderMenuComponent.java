package hw3.page.component.abstractPageComponents;

import hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HeaderMenuComponent implements AbstractComponent {

    public WaitActions waitActions;
    public WebDriver webDriver;

    @FindBy(xpath = "//*[@class=\"uui-navigation nav navbar-nav m-l8\"]/li")
    private List<WebElement> listHeaderMenu;
    @FindBy(xpath = "//*[@class=\"dropdown-menu\"]")
    private WebElement serviceDropDownMenu;
    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement serviceHeaderItem;
    @FindBy(xpath = "//a[contains(@href,'different-elements')]")
    private WebElement differentElementsInServiceDropdown;

    public HeaderMenuComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        waitActions = new WaitActions(webDriver);
    }

    public List<WebElement> getListHeaderMenu() { return listHeaderMenu; }

    @Override
    public int countItems() {
        return listHeaderMenu.size();
    }

    @Override
    public boolean itemsAreDisplayed() {
        return listHeaderMenu.stream().allMatch(WebElement::isDisplayed);
    }

    public void openDifferentElementsInService() {
        serviceHeaderItem.click();
        waitActions.waitUntilCondition(ex -> serviceDropDownMenu.isDisplayed());
        differentElementsInServiceDropdown.click();
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }
}
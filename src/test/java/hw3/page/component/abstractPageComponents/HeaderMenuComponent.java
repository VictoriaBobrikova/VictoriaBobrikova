package hw3.page.component.abstractPageComponents;

import hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HeaderMenuComponent extends AbstractComponent {

    WaitActions waitActions;
    WebDriver webDriver;

    @FindBy(xpath = "//*[@class=\"uui-navigation nav navbar-nav m-l8\"]/li")
    private List<WebElement> listHeaderMenu;
    @FindBy(xpath = "//*[@class=\"dropdown-menu\"]")
    private WebElement serviceDropDownMenu;
    @FindBy(xpath = "//*[@class=\"dropdown-menu\"]/li")
    private List<WebElement> serviceDropDownMenuItems;

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

    public void clickHeaderMenuItem(String menuItem) {
        for (WebElement headerMenuItem : listHeaderMenu) {
            if (headerMenuItem.getText().contains(menuItem)) {
                headerMenuItem.click();
                break;
            }
        }
    }

    public boolean waitUntilServiceDropDownMenuIsDisplayed() {
        return waitActions.waitUntilCondition(ex -> serviceDropDownMenu.isDisplayed());
    }

    public void clickItemInServiceDropDownMenu(String menuItem) {
        for (WebElement dropDownMenuItem : serviceDropDownMenuItems) {
            if (dropDownMenuItem.getText().contains(menuItem)) {
                dropDownMenuItem.click();
                break;
            }
        }
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }
}
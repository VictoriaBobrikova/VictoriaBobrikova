package hw3.page.component.abstractPageComponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftMenuComponent implements AbstractComponent {

    @FindBy(xpath = "//ul[@class=\"sidebar-menu\"]/li")
    private List<WebElement> listLeftMenu;

    public List<WebElement> getListLeftMenu() { return listLeftMenu; }

    @Override
    public int countItems() {
        return listLeftMenu.size();
    }

    @Override
    public boolean itemsAreDisplayed() {
        return listLeftMenu.stream().allMatch(WebElement::isDisplayed);
    }
}
package hw3.page.component.forAbstractPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftMenuComponent extends AbstractComponent {

    @FindBy(xpath = "//ul[@class='sidebar-menu']/li")
    private List<WebElement> listLeftMenu;

    @Override
    public int countItems() {
        return listLeftMenu.size();
    }

    @Override
    public boolean itemsAreDisplayed() {
        return listLeftMenu.stream().allMatch(WebElement::isDisplayed);
    }
}

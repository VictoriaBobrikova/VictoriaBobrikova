package hw3.page.component.forAbstractPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderMenuComponent extends AbstractComponent {

    @FindBy(xpath = "//*[@class='uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> listHeaderMenu;

    @Override
    public int countItems() {
        return listHeaderMenu.size();
    }

    @Override
    public boolean itemsAreDisplayed() {
        return listHeaderMenu.stream().allMatch(WebElement::isDisplayed);
    }
}
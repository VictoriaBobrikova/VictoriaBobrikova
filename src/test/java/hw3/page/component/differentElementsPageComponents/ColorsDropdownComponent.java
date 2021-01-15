package hw3.page.component.differentElementsPageComponents;

import hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ColorsDropdownComponent {

    WaitActions waitActions;
    WebDriver webDriver;

    public ColorsDropdownComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        waitActions = new WaitActions(webDriver);
    }

    @FindBy(xpath = "//*[@class=\"colors\"]")
    private WebElement colorsDropdown;

    @FindBy(xpath = "//*[@class=\"uui-form-element\"]/option")
    private List<WebElement> listColors;

    public void openColorsDropdown() {
        colorsDropdown.click();
        waitActions.waitUntilCondition(ex ->
                listColors.stream().allMatch(WebElement::isDisplayed));
    }

    public void clickColorInColorsDropdown(String color) {
        for (WebElement colorItem : listColors) {
            if (color.equals(colorItem.getText())) {
                colorItem.click();
            }
        }
    }

    public boolean verifyColor(String color) {
        return colorsDropdown.getText().contains(color);
    }
}

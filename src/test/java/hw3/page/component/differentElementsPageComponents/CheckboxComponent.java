package hw3.page.component.differentElementsPageComponents;

import hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxComponent {

    WaitActions waitActions;
    WebDriver webDriver;

    public CheckboxComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        waitActions = new WaitActions(webDriver);
    }

    @FindBy(xpath = "//*[@class=\"label-checkbox\"]")
    private List<WebElement> listCheckboxes;

    public void clickCheckbox(String checkboxText) {
        for (WebElement checkbox : listCheckboxes) {
            if (checkbox.getText().contains(checkboxText)) {
                checkbox.click();
//                waitActions.waitUntilCondition(ex -> checkbox.isSelected());
            }
        }
    }

    public boolean verifySelectedCheckbox(String checkboxText) {
        for (WebElement checkbox : listCheckboxes) {
            if (checkbox.getText().contains(checkboxText)) {
                return checkbox.isSelected();
            }
        }
        return false;
    }
}

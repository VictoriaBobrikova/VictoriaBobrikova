package hw3.page.component.differentElementsPageComponents;

import hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RadioButtonComponent {

    WaitActions waitActions;
    WebDriver webDriver;

    public RadioButtonComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        waitActions = new WaitActions(webDriver);
    }

    @FindBy(xpath = "//*[@class=\"label-radio\"]")
    private List<WebElement> listRadioButtons;

    public void clickRadioButton(String radioButtonText) {
        for (WebElement radioButton : listRadioButtons) {
            if (radioButton.getText().contains(radioButtonText)) {
                radioButton.click();
                waitActions.waitUntilCondition(ex -> radioButton.isEnabled());
                break;
            }
        }
    }

    public boolean verifyEnabledRadioButton(String radioButtonText) {
        for (WebElement radioButton : listRadioButtons) {
            if (radioButton.getText().contains(radioButtonText)) {
                return radioButton.isEnabled();
            }
        }
        return false;
    }
}

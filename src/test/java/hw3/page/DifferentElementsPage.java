package hw3.page;

import hw3.page.component.differentElementsPageComponents.CheckboxComponent;
import hw3.page.component.differentElementsPageComponents.ColorsDropdownComponent;
import hw3.page.component.differentElementsPageComponents.RadioButtonComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends AbstractPage {

    private CheckboxComponent checkboxComponent;
    private RadioButtonComponent radioButtonComponent;
    private ColorsDropdownComponent colorsDropdownComponent;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        checkboxComponent = new CheckboxComponent(webDriver);
        radioButtonComponent = new RadioButtonComponent(webDriver);
        colorsDropdownComponent = new ColorsDropdownComponent(webDriver);

        PageFactory.initElements(webDriver, checkboxComponent);
        PageFactory.initElements(webDriver, radioButtonComponent);
        PageFactory.initElements(webDriver, colorsDropdownComponent);
    }

    public CheckboxComponent getCheckboxComponent() {
        return checkboxComponent;
    }
    public RadioButtonComponent getRadioButtonComponent() {
        return radioButtonComponent;
    }
    public ColorsDropdownComponent getColorsDropdownComponent() {
        return colorsDropdownComponent;
    }
}
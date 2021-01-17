package hw3.page;

import hw3.page.component.differentElementsPageComponents.CheckboxComponent;
import hw3.page.component.differentElementsPageComponents.ColorsDropdownComponent;
import hw3.page.component.differentElementsPageComponents.LogPanelComponent;
import hw3.page.component.differentElementsPageComponents.RadioButtonComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private CheckboxComponent checkboxComponent;
    private RadioButtonComponent radioButtonComponent;
    private ColorsDropdownComponent colorsDropdownComponent;
    private LogPanelComponent logPanelComponent;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        checkboxComponent = new CheckboxComponent(webDriver);
        radioButtonComponent = new RadioButtonComponent(webDriver);
        colorsDropdownComponent = new ColorsDropdownComponent(webDriver);
        logPanelComponent = new LogPanelComponent();

        PageFactory.initElements(webDriver, checkboxComponent);
        PageFactory.initElements(webDriver, radioButtonComponent);
        PageFactory.initElements(webDriver, colorsDropdownComponent);
        PageFactory.initElements(webDriver, logPanelComponent);
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
    public LogPanelComponent getLogPanelComponent() { return logPanelComponent; }

    @Override
    public  boolean verifyText(List<WebElement> list, List<String> textToVerify) {
        List<String> listText = new ArrayList<>();
        for (WebElement menuItem : list) {
            listText.add(menuItem.getText().substring(9));
        }
        return listText.containsAll(textToVerify);
    }
}
package hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.Combobox;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw6.entities.MetalsAndColors;

public class MetalsAndColorsPageForm extends Form<MetalsAndColors> {

//    id="summary-block"
//    class="panel-body-list results"

    @FindBy(id = "odds-selector")
    public RadioButtons radioOdd;

    @FindBy(id = "even-selector")
    public RadioButtons radioEven;

    @FindBy(id = "elements-checklist")
    public Checklist elements;

    @JDropdown(root = ".colors",
            value = ".selected",
            list = "li",
            expand = ".caret")
    public static Dropdown color;

    @JDropdown(root = ".metals",
            value = ".selected",
            list = "li",
            expand = ".caret")
    public static Combobox metals;

    @XPath("//*[@class='btn btn-default dropdown-toggle']")
    public Button buttonToOpenVegetablesDropdown;

    @FindBy(id = "salad-dropdown")
    public Dropdown vegetables;

    @FindBy(id = "submit-button")
    public Button submit;

    public void fillForm() {
        
    }
}

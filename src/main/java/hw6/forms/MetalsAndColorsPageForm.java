package hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw6.entities.MetalsAndColors;

public class MetalsAndColorsPageForm extends Form<MetalsAndColors> {

    @UI("[name=custom_radio_odd]")
    public RadioButtons radioOdd;

    @UI("[name=custom_radio_even]")
    public RadioButtons radioEven;

    @UI("#elements-checklist [type=checkbox]")
    public Checklist elements;

    @JDropdown(root = ".colors",
            value = ".selected",
            list = "li",
            expand = ".caret")
    public static Dropdown color;

    @JDropdown(root = "div[id=metals]",
            value = ".selected",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;

    @XPath("//*[@class='btn btn-default dropdown-toggle']")
    public Button buttonToOpenVegetablesDropdown;

    @Css("#salad-dropdown input")
    public Checklist vegetables;

    @FindBy(id = "submit-button")
    public Button submit;

    public void fillForm(MetalsAndColors metalsAndColors) {
        radioOdd.select(metalsAndColors.getSummary().get(0));
        radioEven.select(metalsAndColors.getSummary().get(1));
        for (String element : metalsAndColors.getElements()) {
            elements.select(element);
        }
        color.select(metalsAndColors.getColor());
        metals.select(metalsAndColors.getMetals());
        buttonToOpenVegetablesDropdown.click();
        //uncheck selected
        for (String veg : vegetables.checked()) {
            vegetables.select(veg);
        }

        for (String veg : metalsAndColors.getVegetables()) {
            vegetables.select(veg);
        }
    }
}

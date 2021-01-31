package hw6.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

public class LogResults {

    @Css(".results")
    public WebList results;

    public void checkResults() {
    }
}

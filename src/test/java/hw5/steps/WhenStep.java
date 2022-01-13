package hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WhenStep extends AbstractBaseStep {

    @When("I select {string} element")
    public void iSelectElement(String element) {
        differentElementsPage.getCheckboxOrRadiobuttonByText(element).click();
    }

    @And("I select {string} color in colors dropdown")
    public void iSelectYellowColor(String color) {
        differentElementsPage.openColorsDropdown();
        differentElementsPage.getColor(color).click();
    }

    @When("I select 'Vip' checkbox for {string}")
    public void iSelectVipCheckboxFor(String userName) {
        userTablePage.clickCheckboxForUser(userName);
    }
}
package hw5.steps;

import io.cucumber.java.en.Then;

import static org.testng.Assert.assertTrue;

public class ThenStep extends AbstractBaseStep {

    @Then("log row number {integer} has {string} text")
    public void logRowsHaveText(String text) {
        assertTrue(differentElementsPage.verifyText(
                differentElementsPage.getListLogPanel(), text));
    }

}

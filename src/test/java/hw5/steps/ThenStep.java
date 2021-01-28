package hw5.steps;

import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenStep extends AbstractBaseStep {

    @Then("log row number {int} has {string} text")
    public void logRowsHaveText(int rowNumber, String text) {
        assertEquals(differentElementsPage.getListLogPanel().get(rowNumber).getText().substring(9), text);
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String pageName) {
        assertTrue(mainPage.verifyBrowserTitle(pageName));
    }

}

package hw5.steps;

import hw5.forDataTables.UserTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenStep extends AbstractBaseStep {

    @Then("log rows have text:")
    public void logRowsHaveText(List<String> logRowTableList) {
        List<WebElement> optionsActual = userTablePage.getLogPanelComponent().getListLogPanel();
        userTablePage.verifyText(optionsActual, logRowTableList);
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String pageName) {
        assertTrue(mainPage.verifyBrowserTitle(pageName));
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTable(int dropdownsNumber) {
        assertEquals(userTablePage.countDropdown(), dropdownsNumber);
    }

    @And("{int} Usernames should be displayed on Users Table")
    public void usernamesShouldBeDisplayedOnUsersTable(int usernamesNumber) {
        assertEquals(userTablePage.countListUsernames(), usernamesNumber);
    }

    @And("{int} Description texts under images should be displayed on Users Table")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTable(int textsNumber) {
        assertEquals(userTablePage.countListTextsUnderImgs(), textsNumber);
    }

    @And("{int} checkboxes should be displayed on Users Table")
    public void checkboxesShouldBeDisplayedOnUsersTable(int checkboxesNumber) {
        assertEquals(userTablePage.countListCheckboxes(), checkboxesNumber);
    }

    @DataTableType
    public UserTable userTableEntryTransformer(Map<String, String> entry) {
        return new UserTable(
                entry.get("Number"),
                entry.get("User"),
                entry.get("Description"));
    }

    @And("User table should contain values:")
    public void userTableShouldContainValues(List<UserTable> userTablesList) {
        for (UserTable userTable : userTablesList) {
            assertEquals(userTablePage.getUserNumber(userTable.getUserTableNumber()).trim(),
                    userTable.getUserTableNumber().trim());
            assertEquals(userTablePage.getUsernameByUserNumber(userTable.getUserTableNumber()).trim(),
                    userTable.getUserTableUserName().trim());
            assertEquals(clearString(userTablePage.getDescriptionByUserNumber(userTable.getUserTableNumber())),
                    userTable.getUserTableDescription().trim());
        }
    }

    @And("droplist should contain in column Type for user {string}:")
    public void droplistShouldContainInColumnTypeForUser(String user, List<String> dropDownOptionList) {
        List<WebElement> optionsActual = userTablePage.openDropdownForUserAndGetOptions(user);
        userTablePage.verifyText(optionsActual, dropDownOptionList);
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int rowNumber, String text) {
        assertEquals(userTablePage.getLogPanelComponent()
                .getListLogPanel().get(rowNumber-1).getText().substring(9), text);
    }

    private String clearString(String str) {
        return str.replace("\n", " ").trim();
    }
}
package hw3.test;

import hw3.page.DifferentElementsPage;
import hw3.page.MainPage;
import hw3.utils.WaitActions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class EpamSiteServiceDifElemPageTest extends AbstractEpamSiteTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void serviceDifElemPageTest() {
//    1. Open test site by URL
        MainPage mainPage = new MainPage(webDriver);
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);
        mainPage.openMainPage();
        assertTrue(mainPage.verifyPageUrl("https://jdi-testing.github.io/jdi-light/index.html"));
//    2. Assert Browser title
        softAssert.assertTrue(mainPage.verifyBrowserTitle("Home Page"));
//    3. Perform login
        mainPage.getLogInComponent().login();
        //to check if user logged in logout button must appear
        assertTrue(mainPage.getLogInComponent().verifyLogoutButton("LOGOUT"));
//    4. Assert Username is logged in
        softAssert.assertTrue(mainPage.getLogInComponent().verifyUsername());
//    5. Open through the header menu Service -> Different Elements Page
        String urlDifElem = "https://jdi-testing.github.io/jdi-light/different-elements.html";
        mainPage.getHeaderMenuComponent().clickHeaderMenuItem("SERVICE");
        mainPage.getHeaderMenuComponent().waitUntilServiceDropDownMenuIsDisplayed();
        mainPage.getHeaderMenuComponent().clickItemInServiceDropDownMenu("DIFFERENT ELEMENTS");
        differentElementsPage.pageLoad();
        assertTrue(differentElementsPage.verifyPageUrl(urlDifElem));
//    6. Select checkboxes
        differentElementsPage.getCheckboxComponent().clickCheckbox("Water");
        differentElementsPage.getCheckboxComponent().clickCheckbox("Wind");
        softAssert.assertTrue(differentElementsPage.getCheckboxComponent().verifySelectedCheckbox("Water"));
        softAssert.assertTrue(differentElementsPage.getCheckboxComponent().verifySelectedCheckbox("Wind"));
//    7. Select radio
        differentElementsPage.getRadioButtonComponent().clickRadioButton("Selen");
        softAssert.assertTrue(differentElementsPage.getRadioButtonComponent().verifyEnabledRadioButton("Selen"));
//    8. Select in dropdown
        differentElementsPage.getColorsDropdownComponent().openColorsDropdown();
        differentElementsPage.getColorsDropdownComponent().clickColorInColorsDropdown("Yellow");
        softAssert.assertTrue(differentElementsPage.getColorsDropdownComponent().verifyColor("Yellow"));
//    9. Log rows
        //for each checkbox there is an individual log row
        //checkbox, radio button, dropdown name and status are corresponding to selected, each has an individual log row
        String[] logsTextToVerify = new String[]
                {"Colors: value changed to Yellow",
                        "metal: value changed to Selen",
                        "Wind: condition changed to true",
                        "Water: condition changed to true"};
        List<String> listLogsTextToVerify = Arrays.asList(logsTextToVerify);
        assertTrue(differentElementsPage.verifyText(
                differentElementsPage.getLogPanelComponent().getListLogPanel(), listLogsTextToVerify));
//    10. Close Browser in AfterTest
    }
}
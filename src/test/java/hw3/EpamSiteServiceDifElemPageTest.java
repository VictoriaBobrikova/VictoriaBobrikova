package hw3;

import hw3.page.DifferentElementsPage;
import hw3.page.MainPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class EpamSiteServiceDifElemPageTest extends AbstractEpamSiteTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void serviceDifElemPageTest() {
        MainPage mainPage = new MainPage(webDriver);
        openPageLoginVerifyUrlTitleUsername(mainPage);
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);
//    5. Open through the header menu Service -> Different Elements Page
        String urlDifElem = "https://jdi-testing.github.io/jdi-light/different-elements.html";
        mainPage.getHeaderMenuComponent().openDifferentElementsInService();
        differentElementsPage.pageLoad();
        assertTrue(differentElementsPage.verifyPageUrl(urlDifElem));
//    6. Select checkboxes
        differentElementsPage.getElementByText("Water").click();
        differentElementsPage.getElementByText("Wind").click();
        softAssert.assertTrue(differentElementsPage.getElementByText("Water").isSelected());
        softAssert.assertTrue(differentElementsPage.getElementByText("Wind").isSelected());
//    7. Select radio
        differentElementsPage.getElementByText("Selen").click();
        softAssert.assertTrue(differentElementsPage.getElementByText("Selen").isEnabled());
//    8. Select in dropdown
        differentElementsPage.openColorsDropdown();
        differentElementsPage.getYellowColor().click();
        softAssert.assertTrue(differentElementsPage.getYellowColor().getText().contains("Yellow"));
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
                differentElementsPage.getListLogPanel(), listLogsTextToVerify));
//    10. Close Browser in AfterTest
    }
}
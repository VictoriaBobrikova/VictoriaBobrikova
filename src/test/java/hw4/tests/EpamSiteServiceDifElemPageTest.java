package hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class EpamSiteServiceDifElemPageTest extends AbstractEpamSiteTest {

    @Feature(value = "Support elements in Different Elements page of Service")
    @Story(value = "Logged in user can choose element, metal and color")
    @Test(description = "Different elements page tests")
    public void serviceDifElemPageTest() {
        openPageLoginVerifyUrlTitleUsername();
//    5. Open through the header menu Service -> Different Elements Page
        String difElemUrl = "https://jdi-testing.github.io/jdi-light/different-elements.html";
        actionStep.clickDifferentElementsInServiceMenu();
        assertionStep.assertSiteUrl(difElemUrl);
//    6. Select checkboxes
        actionStep.selectCheckboxOrRadioButton("Checkbox", "Water");
        actionStep.selectCheckboxOrRadioButton("Checkbox", "Wind");
        assertionStep.checkboxOrRadioButtonIsSelected("Checkbox", "Water");
        assertionStep.checkboxOrRadioButtonIsSelected("Checkbox", "Wind");
//    7. Select radio
        actionStep.selectCheckboxOrRadioButton("Radio button", "Selen");
        assertionStep.checkboxOrRadioButtonIsSelected("Radio button", "Selen");
//    8. Select in dropdown
        actionStep.openDropdownWithColors();
        actionStep.clickColor("Yellow");
        assertionStep.colorIsSelected("Yellow");
//    9. Log rows
        //for each checkbox there is an individual log row
        //checkbox, radio button, dropdown name and status are corresponding to selected, each has an individual log row
        String[] logsTextToVerify = new String[]
                {"Colors: value changed to Yellow",
                        "metal: value changed to Selen",
                        "Wind: condition changed to true",
                        "Water: condition changed to true"};
        List<String> listLogsTextToVerify = Arrays.asList(logsTextToVerify);
        assertionStep.assertLogs(listLogsTextToVerify);
//    10. Close Browser in AfterTest
    }
}
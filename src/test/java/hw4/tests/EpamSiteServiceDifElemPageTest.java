package hw4.tests;

import hw4.utils.PropertiesWorking;
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
        openPageLoginVerifyUrlTitleUsername(PropertiesWorking.getProperty("login"),
                PropertiesWorking.getProperty("password"), PropertiesWorking.getProperty("username"));
//    5. Open through the header menu Service -> Different Elements Page
        String difElemUrl = "https://jdi-testing.github.io/jdi-light/different-elements.html";
        actionStep.clickDifferentElementsInServiceMenu();
        assertionStep.assertSiteUrl(difElemUrl);
//    6. Select checkboxes
        actionStep.selectCheckboxOrRadioButton("Water");
        actionStep.selectCheckboxOrRadioButton("Wind");
        assertionStep.checkboxOrRadioButtonIsSelected("Water");
        assertionStep.checkboxOrRadioButtonIsSelected("Wind");
//    7. Select radio
        actionStep.selectCheckboxOrRadioButton("Selen");
        assertionStep.checkboxOrRadioButtonIsSelected("Selen");
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
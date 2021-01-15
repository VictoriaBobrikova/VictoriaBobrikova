package hw3.test;

import hw3.page.DifferentElementsPage;
import hw3.page.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
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
        //checkbox name and its status are corresponding to selected
        //radio button name and it status is corresponding to selected
        //dropdown name and selected value is corresponding to selected
        softAssert.assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'Colors')]"))
                .getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'metal')]"))
                .getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'Wind')]"))
                .getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'Water')]"))
                .getText().contains("Water: condition changed to true"));
//    10. Close Browser in AfterTest
    }
}
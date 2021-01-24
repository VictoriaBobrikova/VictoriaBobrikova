package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class AssertionStep extends ActionStep {

    SoftAssert softAssert = new SoftAssert();

    public AssertionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Assert site URL")
    public void assertSiteUrl(String url) {
        assertTrue(mainPage.verifyPageUrl(url));
    }

    @Step("Browser title should be equal \"Home Page\"")
    public void browserTitleShouldBeHomePage() {
        assertTrue(mainPage.verifyBrowserTitle("Home Page"));
    }

    @Step("Check that user logged in: logout button should appear")
    public void afterLoginLogoutButtonShouldAppear() {
        assertTrue(mainPage.getLogInComponent().verifyLogoutButton("LOGOUT"));
    }

    @Step("Check username")
    public void assertUserName() {
        assertTrue(mainPage.getLogInComponent().verifyUsername());
    }

    @Step("{amount} items on the header section should be and have proper text")
    public void assertHeaderSectionItems(int amount, List<String> listHeaderTextToVerify) {
        Assert.assertEquals(mainPage.getHeaderMenuComponent().countItems(), amount);
        assertTrue(mainPage.getHeaderMenuComponent().itemsAreDisplayed());
        assertTrue(mainPage.verifyText(
                mainPage.getHeaderMenuComponent().getListHeaderMenu(), listHeaderTextToVerify));
    }
    @Step("{amount} images on the Index Page should be")
    public void assertAmountOfIndexPageImgs(int amount){
        Assert.assertEquals(mainPage.getBenefitsComponent().countImgs(), amount);
        assertTrue(mainPage.getBenefitsComponent().imgsAreDisplayed());
    }

    @Step("{amount} texts on the Index Page under icons should be and have proper text")
    public void assertTextUnderIcons(int amount, List<String> listImageTextToVerify) {
        softAssert.assertEquals(mainPage.getBenefitsComponent().countTextUnderImgs(), amount);
        softAssert.assertTrue(mainPage.getBenefitsComponent().textUnderImgsIsDisplayed());
        softAssert.assertTrue(mainPage.verifyText(
                mainPage.getBenefitsComponent().getListTextUnderImgs(), listImageTextToVerify));
    }

    @Step("The iframe with “Frame Button” should be")
    public void iframeWithFrameButtonShouldBe(){
        softAssert.assertTrue(mainPage.getIFrameComponent().getIframe().isDisplayed());
    }

    @Step("“Frame Button” in the iframe should be")
    public void checkFrameButton() {
        softAssert.assertTrue(mainPage.getIFrameComponent().getFrameButton().isDisplayed());
    }

    @Step("Check if we switch to original window back")
    public void checkWindowHandler(String actualMainWindowHandler, String mainWindowHandler) {
        softAssert.assertEquals(actualMainWindowHandler, mainWindowHandler);
    }

    @Step("{amount} items in the Left Section should be and have proper text")
    public void assertLeftSectionItems(int amount, List<String> listLeftMenuTextToVerify) {
        Assert.assertEquals(mainPage.getLeftMenuComponent().countItems(), amount);
        assertTrue(mainPage.getLeftMenuComponent().itemsAreDisplayed());
        assertTrue(mainPage.verifyText(
                mainPage.getLeftMenuComponent().getListLeftMenu(), listLeftMenuTextToVerify));
    }

    @Step("{element} {name} is selected")
    public void checkboxOrRadioButtonIsSelected(String element, String name) {
        softAssert.assertTrue(differentElementsPage
                .getCheckboxOrRadiobuttonByText(name).isSelected());
    }

    @Step("Color {color} is selected")
    public void colorIsSelected(String color) {
        softAssert.assertTrue(differentElementsPage.getColor(color).getText().contains(color));
    }

    @Step("Check rows in logs window")
    public void assertLogs(List<String> listLogsTextToVerify) {
        assertTrue(differentElementsPage.verifyText(
                differentElementsPage.getListLogPanel(), listLogsTextToVerify));
    }
}
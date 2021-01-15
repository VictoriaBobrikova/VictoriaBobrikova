package hw3.test;

import hw3.page.DifferentElementsPage;
import hw3.page.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class EpamSiteMainPageTest extends AbstractEpamSiteTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void mainPageTest() {
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
//    5. Assert that there are 4 items on the header section are displayed and they have proper texts
        //4 items
        softAssert.assertEquals(mainPage.getHeaderMenuComponent().countItems(), 4);
        //are displayed
        softAssert.assertTrue(mainPage.getHeaderMenuComponent().itemsAreDisplayed());
        //with proper text
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText(), "HOME");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'Contact form')]")).getText(),"CONTACT FORM");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'Service')]")).getText(),"SERVICE");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'Metals & Colors')]")).getText(),"METALS & COLORS");
//    6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(mainPage.getBenefitsComponent().countImgs(), 4);
        softAssert.assertTrue(mainPage.getBenefitsComponent().imgsAreDisplayed());
//    7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //4 images
        softAssert.assertEquals(mainPage.getBenefitsComponent().countTextUnderImgs(), 4);
        //are displayed
        softAssert.assertTrue(mainPage.getBenefitsComponent().textUnderImgsIsDisplayed());
        //with proper text
        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(),'include')]")).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(),'flexible')]")).getText(), "To be flexible and\n" +
                "customizable");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(),'multiplatform')]")).getText(),"To be multiplatform");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(),'Already')]")).getText(),"Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
//    8. Assert that there is the iframe with “Frame Button” exists
        softAssert.assertTrue(mainPage.getIFrameComponent().getIframe().isDisplayed());
//    9. Switch to the iframe and check that there is “Frame Button” in the iframe
        //firstly we save our handler to check its back later
        String mainWindowHandler = webDriver.getWindowHandle();
        softAssert.assertTrue(mainPage.getIFrameComponent().findFrameButton(webDriver).isDisplayed());
//    10. Switch to original window back
        webDriver.switchTo().defaultContent();
        softAssert.assertEquals(webDriver.getWindowHandle(), mainWindowHandler);
//    11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        //5 items
        softAssert.assertEquals(mainPage.getLeftMenuComponent().countItems(), 5);
        //are displayed
        softAssert.assertTrue(mainPage.getLeftMenuComponent().itemsAreDisplayed());
        //with proper text
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a/span[contains(text(),'Home')]"))
                .getText(),"Home");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a/span[contains(text(),'Contact form')]"))
                .getText(), "Contact form");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a/span[contains(text(),'Service')]"))
                .getText(), "Service");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a/span[contains(text(),'Metals & Colors')]"))
                .getText(), "Metals & Colors");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a/span[contains(text(),'Elements packs')]"))
                .getText(), "Elements packs");
        softAssert.assertAll();
//    12. Close Browser - in AfterTest of Abstract class
    }
}
package hw3;

import hw3.page.MainPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class EpamSiteMainPageTest extends AbstractEpamSiteTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void mainPageTest() {
        MainPage mainPage = new MainPage(webDriver);
        openPageLoginVerifyUrlTitleUsername(mainPage);
//    5. Assert that there are 4 items on the header section are displayed and they have proper texts
        //4 items
        softAssert.assertEquals(mainPage.getHeaderMenuComponent().countItems(), 4);
        //are displayed
        softAssert.assertTrue(mainPage.getHeaderMenuComponent().itemsAreDisplayed());
        //with proper text
        String[] headerTextToVerify = new String[] {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        List<String> listHeaderTextToVerify = Arrays.asList(headerTextToVerify);
        softAssert.assertTrue(mainPage.verifyText(
                mainPage.getHeaderMenuComponent().getListHeaderMenu(), listHeaderTextToVerify));
//    6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(mainPage.getBenefitsComponent().countImgs(), 4);
        softAssert.assertTrue(mainPage.getBenefitsComponent().imgsAreDisplayed());
//    7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //4 images
        softAssert.assertEquals(mainPage.getBenefitsComponent().countTextUnderImgs(), 4);
        //are displayed
        softAssert.assertTrue(mainPage.getBenefitsComponent().textUnderImgsIsDisplayed());
        //with proper text
        String[] imageTextToVerify = new String[] {"To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project",
                "To be flexible and\n" +
                "customizable",
                "To be multiplatform",
                "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…"};
        List<String> listImageTextToVerify = Arrays.asList(imageTextToVerify);
        assertTrue(mainPage.verifyText(
                mainPage.getBenefitsComponent().getListTextUnderImgs(), listImageTextToVerify));
//    8. Assert that there is the iframe with “Frame Button” exists
        softAssert.assertTrue(mainPage.getIFrameComponent().getIframe().isDisplayed());
//    9. Switch to the iframe and check that there is “Frame Button” in the iframe
        //firstly we save our handler to check its back later
        String mainWindowHandler = mainPage.getIFrameComponent().getWindowHandle();
        mainPage.getIFrameComponent().switchToIframe();
        softAssert.assertTrue(mainPage.getIFrameComponent().getFrameButton().isDisplayed());
//    10. Switch to original window back
        mainPage.getIFrameComponent().switchFromIframeBack();
        String actualMainWindowHandler = mainPage.getIFrameComponent().getWindowHandle();
        softAssert.assertEquals(actualMainWindowHandler, mainWindowHandler);
//    11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        //5 items
        softAssert.assertEquals(mainPage.getLeftMenuComponent().countItems(), 5);
        //are displayed
        softAssert.assertTrue(mainPage.getLeftMenuComponent().itemsAreDisplayed());
        //with proper text
        String[] leftMenuTextToVerify = new String[]
                {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        List<String> listLeftMenuTextToVerify = Arrays.asList(leftMenuTextToVerify);
        assertTrue(mainPage.verifyText(
                mainPage.getLeftMenuComponent().getListLeftMenu(), listLeftMenuTextToVerify));
//    12. Close Browser - in AfterTest of Abstract class
    }
}
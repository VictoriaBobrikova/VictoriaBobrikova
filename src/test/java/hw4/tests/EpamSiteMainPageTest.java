package hw4.tests;

import hw4.utils.PropertiesWorking;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class EpamSiteMainPageTest extends AbstractEpamSiteTest {

    @Feature(value = "Home page has header and left menus, benefits info and iframes")
    @Story(value = "User can see header and left menus, benefits and iframes")
    @Test(description = "Home page tests")
    public void mainPageTest() {
        openPageLoginVerifyUrlTitleUsername(PropertiesWorking.getProperty("login"),
                PropertiesWorking.getProperty("password"), PropertiesWorking.getProperty("username"));
//    5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] headerTextToVerify = new String[] {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        List<String> listHeaderTextToVerify = Arrays.asList(headerTextToVerify);
        assertionStep.assertHeaderSectionItems(listHeaderTextToVerify.size(), listHeaderTextToVerify);
//    6. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.assertAmountOfIndexPageImgs(4);
//    7. Assert that there are 4 texts on the Index Page under icons and they have proper text
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
        assertionStep.assertTextUnderIcons(listImageTextToVerify.size(), listImageTextToVerify);
//    8. Assert that there is the iframe with “Frame Button” exists
        assertionStep.iframeWithFrameButtonShouldBe();
//    9. Switch to the iframe and check that there is “Frame Button” in the iframe
        //firstly we save our handler to check its back later
        String mainWindowHandler = actionStep.getWindowHandler();
        actionStep.switchToIFrame();
        assertionStep.checkFrameButton();
//    10. Switch to original window back
        String actualMainWindowHandler = actionStep.getWindowHandler();
        actionStep.switchToOriginalWindow();
        assertionStep.checkWindowHandler(mainWindowHandler, actualMainWindowHandler);
//    11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] leftMenuTextToVerify = new String[]
                {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        List<String> listLeftMenuTextToVerify = Arrays.asList(leftMenuTextToVerify);
        assertionStep.assertLeftSectionItems(listLeftMenuTextToVerify.size(), listLeftMenuTextToVerify);
//    12. Close Browser - in AfterTest of Abstract class
    }
}
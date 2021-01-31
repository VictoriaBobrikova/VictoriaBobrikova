package hw6.test;

import hw6.EpamSite;
import org.testng.annotations.Test;

import static hw6.EpamSite.homePage;
import static hw6.EpamSite.metalsAndColorsPage;
import static hw6.entities.User.ROMAN;

public class EpamSiteMetalsAndColorsPageTest extends AbstractEpamSiteTest{

    @Test
    public void userCanSubmitMetalsAndColorsFormTest() {
        EpamSite.open();
        EpamSite.login(ROMAN);
        homePage.checkUserIsLoggedIn(ROMAN);
        homePage.header.select("Metals & Colors");
        metalsAndColorsPage.isOpened();
//        metalsAndColorsPage.metalsAndColorsPageForm.fill();
        metalsAndColorsPage.metalsAndColorsPageForm.submit();
        metalsAndColorsPage.logResults.checkResults();
    }
}

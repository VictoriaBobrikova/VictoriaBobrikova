package hw6.test;

import hw6.EpamSite;
import hw6.dataProvider.MetalsAndColorsDataProvider;
import hw6.entities.MetalsAndColors;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static hw6.EpamSite.homePage;
import static hw6.EpamSite.metalsAndColorsPage;
import static hw6.entities.User.ROMAN;

public class EpamSiteMetalsAndColorsPageTest extends AbstractEpamSiteTest{

    @BeforeTest
    public void beforeTest() {
        EpamSite.open();
        EpamSite.login(ROMAN);
    }

    @Test(dataProvider = "metalsAndColorsData", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void userCanSubmitMetalsAndColorsFormTest(MetalsAndColors metalsAndColors) {
        homePage.checkUserIsLoggedIn(ROMAN);
        homePage.header.select("Metals & Colors");
        metalsAndColorsPage.isOpened();
        metalsAndColorsPage.metalsAndColorsPageForm.fillForm(metalsAndColors);
        metalsAndColorsPage.metalsAndColorsPageForm.submit();
        metalsAndColorsPage.logResults.checkResults(metalsAndColors);
    }
}
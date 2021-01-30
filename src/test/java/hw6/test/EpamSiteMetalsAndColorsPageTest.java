package hw6.test;

import hw6.EpamSite;
import hw6.entities.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EpamSiteMetalsAndColorsPageTest extends AbstractEpamSiteTest{

    @Test
    public void userCanSubmitMetalsAndColorsFormTest() {
        EpamSite.open();
        EpamSite.login(User.ROMAN);
        String usernameActual = EpamSite.getUsername();
        Assert.assertEquals(usernameActual, User.ROMAN.getUsername());


    }
}

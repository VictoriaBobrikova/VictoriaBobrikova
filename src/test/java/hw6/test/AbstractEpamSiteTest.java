package hw6.test;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.EpamSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractEpamSiteTest {

    @BeforeSuite
    public void setUp() {
        PageFactory.initSite(EpamSite.class);
    }

    @AfterSuite
    public void clear() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
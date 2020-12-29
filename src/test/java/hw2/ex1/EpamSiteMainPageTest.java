package hw2.ex1;

import hw2.AbstractEpamSiteTest;
import hw2.enums.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EpamSiteMainPageTest extends AbstractEpamSiteTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void mainPageTest() {
//    1. Open test site by URL
        openMainPage();
        softAssert.assertEquals(webDriver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html");
//    2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(),"Home Page");
//    3. Perform login
        login();
        //to check if user logged in logout button must appear
        WebElement logoutButton = webDriver.findElement(By.className("logout"));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(logoutButton));
        softAssert.assertEquals(logoutButton.getText(), "LOGOUT");
//    4. Assert Username is logged in
        WebElement userName = webDriver.findElement(By.id("user-name"));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), LoginUser.DEFAULT_USER.getUsername());
//    5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> listHeaderMenu = webDriver.findElements(By.xpath("//*[@class=\"uui-navigation nav navbar-nav m-l8\"]/li"));
        //4 items
        softAssert.assertEquals(listHeaderMenu.size(), 4);
        //are displayed
        listHeaderMenu.forEach(elemHeaderMenu -> softAssert.assertTrue(elemHeaderMenu.isDisplayed()));
        //with proper text
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText(), "HOME");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'Contact form')]")).getText(),"CONTACT FORM");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'Service')]")).getText(),"SERVICE");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'Metals & Colors')]")).getText(),"METALS & COLORS");
//    6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> listImgs = webDriver.findElements(By.xpath("//*[@class=\"benefit-icon\"]"));
        softAssert.assertEquals(listImgs.size(), 4);
        listImgs.forEach(img -> softAssert.assertTrue(img.isDisplayed()));
//    7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> listTextUnderImgs = webDriver.findElements(By.xpath("//*[@class=\"benefit-txt\"]"));
        //4 images
        softAssert.assertEquals(listTextUnderImgs.size(), 4);
        //are displayed
        listTextUnderImgs.forEach(textUnderImgs -> softAssert.assertTrue(textUnderImgs.isDisplayed()));
        //with proper text
        softAssert.assertEquals(listTextUnderImgs.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        softAssert.assertEquals(listTextUnderImgs.get(1).getText(), "To be flexible and\n" +
                "customizable");
        softAssert.assertEquals(listTextUnderImgs.get(2).getText(),"To be multiplatform");
        softAssert.assertEquals(listTextUnderImgs.get(3).getText(),"Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
//    8. Assert that there is the iframe with “Frame Button” exists
        WebElement iframe = webDriver.findElement(By.id("frame"));
        softAssert.assertTrue(iframe.isDisplayed());
//    9. Switch to the iframe and check that there is “Frame Button” in the iframe
        //firstly we save our handler to check its back later
        String mainWindowHandler = webDriver.getWindowHandle();
        WebElement frameButton = webDriver.switchTo().frame("frame").findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());
//    10. Switch to original window back
        webDriver.switchTo().defaultContent();
        softAssert.assertEquals(webDriver.getWindowHandle(), mainWindowHandler);
//    11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> listLeftMenu = webDriver.findElements(By.xpath("//ul[@class=\"sidebar-menu\"]/li"));
        //5 items
        softAssert.assertEquals(listLeftMenu.size(), 5);
        //are displayed
        listLeftMenu.forEach(leftMenuElem -> softAssert.assertTrue(leftMenuElem.isDisplayed()));
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
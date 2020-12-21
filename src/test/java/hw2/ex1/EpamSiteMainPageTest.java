package hw2.ex1;

import hw2.AbstractEpamSiteTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EpamSiteMainPageTest extends AbstractEpamSiteTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void mainPageTest() {
//    1. Open test site by URL
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.get(url);
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        softAssert.assertEquals(webDriver.getCurrentUrl(), url);
//    2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(),"Home Page");
//    3. Perform login
        //dropdown menu must be to log in
        WebElement dropDownLogin = webDriver.findElement(By.xpath("//*[@class=\"uui-navigation navbar-nav navbar-right\"]"));
        dropDownLogin.click();
        //wait until login button appears
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));
        //now log in
        String username = "Roman";
        String password = "Jdi1234";
        WebElement usernameField = webDriver.findElement(By.id("name"));
        WebElement passwordField = webDriver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        //to check if user logged in logout button must appear
        WebElement logoutButton = webDriver.findElement(By.className("logout"));
        webDriverWait.until(ExpectedConditions.visibilityOf(logoutButton));
        softAssert.assertEquals(logoutButton.getText(), "LOGOUT");
//    4. Assert Username is logged in
        String userNameExpected = "ROMAN IOVLEV";
        WebElement userName = webDriver.findElement(By.id("user-name"));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), userNameExpected);
//    5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> listHeaderMenu = webDriver.findElements(By.xpath("//*[@class=\"uui-navigation nav navbar-nav m-l8\"]/li"));
        //4 items
        softAssert.assertEquals(listHeaderMenu.size(), 4);
        //are displayed
        softAssert.assertTrue(listHeaderMenu.get(0).isDisplayed());
        softAssert.assertTrue(listHeaderMenu.get(1).isDisplayed());
        softAssert.assertTrue(listHeaderMenu.get(2).isDisplayed());
        softAssert.assertTrue(listHeaderMenu.get(3).isDisplayed());
        //with proper text
        softAssert.assertEquals(listHeaderMenu.get(0).getText(), "HOME");
        softAssert.assertEquals(listHeaderMenu.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(listHeaderMenu.get(2).getText(), "SERVICE");
        softAssert.assertEquals(listHeaderMenu.get(3).getText(), "METALS & COLORS");
//    6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> listImgs = webDriver.findElements(By.xpath("//*[@class=\"benefit-icon\"]"));
        softAssert.assertEquals(listImgs.size(), 4);
        softAssert.assertTrue(listImgs.get(0).isDisplayed());
        softAssert.assertTrue(listImgs.get(1).isDisplayed());
        softAssert.assertTrue(listImgs.get(2).isDisplayed());
        softAssert.assertTrue(listImgs.get(3).isDisplayed());
//    7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> listTextUnderImgs = webDriver.findElements(By.xpath("//*[@class=\"benefit-txt\"]"));
        //4 images
        softAssert.assertEquals(listTextUnderImgs.size(), 4);
        //are displayed
        softAssert.assertTrue(listTextUnderImgs.get(0).isDisplayed());
        softAssert.assertTrue(listTextUnderImgs.get(1).isDisplayed());
        softAssert.assertTrue(listTextUnderImgs.get(2).isDisplayed());
        softAssert.assertTrue(listTextUnderImgs.get(3).isDisplayed());
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
        softAssert.assertTrue(listLeftMenu.get(0).isDisplayed());
        softAssert.assertTrue(listLeftMenu.get(1).isDisplayed());
        softAssert.assertTrue(listLeftMenu.get(2).isDisplayed());
        softAssert.assertTrue(listLeftMenu.get(3).isDisplayed());
        softAssert.assertTrue(listLeftMenu.get(4).isDisplayed());
        //with proper text
        softAssert.assertEquals(listLeftMenu.get(0).getText(), "Home");
        softAssert.assertEquals(listLeftMenu.get(1).getText(), "Contact form");
        softAssert.assertEquals(listLeftMenu.get(2).getText(), "Service");
        softAssert.assertEquals(listLeftMenu.get(3).getText(), "Metals & Colors");
        softAssert.assertEquals(listLeftMenu.get(4).getText(), "Elements packs");
        softAssert.assertAll();
//    12. Close Browser - in AfterTest of Abstract class
    }
}
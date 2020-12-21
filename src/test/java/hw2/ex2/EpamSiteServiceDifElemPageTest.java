package hw2.ex2;

import hw2.AbstractEpamSiteTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class EpamSiteServiceDifElemPageTest extends AbstractEpamSiteTest {

    @Test
    public void serviceDifElemPageTest() {

//    1. Open test site by URL
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.get(url);
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        assertEquals(webDriver.getCurrentUrl(), url);
//    2. Assert Browser title
        assertEquals(webDriver.getTitle(),"Home Page");
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
        assertEquals(logoutButton.getText(), "LOGOUT");
//    4. Assert User name in the left-top side of screen that user is logged in
        String userNameExpected = "ROMAN IOVLEV";
        WebElement userName = webDriver.findElement(By.id("user-name"));
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), userNameExpected);
//    5. Open through the header menu Service -> Different Elements Page
        String urlDifElem = "https://jdi-testing.github.io/jdi-light/different-elements.html";
        webDriver.findElement(By.xpath("//*[@class=\"dropdown-toggle\"][1]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@class=\"dropdown-menu\"]"))));
        webDriver.findElement(By.xpath("//*[@class=\"dropdown-menu\"]/li[8]")).click();
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        assertEquals(webDriver.getCurrentUrl(), urlDifElem);
//    6. Select checkboxes
        List<WebElement> listCheckboxes = webDriver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
        listCheckboxes.get(0).click();
        listCheckboxes.get(2).click();
        webDriverWait.until(ExpectedConditions.elementToBeSelected(listCheckboxes.get(0)));
        webDriverWait.until(ExpectedConditions.elementToBeSelected(listCheckboxes.get(2)));
        assertTrue(listCheckboxes.get(0).isSelected());
        assertTrue(listCheckboxes.get(2).isSelected());
//    7. Select radio
        WebElement radioButtonNeeded = webDriver.findElement(By.xpath("//*[@class=\"label-radio\"][4]"));
        radioButtonNeeded.click();
        assertTrue(radioButtonNeeded.isEnabled());
//    8. Select in dropdown
        WebElement colorsForm = webDriver.findElement(By.xpath("//*[@class=\"colors\"]"));
        colorsForm.click();
        WebElement colorOptionNeeded = webDriver.findElement(By.xpath("//option[4]"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(colorOptionNeeded));
        colorOptionNeeded.click();
//        softAssert.assertEquals(colorsForm.getText(), "Yellow"); //how to pass???
//    9. Log rows
        //for each checkbox there is an individual log row
        //checkbox name and its status are corresponding to selected
        //radio button name and it status is corresponding to selected
        //dropdown name and selected value is corresponding to selected
        List<WebElement> listLogRows = webDriver.findElements(By.xpath("//*[@class=\"panel-body-list logs\"]/li"));
        assertTrue(listLogRows.get(0).getText().contains("Colors: value changed to Yellow"));
        assertTrue(listLogRows.get(1).getText().contains("metal: value changed to Selen"));
        assertTrue(listLogRows.get(2).getText().contains("Wind: condition changed to true"));
        assertTrue(listLogRows.get(3).getText().contains("Water: condition changed to true"));
//    10. Close Browser in AfterTest
    }
}
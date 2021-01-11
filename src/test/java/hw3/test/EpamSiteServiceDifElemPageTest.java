package hw3.test;

import hw3.enums.LoginUser;
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
        openMainPage();
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        assertEquals(webDriver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html");
//    2. Assert Browser title
        assertEquals(webDriver.getTitle(),"Home Page");
//    3. Perform login
        login();
        //to check if user logged in logout button must appear
        WebElement logoutButton = webDriver.findElement(By.className("logout"));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(logoutButton));
        assertEquals(logoutButton.getText(), "LOGOUT");
//    4. Assert User name in the left-top side of screen that user is logged in
        WebElement userName = webDriver.findElement(By.id("user-name"));
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), LoginUser.DEFAULT_USER.getUsername());
//    5. Open through the header menu Service -> Different Elements Page
        String urlDifElem = "https://jdi-testing.github.io/jdi-light/different-elements.html";
        webDriver.findElement(By.xpath("//a[contains(text(),'Service')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@class=\"dropdown-menu\"]"))));
        webDriver.findElement(By.xpath("//a[contains(@href,'different-elements')]")).click();
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
        WebElement colorOptionNeeded = webDriver.findElement(By.xpath("//option[contains(text(),'Yellow')]"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(colorOptionNeeded));
        colorOptionNeeded.click();
//        softAssert.assertEquals(colorsForm.getText(), "Yellow"); //how to pass???
//    9. Log rows
        //for each checkbox there is an individual log row
        //checkbox name and its status are corresponding to selected
        //radio button name and it status is corresponding to selected
        //dropdown name and selected value is corresponding to selected
        assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'Colors')]"))
                .getText().contains("Colors: value changed to Yellow"));
        assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'metal')]"))
                .getText().contains("metal: value changed to Selen"));
        assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'Wind')]"))
                .getText().contains("Wind: condition changed to true"));
        assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'Water')]"))
                .getText().contains("Water: condition changed to true"));
//    10. Close Browser in AfterTest
    }
}
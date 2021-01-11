package hw3.page.component.forAbstractPage;

import hw3.enums.LoginUser;
import hw3.utils.WaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LogInComponent {

    SoftAssert softAssert = new SoftAssert();

    WaitActions waitActions;

    //dropdown menu must be to log in
    @FindBy(xpath = "//*[@class=\"uui-navigation navbar-nav navbar-right\"]")
    private WebElement dropDownLogin;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(className = "logout")
    private WebElement logoutButton;
    @FindBy(id = "user-name")
    private WebElement userName;

    public void login() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/test/resources/hw3/user-data.properties");
            property.load(fis);

            String login = property.getProperty("login");
            String password = property.getProperty("password");

            dropDownLogin.click();
            //wait until login button appears
            waitActions.waitUntilCondition(ex -> loginButton.isDisplayed());
            //now log in
            usernameField.sendKeys(login);
            passwordField.sendKeys(password);
            loginButton.click();
        } catch (FileNotFoundException e) {
            System.err.println("File Properties Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void verifyLogoutButton(String expButton) {
        //to check if user logged in logout button must appear
        waitActions.waitUntilCondition(ex -> logoutButton.isDisplayed());
        softAssert.assertEquals(logoutButton.getText(), expButton);
    }

    public void verifyUsername() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/test/resources/hw3/user-data.properties");
            property.load(fis);

            String username = property.getProperty("username");
            softAssert.assertTrue(userName.isDisplayed());
            softAssert.assertEquals(userName.getText(), username);
        } catch (FileNotFoundException e) {
            System.err.println("File Properties Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

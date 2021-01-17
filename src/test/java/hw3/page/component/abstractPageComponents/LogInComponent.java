package hw3.page.component.abstractPageComponents;

import hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.*;
import java.util.Properties;

public class LogInComponent {

    WaitActions waitActions;
    WebDriver webDriver;

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

    public LogInComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        waitActions = new WaitActions(webDriver);
    }

    public void login() {
        Properties properties = new Properties();

        try {
            InputStream input = getClass().getClassLoader()
                    .getResourceAsStream("hw3/user-data.properties");
            properties.load(input);

            String login = properties.getProperty("login");
            String password = properties.getProperty("password");

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

    public boolean verifyLogoutButton(String expButton) {
        //to check if user logged in logout button must appear
        waitActions.waitUntilCondition(ex -> logoutButton.isDisplayed());
        return logoutButton.getText().equals(expButton);
    }

    public boolean verifyUsername() {
        Properties property = new Properties();
        String username = "";

        try {
            InputStream input = getClass().getClassLoader()
                    .getResourceAsStream("hw3/user-data.properties");
            property.load(input);
            username = property.getProperty("username");
        } catch (FileNotFoundException e) {
            System.err.println("File Properties Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userName.isDisplayed() && userName.getText().equals(username);
    }
}
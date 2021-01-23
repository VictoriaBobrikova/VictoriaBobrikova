package hw4.page.component.abstractPageComponents;

import hw4.utils.PropertiesWorking;
import hw4.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInComponent {

    public WaitActions waitActions;
    public WebDriver webDriver;

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
        String login = PropertiesWorking.getProperty("login");
        String password = PropertiesWorking.getProperty("password");

        dropDownLogin.click();
        //wait until login button appears
        waitActions.waitUntilCondition(ex -> loginButton.isDisplayed());
        //now log in
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean verifyLogoutButton(String expButton) {
        //to check if user logged in logout button must appear
        waitActions.waitUntilCondition(ex -> logoutButton.isDisplayed());
        return logoutButton.getText().equals(expButton);
    }

    public boolean verifyUsername() {
        String username = PropertiesWorking.getProperty("username");
        return userName.isDisplayed() && userName.getText().equals(username);
    }
}
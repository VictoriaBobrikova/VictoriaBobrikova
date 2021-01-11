package hw3.page;

import hw3.page.component.forAbstractPage.HeaderMenuComponent;
import hw3.page.component.forAbstractPage.LeftMenuComponent;
import hw3.page.component.forAbstractPage.LogInComponent;
import hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    protected WebDriver webDriver;

    WaitActions waitActions;

    private HeaderMenuComponent headerMenuComponent;
    private LeftMenuComponent leftMenuComponent;
    private LogInComponent logInComponent;


    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openMainPage(){
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.get(url);
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

//    //dropdown menu must be to log in
//    @FindBy(xpath = "//*[@class=\"uui-navigation navbar-nav navbar-right\"]")
//    private WebElement dropDownLogin;
//
//    @FindBy(id = "login-button")
//    private WebElement loginButton;
//
//    @FindBy(id = "name")
//    private WebElement usernameField;
//
//    @FindBy(id = "password")
//    private WebElement passwordField;
//
//    @FindBy(className = "logout")
//    private WebElement logoutButton;
//
//    @FindBy(id = "user-name")
//    private WebElement userName;
//
//    public void login() {
//        FileInputStream fis;
//        Properties property = new Properties();
//
//        try {
//            fis = new FileInputStream("src/test/resources/hw3/user-data.properties");
//            property.load(fis);
//
//            String login = property.getProperty("login");
//            String password = property.getProperty("password");
//
//            dropDownLogin.click();
//            //wait until login button appears
//            waitActions.waitUntilCondition(ex -> loginButton.isDisplayed());
//            //now log in
//            usernameField.sendKeys(login);
//            passwordField.sendKeys(password);
//            loginButton.click();
//        } catch (FileNotFoundException e) {
//            System.err.println("File Properties Not Found");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    SoftAssert softAssert = new SoftAssert();

    public void verifySiteUrl(String expUrl) {
        softAssert.assertEquals(webDriver.getCurrentUrl(),expUrl);
    }

    public void verifyBrowserTitle(String expTitle) {
        softAssert.assertEquals(webDriver.getTitle(),expTitle);
    }

//    public void verifyLogoutButton(String expButton) {
//        //to check if user logged in logout button must appear
//        waitActions.waitUntilCondition(ex -> logoutButton.isDisplayed());
//        softAssert.assertEquals(logoutButton.getText(), expButton);
//    }
//
//    public void verifyUsername() {
//        FileInputStream fis;
//        Properties property = new Properties();
//
//        try {
//            fis = new FileInputStream("src/test/resources/hw3/user-data.properties");
//            property.load(fis);
//
//            String username = property.getProperty("username");
//            softAssert.assertTrue(userName.isDisplayed());
//            softAssert.assertEquals(userName.getText(), username);
//        } catch (FileNotFoundException e) {
//            System.err.println("File Properties Not Found");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public HeaderMenuComponent getHeaderMenuComponent() {
        return headerMenuComponent;
    }

    public LeftMenuComponent getLeftMenuComponent() {
        return leftMenuComponent;
    }

    public LogInComponent getLogInComponent() {
        return logInComponent;
    }
}
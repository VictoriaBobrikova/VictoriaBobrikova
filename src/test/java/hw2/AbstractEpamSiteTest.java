package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class AbstractEpamSiteTest {

    protected WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void clear() {
        webDriver.close();
    }

    public void openMainPage(){
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.get(url);
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    public void login() {
        //dropdown menu must be to log in
        WebElement dropDownLogin = webDriver.findElement(By.xpath("//*[@class=\"uui-navigation navbar-nav navbar-right\"]"));
        dropDownLogin.click();
        //wait until login button appears
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));
        //now log in
        WebElement usernameField = webDriver.findElement(By.id("name"));
        WebElement passwordField = webDriver.findElement(By.id("password"));
        usernameField.sendKeys(LoginUser.LOGIN.getUserAttrib());
        passwordField.sendKeys(LoginUser.PASSWORD.getUserAttrib());
        loginButton.click();
    }

    public enum LoginUser{
        LOGIN("Roman"),
        PASSWORD("Jdi1234"),
        USERNAME("ROMAN IOVLEV");

        String userAttrib;

        LoginUser(String userAttrib) {
            this.userAttrib = userAttrib;
        }

        public String getUserAttrib() {
            return userAttrib;
        }
    }
}

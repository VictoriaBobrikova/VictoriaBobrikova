package hw3.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.function.Function;

public class WaitActions {

    private WebDriverWait webDriverWait;

    public WaitActions(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    public Boolean waitUntilCondition(Function<WebDriver, Boolean> expCondition) {
        return webDriverWait.ignoring(NoSuchElementException.class).until(expCondition);
    }
}
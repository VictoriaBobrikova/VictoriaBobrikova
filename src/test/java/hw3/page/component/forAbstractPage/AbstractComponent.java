package hw3.page.component.forAbstractPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractComponent {

//    public AbstractComponent() {
//
//    }

    public abstract int countItems();
    public abstract boolean itemsAreDisplayed();
}
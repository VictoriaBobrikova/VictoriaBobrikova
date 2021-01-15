package hw3.page.component.mainPageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFrameComponent {

    public WebDriver webDriver;

    public IFrameComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frameButton")
    private WebElement frameButton;

    public WebElement getIframe() { return iframe; }

    public WebElement getFrameButton() { return frameButton; }

    public WebElement findFrameButton(WebDriver webDriver) {
        return webDriver.switchTo().frame("frame").findElement(By.id("frame-button"));
    }

}
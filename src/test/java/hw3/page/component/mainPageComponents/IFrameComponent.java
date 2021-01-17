package hw3.page.component.mainPageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFrameComponent {

    public WebDriver webDriver;

    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public IFrameComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getIframe() { return iframe; }
    public WebElement getFrameButton() { return frameButton; }

    public void switchToIframe() {
        webDriver.switchTo().frame("frame");
    }

    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    public void switchFromIframeBack() {
        webDriver.switchTo().defaultContent();
    }
}
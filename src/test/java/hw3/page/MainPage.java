package hw3.page;

import hw3.page.component.BenefitsComponent;
import hw3.page.component.IFrameComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private IFrameComponent iFrameComponent;
    private BenefitsComponent benefitsComponent;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        iFrameComponent = new IFrameComponent(webDriver);
        benefitsComponent = new BenefitsComponent();
    }

    public IFrameComponent getIFrameComponent() {
        return iFrameComponent;
    }

    public BenefitsComponent getBenefitsComponent() {
        return benefitsComponent;
    }
}

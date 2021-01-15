package hw3.page;

import hw3.page.component.mainPageComponents.BenefitsComponent;
import hw3.page.component.mainPageComponents.IFrameComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private IFrameComponent iFrameComponent;
    private BenefitsComponent benefitsComponent;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        iFrameComponent = new IFrameComponent(webDriver);
        benefitsComponent = new BenefitsComponent();

        PageFactory.initElements(webDriver, iFrameComponent);
        PageFactory.initElements(webDriver, benefitsComponent);
    }

    public IFrameComponent getIFrameComponent() {
        return iFrameComponent;
    }

    public BenefitsComponent getBenefitsComponent() {
        return benefitsComponent;
    }
}

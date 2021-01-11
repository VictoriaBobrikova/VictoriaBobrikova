package hw3.page;

import hw3.page.component.BenefitsComponent;
import hw3.page.component.IFramesComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    private IFramesComponent iFramesComponent;
    private BenefitsComponent benefitsComponent;

    @FindBy(id = "frame")
    private WebElement iframe;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public IFramesComponent getIFramesComponent() {
        return iFramesComponent;
    }

    public BenefitsComponent getBenefitsComponent() {
        return benefitsComponent;
    }
}

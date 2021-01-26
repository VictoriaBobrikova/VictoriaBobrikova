package hw4.page.component.mainPageComponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BenefitsComponent{

    @FindBy(xpath = "//*[@class=\"benefit-icon\"]")
    private List<WebElement> listImgs;
    @FindBy(xpath = "//*[@class=\"benefit-txt\"]")
    private List<WebElement> listTextUnderImgs;

    public List<WebElement> getListTextUnderImgs() { return listTextUnderImgs; }

    public int countImgs() {
        return listImgs.size();
    }

    public int countTextUnderImgs() {
        return listTextUnderImgs.size();
    }

    public boolean imgsAreDisplayed() {
        return listImgs.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean textUnderImgsIsDisplayed() {
        return listTextUnderImgs.stream().allMatch(WebElement::isDisplayed);
    }
}
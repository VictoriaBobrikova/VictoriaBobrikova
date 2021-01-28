package hw5.page;

import hw4.utils.WaitActions;
import hw5.page.component.servicePagesComponent.LogPanelComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    public WaitActions waitActions;

    @FindBy(xpath = "//*[@class=\"colors\"]")
    private WebElement colorsDropdown;
    @FindBy(xpath = "//*[@class=\"uui-form-element\"]/option")
    private List<WebElement> listColors;

    private LogPanelComponent logPanelComponent;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        waitActions = new WaitActions(webDriver);
        logPanelComponent = new LogPanelComponent();
        PageFactory.initElements(webDriver, logPanelComponent);
    }

    public WebElement getColor(String color) {
        Formatter formatter = new Formatter();
        formatter.format("//option[contains(. ,'%s')]", color);
        return webDriver.findElement(By.xpath(formatter.toString()));
    }

    public WebElement getCheckboxOrRadiobuttonByText(String elementText) {
        Formatter formatter = new Formatter();
        formatter.format("//label[contains(. ,'%s')]/input", elementText);
        return webDriver.findElement(By.xpath(formatter.toString()));
    }

    public void openColorsDropdown() {
        colorsDropdown.click();
        waitActions.waitUntilCondition(ex ->
                listColors.stream().allMatch(WebElement::isDisplayed));
    }

    @Override
    public  boolean verifyText(List<WebElement> list, List<String> textToVerify) {
        List<String> listText = new ArrayList<>();
        for (WebElement menuItem : list) {
            listText.add(menuItem.getText().substring(9));
        }
        return listText.containsAll(textToVerify);
    }
}
package hw5.page;

import hw5.page.component.servicePagesComponent.LogPanelComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Formatter;
import java.util.List;

public class UserTablePage extends AbstractPage {

    @FindBy(xpath = "//select")
    private List<WebElement> dropdowns;
    @FindBy(xpath = "//*[@type='checkbox']")
    private List<WebElement> listCheckboxes;
    @FindBy(xpath = "//td/a")
    private List<WebElement> listUsernames;
    @FindBy(xpath = "//*[@class='user-descr']")
    private List<WebElement> listTextsUnderImgs;

    private LogPanelComponent logPanelComponent;

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
        logPanelComponent = new LogPanelComponent();
        PageFactory.initElements(webDriver, logPanelComponent);
    }

    public int countDropdown() { return dropdowns.size(); }

    public int countListCheckboxes() { return listCheckboxes.size(); }

    public int countListUsernames() { return listUsernames.size(); }

    public int countListTextsUnderImgs() { return listTextsUnderImgs.size(); }

    public void openDropdownForUser(String userName) {
        Formatter formatter = new Formatter();
        formatter.format("//tr[contains(. ,'%s')]//select", userName);
        webDriver.findElement(By.xpath(formatter.toString())).click();
    }

    public void clickCheckboxForUser(String userName) {
        Formatter formatter = new Formatter();
        formatter.format("//tr[contains(. ,'%s')]//input", userName);
        webDriver.findElement(By.xpath(formatter.toString()));
    }
}

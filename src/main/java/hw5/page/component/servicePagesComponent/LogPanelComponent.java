package hw5.page.component.servicePagesComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LogPanelComponent {

    @FindBy(xpath = "//*[@class='panel-body-list logs']/li")
    private List<WebElement> listLogPanel;

    public List<WebElement> getListLogPanel() { return listLogPanel; }
}

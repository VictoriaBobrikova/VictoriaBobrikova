package hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GivenStep extends AbstractBaseStep {

    @Given("I am on JDI GitHub site Home page")
    public void iAmOnGdiGithubSiteHomePage(){
        mainPage.openPage("index");
    }

    @And("I logged in as user {string}")
    public void iLoggedInAsUser(String user) {
        mainPage.getLogInComponent().login();
    }

    @And("I click on \"Service\" button in Header")
    public void iClickOnServiceButtonInHeader() {
        mainPage.getHeaderMenuComponent().clickServiceButtonInHeader();
    }

    @And("I click {string} button in Service dropdown")
    public void iClickButtonInServiceDropdown(String buttonName) {
        mainPage.getHeaderMenuComponent().openItemInServiceDropdown(buttonName);
    }


}

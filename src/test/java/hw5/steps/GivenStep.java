package hw5.steps;

import hw5.enums.User;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GivenStep extends AbstractBaseStep {

    @Given("I am on JDI GitHub site Home page")
    public void iAmOnGdiGithubSiteHomePage(){
        mainPage.openPage("index");
    }

    @ParameterType(".*")
    public User user(String userName) {
        return User.valueOf(userName);
    }

    @And("I logged in as user {user}")
    public void iLoggedInAsUser(User user) {
        mainPage.getLogInComponent().login(User.valueOf("ROMAN_IOVLEV").getLogin(),
                User.valueOf("ROMAN_IOVLEV").getPassword());
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

package hw6.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import hw6.entities.User;
import hw6.forms.LoginForm;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {

    @FindBy(id = "user-name")
    public Label username;
    @FindBy(id = "user-icon")
    public Icon userIcon;

    public LoginForm loginForm;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUsername() {
        return username.getText();
    }
}

package hw6.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw6.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {

    @FindBy(id = "name")
    public TextField login;

    @FindBy(id = "password")
    public TextField password;

    @FindBy(id = "login-button")
    public Button enter;
}

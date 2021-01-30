package hw6.entities;

public class User {
    public static final User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private String login;
    private String password;
    private String username;

    public User(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}

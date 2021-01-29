package hw5.enums;

public enum User {
    ROMAN_IOVLEV("Roman", "Jdi1234", "ROMAN IOVLEV");

    String login;
    String password;
    String username;

    User(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username= username;
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
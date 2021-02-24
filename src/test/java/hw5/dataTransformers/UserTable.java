package hw5.dataTransformers;

public class UserTable {
    private String userTableNumber;
    private String userTableName;
    private String userTableDescription;

    public UserTable(String userTableNumber,String userTableName, String userTableDescription) {
        this.userTableNumber = userTableNumber;
        this.userTableName = userTableName;
        this.userTableDescription = userTableDescription;
    }

    public String getUserTableNumber() { return userTableNumber; }
    public String getUserTableUserName() { return userTableName; }
    public String getUserTableDescription() { return userTableDescription; }
}
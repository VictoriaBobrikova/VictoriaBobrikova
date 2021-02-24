package hw5.dataTransformers;

import hw5.enums.User;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;

import java.util.Map;

public class TypeTransformation {

    @ParameterType(".*")
    public User user(String userName) {
        return User.valueOf(userName);
    }

    @DataTableType
    public UserTable userTableEntryTransformer(Map<String, String> entry) {
        return new UserTable(
                entry.get("Number"),
                entry.get("User"),
                entry.get("Description"));
    }
}

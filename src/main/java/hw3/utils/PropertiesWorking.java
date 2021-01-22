package hw3.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWorking {

    public static Properties loadFromPropertiesFile(String file) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(file)) {
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFound");
        } catch (IOException e) {
            System.err.println("IOEXCeption");
        }
        return properties;
    }
}

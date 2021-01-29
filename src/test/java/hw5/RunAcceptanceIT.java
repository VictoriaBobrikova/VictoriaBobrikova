package hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:hw5"},
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"})
public class RunAcceptanceIT extends AbstractTestNGCucumberTests {
}
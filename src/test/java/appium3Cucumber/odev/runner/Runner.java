package appium3Cucumber.odev.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/appium3Cucumber/odev/feature"},
        glue = {"appium3Cucumber/odev/stepdefs"}
)
public class Runner extends AbstractTestNGCucumberTests {

}
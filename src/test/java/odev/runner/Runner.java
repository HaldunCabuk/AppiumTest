package odev.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/odev/feature"},
        glue = {"odev/stepdefs"}
)
public class Runner extends AbstractTestNGCucumberTests {

}
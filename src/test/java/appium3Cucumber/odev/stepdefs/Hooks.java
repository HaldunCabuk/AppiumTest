package appium3Cucumber.odev.stepdefs;

import appium3Cucumber.odev.utils.MyDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    AppiumDriver<MobileElement> driver;
    @Before
    public void before(){
      driver= MyDriver.getDriver();
    }

    @After
    public void after(){
        driver.closeApp();
        driver.quit();
    }

}

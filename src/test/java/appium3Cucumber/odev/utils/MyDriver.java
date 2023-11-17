package appium3Cucumber.odev.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MyDriver {
    private static AppiumDriver<MobileElement> driver;
    private static AppiumDriverLocalService service;

    public static AppiumDriver<MobileElement> getDriver()  {
        if (driver == null){
            startAppium();
            driver = new AndroidDriver<>(service.getUrl(), getCapabilities());

        }
        return driver;
    }

    public static void startAppium(){
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();
        service.start();
    }


    public static void quit(){
        if (driver != null) {
            driver.quit();
            service.stop();
        }
    }


    public static DesiredCapabilities getCapabilities(){

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:udid", "emulator-5554");
        caps.setCapability("appium:version", "12");
        caps.setCapability("appium:deviceName", "Dezor");
        caps.setCapability("platformName", "Android");


        caps.setCapability("appium:appPackage", "com.touchboarder.android.api.demos");
        caps.setCapability("appium:appActivity", "com.touchboarder.androidapidemos.MainActivity");
        return caps;
    }

}

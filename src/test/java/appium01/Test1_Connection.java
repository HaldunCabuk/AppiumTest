package appium01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test1_Connection {

    @Test
    public void testConnection() throws MalformedURLException {

        AppiumDriver<MobileElement> driver;

        DesiredCapabilities caps = new DesiredCapabilities(); // cihaz/emulator baglantisi, hangi uygulama calisacak

        caps.setCapability("appium:udid", "emulator-5554");
        caps.setCapability("appium:version", "12");
        caps.setCapability("appium:deviceName", "Dezor");
        caps.setCapability("platformName", "Android");

        // App bilgisi : appPackage ve appActivity
        // kullanilacak app acilir ve consolda
        // adb shell
        // dumpsys window | grep -E 'mCurrentFocus'
        //Output: mCurrentFocus=Window{de8141a u0 com.touchboarder.android.api.demos/com.touchboarder.androidapidemos.MainActivity}
        caps.setCapability("appium:appPackage", "com.touchboarder.android.api.demos");
        caps.setCapability("appium:appActivity", "com.touchboarder.androidapidemos.MainActivity");


        //  driver definition
        // driver = new ChromeDriver()
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
        driver.findElement(continueButton).click();

        By okButton = By.id("android:id/button1");
        sleep(500);
        driver.findElement(okButton).click();

        sleep(500);
        By okButton2 = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
        WebElement ok = driver.findElement(okButton2);
        ok.click();

        By apiDemosLink = By.xpath("//*[@text='API Demos']");
        driver.findElement(apiDemosLink).click();

        driver.closeApp();
        driver.quit();

    }

    public void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

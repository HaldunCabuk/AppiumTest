package appium01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class Odev {
    /**
     * Api demos a tikla
     * Views e tikla
     * Controls
     * Light Theme
     * Checkbox lar tikli olacak
     * Radius lardan biri tikli olacak
     * Star tikli olacak
     * An a tikla acik mi assert et.
     * Drop down menuden earth u sec
     */
    By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
    By okButton = By.id("android:id/button1");
    By okButton2 = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
    By saveInput = By.id("com.touchboarder.android.api.demos:id/edit");
    By dDownMenu = By.id("android:id/text1");
    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    // Appium'u programatically run etmek icin
    AppiumDriverLocalService service;


    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        startAppium();
        driver = new AndroidDriver<>(service.getUrl(), getCapabilities());
        wait = new WebDriverWait(driver, 20);
    }


    @AfterTest
    public void afterTest() {
        //driver.closeApp();
        //driver.quit();
        //service.stop();
    }


    @Test
    public void testConnection() {

        click(continueButton);
        click(okButton);
        click(okButton2);
        click("API Demos");
        click("Views");
        click("Controls");
        click("01. Light Theme");
        sendKeys(saveInput, "IDM");
        click(getXpathWithAttr("check1"));
        click(getXpathWithAttr("check2"));
        sleep(1000);
        click(getXpathWithAttr("radio2"));
        click(getXpathWithAttr("star"));
        click(getXpathWithAttr("toggle1"));
        getXpathWithAttr("on");
        click(getXpathWithAttr("text1"));
        selectPlanet("earth");


    }

    public By getXpathWithText(String text) {
        return By.xpath("//*[@text='" + text + "']");
    }

    public By getXpathWithAttr(String text) {
        By locator = By.xpath("//*[@*[contains(., '" + text + "')]]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return locator;
    }

    public By getXpathWithAttr2(String text) {
        By locator = By.xpath("//*[@*[contains(., '" + text + "')]]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return locator;
    }

    public void selectPlanet(String text) {

        List<MobileElement> elements = driver.findElements(getXpathWithAttr("text1"));

        for (MobileElement element : elements) {
            if (element.getText().toLowerCase().equals(text)) {
                element.click();
                break;
            }
        }
    }


    public void click(String text) {
        By locator = getXpathWithText(text);
        click(locator);
    }


    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public DesiredCapabilities getCapabilities() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:udid", "emulator-5554");
        caps.setCapability("appium:version", "12");
        caps.setCapability("appium:deviceName", "Dezor");
        caps.setCapability("platformName", "Android");

        caps.setCapability("appium:appPackage", "com.touchboarder.android.api.demos");
        caps.setCapability("appium:appActivity", "com.touchboarder.androidapidemos.MainActivity");
        return caps;
    }

    public void startAppium() {

        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1") // Appium 127.0.0.1 adresinden run edilecek
                //.usingPort(4723)          // Appium 4723 portundan run edilecek
                .usingAnyFreePort()         // Appium o an bos olan herhangi bir porttan run edilecek
                .build();

        service.clearOutPutStreams();

        service.start();
    }


    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

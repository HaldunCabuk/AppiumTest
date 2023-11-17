package appium3Cucumber.odev.base;

import appium3Cucumber.odev.utils.MyDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public abstract class BaseSteps {

    protected AppiumDriver<MobileElement> driver;
    protected WebDriverWait wait;

    By lNames = By.className("android.widget.TextView");
    By lPhotos = By.className("android.widget.ImageView");
    By lAllScreen = By.className("android.widget.LinearLayout");

    public BaseSteps() {
        driver = MyDriver.getDriver();
        wait = new WebDriverWait(driver, 20);
    }

    public void allScreenInfo(){
        List<MobileElement> scrInfo  = driver.findElements(lAllScreen);
        for (MobileElement mobileElement : scrInfo) {
            System.out.println(mobileElement.getText());
        }
    }
    public void checkPhotoNums(int num) {
        List<MobileElement> photos = driver.findElements(lPhotos);
        int counter = 0;

        for (MobileElement photo : photos) {
            counter++;
        }
        Assert.assertEquals(num, counter);

    }

    public void checkVisibleOfNames(String a, String b, String c, String d, int num) {

        List<MobileElement> elements = driver.findElements(lNames);
        int counter = 0;

        for (MobileElement element : elements) {
            if (element.getText().equals(a) | element.getText().equals(b) | element.getText().equals(c) | element.getText().equals(d)) {
                counter++;
            }
        }
        Assert.assertEquals(counter, num);
    }

    public void checkInVisibleOfNames(String a, String b, String c, String d) {

        List<MobileElement> elements = driver.findElements(lNames);
        int counter = 0;

        for (MobileElement element : elements) {
            if ((element.getText().equals(a) | element.getText().equals(b) | element.getText().equals(c) | element.getText().equals(d))) {
                counter++;
            }
        }
        Assert.assertEquals(counter, 0);

    }

    public void checkRankingNumber(String a, int num) {

        List<MobileElement> elements = driver.findElements(lNames);
        String str1 = "Goldy";
        int counter = 0;

        for (MobileElement element : elements) {
            if (element.getText().equals(a)) {
                counter++;
                break;
            } else if (element.getText().equals(str1)) {
                counter++;
            }

        }
        Assert.assertEquals(counter, num);
    }


    public By getXpathWithAttr(String text) {
        By locator = By.xpath("//*[contains(@text,'" + text + "')] | //*[@*[contains(., '" + text + "')]]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return locator;
    }

    public void click(String text) {
        By locator = getXpathWithTextAttr(text);
        click(locator);
    }


    public void click(By locator) {
        sleep(700);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void senkeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }


    public By getXpathWithTextAttr(String text) {
        return By.xpath("//*[contains(@text,'" + text + "')] | //*[@*[contains(., '" + text + "')]]");
    }

    public void waitForVisibilityOf(String text) {
        By locator = getXpathWithTextAttr(text);
        waitForVisibilityOf(locator);
    }

    public void waitForVisibilityOf(By locator) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(driver -> {
            if (driver.findElements(locator).size() > 0) return true;
            return false;
        });
    }

    public void swipeV(double start, double end) {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        if (start < .1) start = .1;
        if (start > .9) start = .9;

        if (end < .1) end = .1;
        if (end > .9) end = .9;

        int startPoint = (int) (height * start);
        int endPoint = (int) (height * end);

        new TouchAction<>(driver)
                .press(PointOption.point(width / 2, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(width / 2, endPoint))
                .release()
                .perform();
    }

    public void swipeH(double start, double end) {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        if (start < .1) start = .1;
        if (start > .9) start = .9;

        if (end < .1) end = .1;
        if (end > .9) end = .9;

        int startPoint = (int) (width * start);
        int endPoint = (int) (width * end);

        new TouchAction<>(driver)
                .press(PointOption.point(startPoint, height / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(endPoint, height / 2))
                .release()
                .perform();
    }

    public void swipeUntilVisible(String text, boolean down) {
        By locator = getXpathWithTextAttr(text);
        swipeUntilVisible(locator, down);
    }

    public void swipeUntilVisible(By locator, boolean down) {

        while (true) {
            try {
                if (driver.findElement(locator).isDisplayed())
                    break;
            } catch (Exception e) {
                if (down)
                    swipeV(.5, .6);
                else
                    swipeV(.4, .7);
            }
        }
    }

    public void swipeUntilVisible1(By locator, boolean down) {

        while (true) {
            if (driver.findElements(locator).size() > 0)
                break;

            if (down)
                swipeV(.6, .5);
            else
                swipeV(.4, .5);
        }
    }


    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
package appium02;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class Test1 extends BaseTest {


    @Test
    public void test1() {
        click("CONTINUE");
        click("OK");
        click("OK");


    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        // click API Demos
        click("API Demos");

        // click Views
        click("Views");

        swipeV(.8, .3);

        // click TextSwitcher
        click("TextSwitcher");

        // Ekrandaki sayi 5 oluncaya kadar Next butonuna tikla

        for (int i = 0; i < 5; i++) {
            click("next");
            waitForVisibilityOf(String.valueOf(i + 1));
        }


    }


    @Test(dependsOnMethods = "test1")
    public void test3_swipeVerical() {
        // click API Demos
        click("API Demos");

        // click Views
        click("Views");

        swipeV(.7, .4);
        swipeV(.7, .4);
        swipeV(.4, .7);
        swipeV(.4, .7);

    }

    @Test(dependsOnMethods = "test1")
    public void test4_swipeUntil() {
        // click API Demos
        click("API Demos");

        // click Views
        click("Views");

        swipeUntilVisible("WebView", true);
        swipeUntilVisible("Animation", false);

    }

    @Test(dependsOnMethods = "test1")
    public void test5_Task() {
        // a.  click Support Design Demos
        click("Support Design Demos");

        // b.  Click Text Input
        click("Text Input");

        // c.  Send "myUser" to username
        senkeys(getXpathWithTextAttr("edit_username"),"myUser");

        // d.  Assert that the userame text is "myUser"

        wait.until(ExpectedConditions.visibilityOfElementLocated(getXpathWithTextAttr("myUser")));
        // e.  click "SHOW ERROR" button

        click(getXpathWithTextAttr("SHOW ERROR"));

        // f.  Assert that error notification is visible

        wait.until(ExpectedConditions.visibilityOfElementLocated(getXpathWithTextAttr("Some unknown error has occurred")))   ;

        // g.  click "CLEAR ERROR"

        click(getXpathWithTextAttr("CLEAR ERROR"));

        // h.  Assert that error notification is not visible
        wait.until(ExpectedConditions.invisibilityOfElementLocated(getXpathWithTextAttr(null)));
    }
}
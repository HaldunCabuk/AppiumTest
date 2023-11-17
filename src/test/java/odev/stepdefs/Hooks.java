package odev.stepdefs;

import odev.utils.MyDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {


    @Before
    public void before(){
        MyDriver.getDriver();
    }

    @After
    public void after(){
        MyDriver.quit();
    }

}

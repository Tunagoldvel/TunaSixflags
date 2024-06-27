package com.StepDefinition;

import com.Utills.DriverSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void initialize() {

        DriverSetUp.initDriver();
    }

    @After
    public void quit() {

        DriverSetUp.tearDown();
    }

}

package com.codepath.testingdemo.activities;

import com.codepath.testingdemo.rules.DisableAnimationsRule;

import org.junit.ClassRule;

public class BaseInstrumentationTest {

    @ClassRule
    public static DisableAnimationsRule disableAnimationsRule = new DisableAnimationsRule();

}

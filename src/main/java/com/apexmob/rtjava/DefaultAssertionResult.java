package com.apexmob.rtjava;

public class DefaultAssertionResult implements AssertionResult {

    private final boolean wasSuccessful;
    private final Test test;

    public DefaultAssertionResult(boolean wasSuccessful, Test test) {
        this.wasSuccessful = wasSuccessful;
        this.test = test;
    }

    @Override
    public boolean wasSuccessful() {
        return wasSuccessful;
    }

    @Override
    public Test getTest() {
        return test;
    }
}

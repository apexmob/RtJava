package com.apexmob.rtjava;

import java.util.ArrayList;
import java.util.List;

public class DefaultTestResult implements TestResult {

    private final Test test;
    private List<AssertionResult> assertionResults = new ArrayList<>();

    public DefaultTestResult(Test test, List<AssertionResult> assertionResults) {
        this.test = test;
        this.assertionResults.addAll(assertionResults);
    }

    @Override
    public Test getTest() {
        return test;
    }

    @Override
    public List<AssertionResult> getAssertionFailures() {
        List<AssertionResult> retVal = new ArrayList<>();

        for (AssertionResult result : assertionResults) {
            if (!result.wasSuccessful()) {
                retVal.add(result);
            }
        }

        return retVal;
    }

    @Override
    public boolean wasSuccessful() {
        return getAssertionFailures().size() == 0;
    }
}

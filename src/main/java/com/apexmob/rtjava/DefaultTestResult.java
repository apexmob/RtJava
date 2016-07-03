package com.apexmob.rtjava;

import java.util.ArrayList;
import java.util.List;

public class DefaultTestResult implements TestResult {

    private final Test test;
    private List<AssertionResult> assertionResults = new ArrayList<>();

    public DefaultTestResult(Test test) {
        this.test = test;
    }

    @Override
    public Test getTest() {
        return test;
    }

    @Override
    public void addAssertionResult(AssertionResult assertionResult) {
        assertionResults.add(assertionResult);
    }

    @Override
    public List<AssertionResult> getAssertionResults() {
        return new ArrayList<>(this.assertionResults);
    }


}

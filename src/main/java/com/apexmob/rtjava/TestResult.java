package com.apexmob.rtjava;

import java.util.List;

public interface TestResult {

    Test getTest();

    void addAssertionResult(AssertionResult assertionResult);

    List<AssertionResult> getAssertionResults();

}
